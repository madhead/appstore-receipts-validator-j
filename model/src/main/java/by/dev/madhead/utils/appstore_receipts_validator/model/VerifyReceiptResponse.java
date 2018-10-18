package by.dev.madhead.utils.appstore_receipts_validator.model;

import by.dev.madhead.utils.appstore_receipts_validator.mapper.VerifyReceiptResponseStatusDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;

import java.util.List;
import java.util.Objects;

public class VerifyReceiptResponse {
    @JsonProperty("status")
    private Status status;

    @JsonProperty("receipt")
    private Receipt receipt;

    @JsonProperty("latest_receipt")
    private String latestReceipt;

    @JsonProperty("latest_receipt_info")
    private List<InApp> latestReceiptInfo;

    @JsonProperty("latest_expired_receipt_info")
    private Receipt latestExpiredReceiptInfo;

    @JsonProperty("pending_renewal_info")
    private List<PendingRenewal> pendingRenewalInfo;

    @JsonProperty("is-retryable")
    private Boolean retryable;

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(final Receipt receipt) {
        this.receipt = receipt;
    }

    public String getLatestReceipt() {
        return latestReceipt;
    }

    public void setLatestReceipt(final String latestReceipt) {
        this.latestReceipt = latestReceipt;
    }

    public List<InApp> getLatestReceiptInfo() {
        return latestReceiptInfo;
    }

    public void setLatestReceiptInfo(final List<InApp> latestReceiptInfo) {
        this.latestReceiptInfo = latestReceiptInfo;
    }

    public Receipt getLatestExpiredReceiptInfo() {
        return latestExpiredReceiptInfo;
    }

    public void setLatestExpiredReceiptInfo(final Receipt latestExpiredReceiptInfo) {
        this.latestExpiredReceiptInfo = latestExpiredReceiptInfo;
    }

    public List<PendingRenewal> getPendingRenewalInfo() {
        return pendingRenewalInfo;
    }

    public void setPendingRenewalInfo(final List<PendingRenewal> pendingRenewalInfo) {
        this.pendingRenewalInfo = pendingRenewalInfo;
    }

    public Boolean getRetryable() {
        return retryable;
    }

    public void setRetryable(final Boolean retryable) {
        this.retryable = retryable;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final VerifyReceiptResponse that = (VerifyReceiptResponse) o;

        return status == that.status &&
               Objects.equals(receipt, that.receipt) &&
               Objects.equals(latestReceipt, that.latestReceipt) &&
               Objects.equals(latestReceiptInfo, that.latestReceiptInfo) &&
               Objects.equals(latestExpiredReceiptInfo, that.latestExpiredReceiptInfo) &&
               Objects.equals(pendingRenewalInfo, that.pendingRenewalInfo) &&
               Objects.equals(retryable, that.retryable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, receipt, latestReceipt, latestReceiptInfo, latestExpiredReceiptInfo, pendingRenewalInfo, retryable);
    }

    @Override
    public String toString() {
        return MoreObjects
            .toStringHelper(this)
            .add("status", status)
            .add("receipt", receipt)
            .add("latestReceipt", latestReceipt)
            .add("latestReceiptInfo", latestReceiptInfo)
            .add("latestExpiredReceiptInfo", latestExpiredReceiptInfo)
            .add("pendingRenewalInfo", pendingRenewalInfo)
            .add("retryable", retryable)
            .toString();
    }

    @JsonDeserialize(using = VerifyReceiptResponseStatusDeserializer.class)
    public enum Status {
        VALID,                      // 0
        INVALID_JSON,               // 21000
        INVALID_RECEIPT_DATA,       // 21002
        AUTHENTICATION_ERROR,       // 21003
        INVALID_SHARED_SECRET,      // 21004
        RECEIPT_SERVER_UNAVAILABLE, // 21005
        SUBSCRIPTION_EXPIRED,       // 21006
        WRONG_ENVIRONMENT,          // 21007, 21008
        AUTHORIZATION_ERROR,        // 21010
        INTERNAL_ERROR              // 21100-21199
    }
}
