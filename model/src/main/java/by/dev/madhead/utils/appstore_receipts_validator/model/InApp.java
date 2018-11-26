package by.dev.madhead.utils.appstore_receipts_validator.model;

import by.dev.madhead.utils.appstore_receipts_validator.mapper.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.StringJoiner;

public final class InApp {
    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("product_id")
    private String productId;

    @JsonProperty("transaction_id")
    private String transactionId;

    @JsonProperty("original_transaction_id")
    private String originalTransactionId;

    @JsonProperty("purchase_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss VV")
    private ZonedDateTime purchaseDate;

    @JsonProperty("original_purchase_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss VV")
    private ZonedDateTime originalPurchaseDate;

    @JsonProperty("expires_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss VV")
    private ZonedDateTime expiresDate;

    @JsonProperty("expiration_intent")
    private ExpirationIntent expirationIntent;

    @JsonProperty("is_in_billing_retry_period")
    @JsonDeserialize(using = InAppBillingRetryPeriodDeserializer.class)
    private Boolean inBillingRetryPeriod;

    @JsonProperty("is_trial_period")
    private Boolean trialPeriod;

    @JsonProperty("is_in_intro_offer_period")
    private Boolean inIntroOfferPeriod;

    @JsonProperty("cancellation_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss VV")
    private ZonedDateTime cancellationDate;

    @JsonProperty("cancellation_reason")
    private CancellationReason cancellationReason;

    @JsonProperty("app_item_id")
    private String appItemId;

    @JsonProperty("version_external_identifier")
    private String versionExternalIdentifier;

    @JsonProperty("web_order_line_item_id")
    private String webOrderLineItemId;

    @JsonProperty("auto_renew_status")
    private AutoRenewStatus autoRenewStatus;

    @JsonProperty("auto_renew_product_id")
    private String autoRenewProductId;

