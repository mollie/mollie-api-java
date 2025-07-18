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
 * PendingBalance
 * 
 * <p>The pending balance. Only available if grouping is `status-balances`.
 */
public class PendingBalance {

    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("open")
    private Optional<? extends GetBalanceReportBalancesOpen> open;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("close")
    private Optional<? extends GetBalanceReportBalancesClose> close;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("pending")
    private Optional<? extends Pending> pending;


    @JsonInclude(Include.NON_ABSENT)
    @JsonProperty("movedToAvailable")
    private Optional<? extends MovedToAvailable> movedToAvailable;

    @JsonCreator
    public PendingBalance(
            @JsonProperty("open") Optional<? extends GetBalanceReportBalancesOpen> open,
            @JsonProperty("close") Optional<? extends GetBalanceReportBalancesClose> close,
            @JsonProperty("pending") Optional<? extends Pending> pending,
            @JsonProperty("movedToAvailable") Optional<? extends MovedToAvailable> movedToAvailable) {
        Utils.checkNotNull(open, "open");
        Utils.checkNotNull(close, "close");
        Utils.checkNotNull(pending, "pending");
        Utils.checkNotNull(movedToAvailable, "movedToAvailable");
        this.open = open;
        this.close = close;
        this.pending = pending;
        this.movedToAvailable = movedToAvailable;
    }
    
    public PendingBalance() {
        this(Optional.empty(), Optional.empty(), Optional.empty(),
            Optional.empty());
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetBalanceReportBalancesOpen> open() {
        return (Optional<GetBalanceReportBalancesOpen>) open;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<GetBalanceReportBalancesClose> close() {
        return (Optional<GetBalanceReportBalancesClose>) close;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<Pending> pending() {
        return (Optional<Pending>) pending;
    }

    @SuppressWarnings("unchecked")
    @JsonIgnore
    public Optional<MovedToAvailable> movedToAvailable() {
        return (Optional<MovedToAvailable>) movedToAvailable;
    }

    public static Builder builder() {
        return new Builder();
    }


    public PendingBalance withOpen(GetBalanceReportBalancesOpen open) {
        Utils.checkNotNull(open, "open");
        this.open = Optional.ofNullable(open);
        return this;
    }


    public PendingBalance withOpen(Optional<? extends GetBalanceReportBalancesOpen> open) {
        Utils.checkNotNull(open, "open");
        this.open = open;
        return this;
    }

    public PendingBalance withClose(GetBalanceReportBalancesClose close) {
        Utils.checkNotNull(close, "close");
        this.close = Optional.ofNullable(close);
        return this;
    }


    public PendingBalance withClose(Optional<? extends GetBalanceReportBalancesClose> close) {
        Utils.checkNotNull(close, "close");
        this.close = close;
        return this;
    }

    public PendingBalance withPending(Pending pending) {
        Utils.checkNotNull(pending, "pending");
        this.pending = Optional.ofNullable(pending);
        return this;
    }


    public PendingBalance withPending(Optional<? extends Pending> pending) {
        Utils.checkNotNull(pending, "pending");
        this.pending = pending;
        return this;
    }

    public PendingBalance withMovedToAvailable(MovedToAvailable movedToAvailable) {
        Utils.checkNotNull(movedToAvailable, "movedToAvailable");
        this.movedToAvailable = Optional.ofNullable(movedToAvailable);
        return this;
    }


    public PendingBalance withMovedToAvailable(Optional<? extends MovedToAvailable> movedToAvailable) {
        Utils.checkNotNull(movedToAvailable, "movedToAvailable");
        this.movedToAvailable = movedToAvailable;
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
        PendingBalance other = (PendingBalance) o;
        return 
            Utils.enhancedDeepEquals(this.open, other.open) &&
            Utils.enhancedDeepEquals(this.close, other.close) &&
            Utils.enhancedDeepEquals(this.pending, other.pending) &&
            Utils.enhancedDeepEquals(this.movedToAvailable, other.movedToAvailable);
    }
    
    @Override
    public int hashCode() {
        return Utils.enhancedHash(
            open, close, pending,
            movedToAvailable);
    }
    
    @Override
    public String toString() {
        return Utils.toString(PendingBalance.class,
                "open", open,
                "close", close,
                "pending", pending,
                "movedToAvailable", movedToAvailable);
    }

    @SuppressWarnings("UnusedReturnValue")
    public final static class Builder {

        private Optional<? extends GetBalanceReportBalancesOpen> open = Optional.empty();

        private Optional<? extends GetBalanceReportBalancesClose> close = Optional.empty();

        private Optional<? extends Pending> pending = Optional.empty();

        private Optional<? extends MovedToAvailable> movedToAvailable = Optional.empty();

        private Builder() {
          // force use of static builder() method
        }


        public Builder open(GetBalanceReportBalancesOpen open) {
            Utils.checkNotNull(open, "open");
            this.open = Optional.ofNullable(open);
            return this;
        }

        public Builder open(Optional<? extends GetBalanceReportBalancesOpen> open) {
            Utils.checkNotNull(open, "open");
            this.open = open;
            return this;
        }


        public Builder close(GetBalanceReportBalancesClose close) {
            Utils.checkNotNull(close, "close");
            this.close = Optional.ofNullable(close);
            return this;
        }

        public Builder close(Optional<? extends GetBalanceReportBalancesClose> close) {
            Utils.checkNotNull(close, "close");
            this.close = close;
            return this;
        }


        public Builder pending(Pending pending) {
            Utils.checkNotNull(pending, "pending");
            this.pending = Optional.ofNullable(pending);
            return this;
        }

        public Builder pending(Optional<? extends Pending> pending) {
            Utils.checkNotNull(pending, "pending");
            this.pending = pending;
            return this;
        }


        public Builder movedToAvailable(MovedToAvailable movedToAvailable) {
            Utils.checkNotNull(movedToAvailable, "movedToAvailable");
            this.movedToAvailable = Optional.ofNullable(movedToAvailable);
            return this;
        }

        public Builder movedToAvailable(Optional<? extends MovedToAvailable> movedToAvailable) {
            Utils.checkNotNull(movedToAvailable, "movedToAvailable");
            this.movedToAvailable = movedToAvailable;
            return this;
        }

        public PendingBalance build() {

            return new PendingBalance(
                open, close, pending,
                movedToAvailable);
        }

    }
}
