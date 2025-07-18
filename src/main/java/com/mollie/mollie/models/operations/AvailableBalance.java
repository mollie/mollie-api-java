/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.mollie.mollie.models.operations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mollie.mollie.utils.Utils;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Optional;

/**
 * AvailableBalance
 * 
 * <p>The available balance. Only available if grouping is `status-balances`.
 */
public class AvailableBalance {

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("open")
    private Optional<? extends GetBalanceReportOpen> open;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("movedFromPending")
    private Optional<? extends MovedFromPending> movedFromPending;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("immediatelyAvailable")
    private Optional<? extends ImmediatelyAvailable> immediatelyAvailable;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("close")
    private Optional<? extends GetBalanceReportClose> close;

    @JsonCreator
    public AvailableBalance(
            @JsonProperty("open") Optional<? extends GetBalanceReportOpen> open,
            @JsonProperty("movedFromPending") Optional<? extends MovedFromPending> movedFromPending,
            @JsonProperty("immediatelyAvailable") Optional<? extends ImmediatelyAvailable> immediatelyAvailable,
            @JsonProperty("close") Optional<? extends GetBalanceReportClose> close) {
        Utils.checkNotNull(open, "open");
        Utils.checkNotNull(movedFromPending, "movedFromPending");
        Utils.checkNotNull(immediatelyAvailable, "immediatelyAvailable");
        Utils.checkNotNull(close, "close");
        this.open = open;
        this.movedFromPending = movedFromPending;
        this.immediatelyAvailable = immediatelyAvailable;
        this.close = close;
    }
    
    public AvailableBalance() {
        this(Optional.empty(), Optional.empty(), Optional.empty(),
            Optional.empty());
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetBalanceReportOpen> open() {
        return (Optional<GetBalanceReportOpen>) open;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<MovedFromPending> movedFromPending() {
        return (Optional<MovedFromPending>) movedFromPending;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<ImmediatelyAvailable> immediatelyAvailable() {
        return (Optional<ImmediatelyAvailable>) immediatelyAvailable;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetBalanceReportClose> close() {
        return (Optional<GetBalanceReportClose>) close;
    }

    public static Builder builder() {
        return new Builder();
    }


    public AvailableBalance withOpen(GetBalanceReportOpen open) {
        Utils.checkNotNull(open, "open");
        this.open = Optional.ofNullable(open);
        return this;
    }


    public AvailableBalance withOpen(Optional<? extends GetBalanceReportOpen> open) {
        Utils.checkNotNull(open, "open");
        this.open = open;
        return this;
    }

    public AvailableBalance withMovedFromPending(MovedFromPending movedFromPending) {
        Utils.checkNotNull(movedFromPending, "movedFromPending");
        this.movedFromPending = Optional.ofNullable(movedFromPending);
        return this;
    }


    public AvailableBalance withMovedFromPending(Optional<? extends MovedFromPending> movedFromPending) {
        Utils.checkNotNull(movedFromPending, "movedFromPending");
        this.movedFromPending = movedFromPending;
        return this;
    }

    public AvailableBalance withImmediatelyAvailable(ImmediatelyAvailable immediatelyAvailable) {
        Utils.checkNotNull(immediatelyAvailable, "immediatelyAvailable");
        this.immediatelyAvailable = Optional.ofNullable(immediatelyAvailable);
        return this;
    }


    public AvailableBalance withImmediatelyAvailable(Optional<? extends ImmediatelyAvailable> immediatelyAvailable) {
        Utils.checkNotNull(immediatelyAvailable, "immediatelyAvailable");
        this.immediatelyAvailable = immediatelyAvailable;
        return this;
    }

    public AvailableBalance withClose(GetBalanceReportClose close) {
        Utils.checkNotNull(close, "close");
        this.close = Optional.ofNullable(close);
        return this;
    }


    public AvailableBalance withClose(Optional<? extends GetBalanceReportClose> close) {
        Utils.checkNotNull(close, "close");
        this.close = close;
        return this;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AvailableBalance other = (AvailableBalance) o;
        return 
            Utils.enhancedDeepEquals(this.open, other.open) &&
            Utils.enhancedDeepEquals(this.movedFromPending, other.movedFromPending) &&
            Utils.enhancedDeepEquals(this.immediatelyAvailable, other.immediatelyAvailable) &&
            Utils.enhancedDeepEquals(this.close, other.close);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            open, movedFromPending, immediatelyAvailable,
            close);
    }
    
    @Override
    public String toString() {
        return Utils.toString(AvailableBalance.class,
                "open", open,
                "movedFromPending", movedFromPending,
                "immediatelyAvailable", immediatelyAvailable,
                "close", close);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<? extends GetBalanceReportOpen> open = Optional.empty();

        private Optional<? extends MovedFromPending> movedFromPending = Optional.empty();

        private Optional<? extends ImmediatelyAvailable> immediatelyAvailable = Optional.empty();

        private Optional<? extends GetBalanceReportClose> close = Optional.empty();

        private Builder() {
          // force use of static builder() method
        }


        public Builder open(GetBalanceReportOpen open) {
            Utils.checkNotNull(open, "open");
            this.open = Optional.ofNullable(open);
            return this;
        }

        public Builder open(Optional<? extends GetBalanceReportOpen> open) {
            Utils.checkNotNull(open, "open");
            this.open = open;
            return this;
        }


        public Builder movedFromPending(MovedFromPending movedFromPending) {
            Utils.checkNotNull(movedFromPending, "movedFromPending");
            this.movedFromPending = Optional.ofNullable(movedFromPending);
            return this;
        }

        public Builder movedFromPending(Optional<? extends MovedFromPending> movedFromPending) {
            Utils.checkNotNull(movedFromPending, "movedFromPending");
            this.movedFromPending = movedFromPending;
            return this;
        }


        public Builder immediatelyAvailable(ImmediatelyAvailable immediatelyAvailable) {
            Utils.checkNotNull(immediatelyAvailable, "immediatelyAvailable");
            this.immediatelyAvailable = Optional.ofNullable(immediatelyAvailable);
            return this;
        }

        public Builder immediatelyAvailable(Optional<? extends ImmediatelyAvailable> immediatelyAvailable) {
            Utils.checkNotNull(immediatelyAvailable, "immediatelyAvailable");
            this.immediatelyAvailable = immediatelyAvailable;
            return this;
        }


        public Builder close(GetBalanceReportClose close) {
            Utils.checkNotNull(close, "close");
            this.close = Optional.ofNullable(close);
            return this;
        }

        public Builder close(Optional<? extends GetBalanceReportClose> close) {
            Utils.checkNotNull(close, "close");
            this.close = close;
            return this;
        }

        public AvailableBalance build() {

            return new AvailableBalance(
                open, movedFromPending, immediatelyAvailable,
                close);
        }

    }
}