    @JsonProperty("price_consent_status")
    private PriceConsentStatus priceConsentStatus;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(final String productId) {
        this.productId = productId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(final String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOriginalTransactionId() {
        return originalTransactionId;
    }

    public void setOriginalTransactionId(final String originalTransactionId) {
        this.originalTransactionId = originalTransactionId;
    }

    public ZonedDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(final ZonedDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public ZonedDateTime getOriginalPurchaseDate() {
        return originalPurchaseDate;
    }

    public void setOriginalPurchaseDate(final ZonedDateTime originalPurchaseDate) {
        this.originalPurchaseDate = originalPurchaseDate;
    }

    public ZonedDateTime getExpiresDate() {
        return expiresDate;
    }

    public void setExpiresDate(final ZonedDateTime expiresDate) {
        this.expiresDate = expiresDate;
    }

    public ExpirationIntent getExpirationIntent() {
        return expirationIntent;
    }

    public void setExpirationIntent(final ExpirationIntent expirationIntent) {
        this.expirationIntent = expirationIntent;
    }

    public Boolean getInBillingRetryPeriod() {
        return inBillingRetryPeriod;
    }

    public void setInBillingRetryPeriod(final Boolean inBillingRetryPeriod) {
        this.inBillingRetryPeriod = inBillingRetryPeriod;
    }

    public Boolean getTrialPeriod() {
        return trialPeriod;
    }

    public void setTrialPeriod(final Boolean trialPeriod) {
        this.trialPeriod = trialPeriod;
    }

    public Boolean getInIntroOfferPeriod() {
        return inIntroOfferPeriod;
    }

    public void setInIntroOfferPeriod(final Boolean inIntroOfferPeriod) {
        this.inIntroOfferPeriod = inIntroOfferPeriod;
    }

    public ZonedDateTime getCancellationDate() {
        return cancellationDate;
    }

    public void setCancellationDate(final ZonedDateTime cancellationDate) {
        this.cancellationDate = cancellationDate;
    }

    public CancellationReason getCancellationReason() {
        return cancellationReason;
    }

    public void setCancellationReason(final CancellationReason cancellationReason) {
        this.cancellationReason = cancellationReason;
    }

    public String getAppItemId() {
        return appItemId;
    }

    public void setAppItemId(final String appItemId) {
        this.appItemId = appItemId;
    }

    public String getVersionExternalIdentifier() {
        return versionExternalIdentifier;
    }

    public void setVersionExternalIdentifier(final String versionExternalIdentifier) {
        this.versionExternalIdentifier = versionExternalIdentifier;
    }

    public String getWebOrderLineItemId() {
        return webOrderLineItemId;
    }

    public void setWebOrderLineItemId(final String webOrderLineItemId) {
        this.webOrderLineItemId = webOrderLineItemId;
    }

    public AutoRenewStatus getAutoRenewStatus() {
        return autoRenewStatus;
    }

    public void setAutoRenewStatus(final AutoRenewStatus autoRenewStatus) {
        this.autoRenewStatus = autoRenewStatus;
    }

    public String getAutoRenewProductId() {
        return autoRenewProductId;
    }

    public void setAutoRenewProductId(final String autoRenewProductId) {
        this.autoRenewProductId = autoRenewProductId;
    }

    public PriceConsentStatus getPriceConsentStatus() {
        return priceConsentStatus;
    }

    public void setPriceConsentStatus(final PriceConsentStatus priceConsentStatus) {
        this.priceConsentStatus = priceConsentStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final InApp inApp = (InApp) o;

        return Objects.equals(quantity, inApp.quantity) &&
               Objects.equals(productId, inApp.productId) &&
               Objects.equals(transactionId, inApp.transactionId) &&
               Objects.equals(originalTransactionId, inApp.originalTransactionId) &&
               Objects.equals(purchaseDate, inApp.purchaseDate) &&
               Objects.equals(originalPurchaseDate, inApp.originalPurchaseDate) &&
               Objects.equals(expiresDate, inApp.expiresDate) &&
               expirationIntent == inApp.expirationIntent &&
               Objects.equals(inBillingRetryPeriod, inApp.inBillingRetryPeriod) &&
               Objects.equals(trialPeriod, inApp.trialPeriod) &&
               Objects.equals(inIntroOfferPeriod, inApp.inIntroOfferPeriod) &&
               Objects.equals(cancellationDate, inApp.cancellationDate) &&
               cancellationReason == inApp.cancellationReason &&
               Objects.equals(appItemId, inApp.appItemId) &&
               Objects.equals(versionExternalIdentifier, inApp.versionExternalIdentifier) &&
               Objects.equals(webOrderLineItemId, inApp.webOrderLineItemId) &&
               autoRenewStatus == inApp.autoRenewStatus &&
               Objects.equals(autoRenewProductId, inApp.autoRenewProductId) &&
               priceConsentStatus == inApp.priceConsentStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            quantity,
            productId,
            transactionId,
            originalTransactionId,
            purchaseDate,
            originalPurchaseDate,
            expiresDate,
            expirationIntent,
            inBillingRetryPeriod,
            trialPeriod,
            inIntroOfferPeriod,
            cancellationDate,
            cancellationReason,
            appItemId,
            versionExternalIdentifier,
            webOrderLineItemId,
            autoRenewStatus,
            autoRenewProductId,
            priceConsentStatus
        );
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", InApp.class.getSimpleName() + "[", "]")
            .add("quantity=" + quantity)
            .add("productId='" + productId + "'")
            .add("transactionId='" + transactionId + "'")
            .add("originalTransactionId='" + originalTransactionId + "'")
            .add("purchaseDate=" + purchaseDate)
            .add("originalPurchaseDate=" + originalPurchaseDate)
            .add("expiresDate=" + expiresDate)
            .add("expirationIntent=" + expirationIntent)
            .add("inBillingRetryPeriod=" + inBillingRetryPeriod)
            .add("trialPeriod=" + trialPeriod)
            .add("inIntroOfferPeriod=" + inIntroOfferPeriod)
            .add("cancellationDate=" + cancellationDate)
            .add("cancellationReason=" + cancellationReason)
            .add("appItemId='" + appItemId + "'")
            .add("versionExternalIdentifier='" + versionExternalIdentifier + "'")
            .add("webOrderLineItemId='" + webOrderLineItemId + "'")
            .add("autoRenewStatus=" + autoRenewStatus)
            .add("autoRenewProductId='" + autoRenewProductId + "'")
            .add("priceConsentStatus=" + priceConsentStatus)
            .toString();
    }

    @JsonDeserialize(using = InAppExpirationIntentDeserializer.class)
    public enum ExpirationIntent {
        CUSTOMER_CANCELED,       // 1
        BILLING_ERROR,           // 2
        CUSTOMER_DECLINED_PRICE, // 3
        PRODUCT_NOT_AVAILABLE,   // 4
        UNKNOWN_ERROR            // 5
    }

    @JsonDeserialize(using = InAppCancellationReasonDeserializer.class)
    public enum CancellationReason {
        ISSUE,          // 1
        ANOTHER_REASON  // 0
    }

    @JsonDeserialize(using = InAppAutoRenewStatusDeserializer.class)
    public enum AutoRenewStatus {
        ON, // 1
        OFF // 0
    }

    @JsonDeserialize(using = InAppPriceConsentStatusDeserializer.class)
    public enum PriceConsentStatus {
        AGREED,     // 1
        NO_ACTION   // 0
    }
}
