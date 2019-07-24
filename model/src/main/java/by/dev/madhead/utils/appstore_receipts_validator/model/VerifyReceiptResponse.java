package by.dev.madhead.utils.appstore_receipts_validator.model;

import by.dev.madhead.utils.appstore_receipts_validator.mapper.VerifyReceiptResponseEnvironmentDeserializer;
import by.dev.madhead.utils.appstore_receipts_validator.mapper.VerifyReceiptResponseStatusDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public final class VerifyReceiptResponse {
    @JsonProperty("environment")
    private Environment environment;

    @JsonProperty("is-retryable")
    private Boolean retryable;

    @JsonProperty("latest_receipt")
    private String latestReceipt;

    @JsonProperty("latest_receipt_info")
    private List<InApp> latestReceiptInfo;

    @JsonProperty("pending_renewal_info")
    private List<PendingRenewal> pendingRenewalInfo;

    @JsonProperty("receipt")
    private Receipt receipt;

    @JsonProperty("status")
    private Status status;

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public Boolean getRetryable() {
        return retryable;
    }

    public void setRetryable(Boolean retryable) {
        this.retryable = retryable;
    }

    public String getLatestReceipt() {
        return latestReceipt;
    }

    public void setLatestReceipt(String latestReceipt) {
        this.latestReceipt = latestReceipt;
    }

    public List<InApp> getLatestReceiptInfo() {
        return latestReceiptInfo;
    }

    public void setLatestReceiptInfo(List<InApp> latestReceiptInfo) {
        this.latestReceiptInfo = latestReceiptInfo;
    }

    public List<PendingRenewal> getPendingRenewalInfo() {
        return pendingRenewalInfo;
    }

    public void setPendingRenewalInfo(List<PendingRenewal> pendingRenewalInfo) {
        this.pendingRenewalInfo = pendingRenewalInfo;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VerifyReceiptResponse that = (VerifyReceiptResponse) o;
        return environment == that.environment &&
            Objects.equals(retryable, that.retryable) &&
            Objects.equals(latestReceipt, that.latestReceipt) &&
            Objects.equals(latestReceiptInfo, that.latestReceiptInfo) &&
            Objects.equals(pendingRenewalInfo, that.pendingRenewalInfo) &&
            Objects.equals(receipt, that.receipt) &&
            status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            environment,
            retryable,
            latestReceipt,
            latestReceiptInfo,
            pendingRenewalInfo,
            receipt,
            status
        );
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", VerifyReceiptResponse.class.getSimpleName() + "[", "]")
            .add("environment=" + environment)
            .add("retryable=" + retryable)
            .add("latestReceipt='" + latestReceipt + "'")
            .add("latestReceiptInfo=" + latestReceiptInfo)
            .add("pendingRenewalInfo=" + pendingRenewalInfo)
            .add("receipt=" + receipt)
            .add("status=" + status)
            .toString();
    }

    @JsonDeserialize(using = VerifyReceiptResponseEnvironmentDeserializer.class)
    public enum Environment {
        SANDBOX,
        PRODUCTION
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
