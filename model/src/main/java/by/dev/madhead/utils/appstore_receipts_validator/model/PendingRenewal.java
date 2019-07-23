package by.dev.madhead.utils.appstore_receipts_validator.model;

import by.dev.madhead.utils.appstore_receipts_validator.mapper.PendingRenewalPriceConsentStatusDeserializer;
import by.dev.madhead.utils.appstore_receipts_validator.mapper.PendingRenewalBillingRetryPeriodDeserializer;
import by.dev.madhead.utils.appstore_receipts_validator.mapper.PendingRenewalExpirationIntentDeserializer;
import by.dev.madhead.utils.appstore_receipts_validator.mapper.PendingRenewalAutoRenewStatusDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Objects;
import java.util.StringJoiner;

public final class PendingRenewal {

    @JsonProperty("auto_renew_product_id")
    private String autoRenewProductId;

    @JsonProperty("auto_renew_status")
    private AutoRenewStatus autoRenewStatus;

    @JsonProperty("expiration_intent")
    private ExpirationIntent expirationIntent;

    @JsonProperty("is_in_billing_retry_period")
    @JsonDeserialize(using = PendingRenewalBillingRetryPeriodDeserializer.class)
    private Boolean inBillingRetryPeriod;

    @JsonProperty("original_transaction_id")
    private String originalTransactionId;

    @JsonProperty("price_consent_status")
    private PriceConsentStatus priceConsentStatus;

    @JsonProperty("product_id")
    private String productId;

    public String getAutoRenewProductId() {
        return autoRenewProductId;
    }

    public void setAutoRenewProductId(String autoRenewProductId) {
        this.autoRenewProductId = autoRenewProductId;
    }

    public AutoRenewStatus getAutoRenewStatus() {
        return autoRenewStatus;
    }

    public void setAutoRenewStatus(AutoRenewStatus autoRenewStatus) {
        this.autoRenewStatus = autoRenewStatus;
    }

    public ExpirationIntent getExpirationIntent() {
        return expirationIntent;
    }

    public void setExpirationIntent(ExpirationIntent expirationIntent) {
        this.expirationIntent = expirationIntent;
    }

    public Boolean getInBillingRetryPeriod() {
        return inBillingRetryPeriod;
    }

    public void setInBillingRetryPeriod(Boolean inBillingRetryPeriod) {
        this.inBillingRetryPeriod = inBillingRetryPeriod;
    }

    public String getOriginalTransactionId() {
        return originalTransactionId;
    }

    public void setOriginalTransactionId(String originalTransactionId) {
        this.originalTransactionId = originalTransactionId;
    }

    public PriceConsentStatus getPriceConsentStatus() {
        return priceConsentStatus;
    }

    public void setPriceConsentStatus(PriceConsentStatus priceConsentStatus) {
        this.priceConsentStatus = priceConsentStatus;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PendingRenewal that = (PendingRenewal) o;
        return Objects.equals(autoRenewProductId, that.autoRenewProductId) &&
            autoRenewStatus == that.autoRenewStatus &&
            expirationIntent == that.expirationIntent &&
            Objects.equals(inBillingRetryPeriod, that.inBillingRetryPeriod) &&
            Objects.equals(originalTransactionId, that.originalTransactionId) &&
            Objects.equals(priceConsentStatus, that.priceConsentStatus) &&
            Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoRenewProductId, autoRenewStatus, expirationIntent, inBillingRetryPeriod, originalTransactionId, priceConsentStatus, productId);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PendingRenewal.class.getSimpleName() + "[", "]")
            .add("autoRenewProductId='" + autoRenewProductId + "'")
            .add("autoRenewStatus=" + autoRenewStatus)
            .add("expirationIntent=" + expirationIntent)
            .add("inBillingRetryPeriod=" + inBillingRetryPeriod)
            .add("originalTransactionId='" + originalTransactionId + "'")
            .add("priceConsentStatus='" + priceConsentStatus + "'")
            .add("productId='" + productId + "'")
            .toString();
    }

    @JsonDeserialize(using = PendingRenewalExpirationIntentDeserializer.class)
    public enum ExpirationIntent {
        CUSTOMER_CANCELED,       // 1
        BILLING_ERROR,           // 2
        CUSTOMER_DECLINED_PRICE, // 3
        PRODUCT_NOT_AVAILABLE,   // 4
        UNKNOWN_ERROR            // 5
    }

    @JsonDeserialize(using = PendingRenewalAutoRenewStatusDeserializer.class)
    public enum AutoRenewStatus {
        ON, // 1
        OFF // 0
    }

    @JsonDeserialize(using = PendingRenewalPriceConsentStatusDeserializer.class)
    public enum PriceConsentStatus {
        AGREED,     // 1
        NO_ACTION   // 0
    }

}

