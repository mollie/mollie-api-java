package com.mollie.mollie.utils.webhooks;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class SignatureValidator {
    public static final String SIGNATURE_HEADER = "X-Mollie-Signature";
    private static final String SIGNATURE_PREFIX = "sha256=";
    private static final String HMAC_ALGORITHM = "HmacSHA256";

    private final List<String> signingSecrets;

    public SignatureValidator(String signingSecret) {
        this(Collections.singletonList(signingSecret));
    }

    public SignatureValidator(List<String> signingSecrets) {
        this.signingSecrets = new ArrayList<>(Objects.requireNonNull(signingSecrets, "signingSecrets cannot be null"));
    }

    public static boolean validate(String payload, String signingSecret, String signature) {
        return validate(payload, Collections.singletonList(signingSecret),
                signature == null ? null : Collections.singletonList(signature));
    }

    public static boolean validate(String payload, List<String> signingSecrets, List<String> signatures) {
        return new SignatureValidator(signingSecrets).validatePayload(payload, signatures);
    }

    public boolean validatePayload(String payload, String signature) {
        return validatePayload(payload, signature == null ? null : Collections.singletonList(signature));
    }

    public boolean validatePayload(String payload, List<String> signatures) {
        List<String> signatureList = normalizeSignatures(signatures);
        if (signatureList.isEmpty()) {
            return false;
        }

        return validateSignatures(payload, signatureList);
    }

    private List<String> normalizeSignatures(List<String> signatures) {
        if (signatures == null) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();
        for (String signature : signatures) {
            if (signature != null && !signature.isEmpty()) {
                result.add(signature);
            }
        }
        return result;
    }

    private boolean validateSignatures(String payload, List<String> signatures) {
        for (String signature : signatures) {
            if (isValidSignature(extractSignature(signature), payload)) {
                return true;
            }
        }

        throw new InvalidSignatureException("Invalid webhook signature");
    }

    private String extractSignature(String signatureHeader) {
        if (signatureHeader.startsWith(SIGNATURE_PREFIX)) {
            return signatureHeader.substring(SIGNATURE_PREFIX.length());
        }
        return signatureHeader;
    }

    private boolean isValidSignature(String providedSignature, String payload) {
        for (String secret : signingSecrets) {
            String expectedSignature = createSignature(payload, secret);
            if (constantTimeEquals(expectedSignature, providedSignature)) {
                return true;
            }
        }
        return false;
    }

    public static String createSignature(String payload, String secret) {
        try {
            Mac mac = Mac.getInstance(HMAC_ALGORITHM);
            SecretKeySpec keySpec = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), HMAC_ALGORITHM);
            mac.init(keySpec);
            byte[] hash = mac.doFinal(payload.getBytes(StandardCharsets.UTF_8));
            return toHex(hash);
        } catch (NoSuchAlgorithmException | InvalidKeyException exception) {
            throw new IllegalStateException("Unable to create webhook signature", exception);
        }
    }

    private boolean constantTimeEquals(String left, String right) {
        int maxLength = Math.max(left.length(), right.length());
        int mismatch = left.length() ^ right.length();

        for (int index = 0; index < maxLength; index++) {
            int leftValue = index < left.length() ? left.charAt(index) : 0;
            int rightValue = index < right.length() ? right.charAt(index) : 0;
            mismatch |= leftValue ^ rightValue;
        }

        return mismatch == 0;
    }

    private static String toHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder(bytes.length * 2);
        for (byte value : bytes) {
            builder.append(String.format("%02x", value));
        }
        return builder.toString();
    }
}