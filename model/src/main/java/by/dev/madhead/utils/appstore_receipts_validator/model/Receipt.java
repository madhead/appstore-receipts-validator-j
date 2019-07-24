package by.dev.madhead.utils.appstore_receipts_validator.model;

import by.dev.madhead.utils.appstore_receipts_validator.mapper.ReceiptReceiptTypeDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public final class Receipt {
    @JsonProperty("adam_id")
    private Long adamId;

    @JsonProperty("app_item_id")
    private Long appItemId;

    @JsonProperty("application_version")
    private String applicationVersion;

    @JsonProperty("bundle_id")
    private String bundleId;

    @JsonProperty("download_id")
    private Long downloadId;

    @JsonProperty("expiration_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss VV")
    private ZonedDateTime expirationDate;

    @JsonProperty("expiration_date_ms")
    private Long expirationDateMs;

    @JsonProperty("expiration_date_pst")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss VV")
    private ZonedDateTime expirationDatePst;

    @JsonProperty("in_app")
    private List<InApp> inApp;

    @JsonProperty("original_application_version")
    private String originalApplicationVersion;

    @JsonProperty("original_purchase_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss VV")
    private ZonedDateTime originalPurchaseDate;

    @JsonProperty("original_purchase_date_ms")
    private Long originalPurchaseDateMs;

    @JsonProperty("original_purchase_date_pst")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss VV")
    private ZonedDateTime originalPurchaseDatePst;

    @JsonProperty("receipt_creation_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss VV")
    private ZonedDateTime receiptCreationDate;

    @JsonProperty("receipt_creation_date_ms")
    private Long receiptCreationDateMs;

    @JsonProperty("receipt_creation_date_pst")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss VV")
    private ZonedDateTime receiptCreationDatePst;

    @JsonProperty("receipt_type")
    private ReceiptType receiptType;

    @JsonProperty("request_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss VV")
    private ZonedDateTime requestDate;

    @JsonProperty("request_date_ms")
    private Long requestDateMs;

    @JsonProperty("request_date_pst")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss VV")
    private ZonedDateTime requestDatePst;

    @JsonProperty("version_external_identifier")
    private Long versionExternalIdentifier;

    public Long getAdamId() {
        return adamId;
    }

    public void setAdamId(Long adamId) {
        this.adamId = adamId;
    }

    public Long getAppItemId() {
        return appItemId;
    }

    public void setAppItemId(Long appItemId) {
        this.appItemId = appItemId;
    }

    public String getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public String getBundleId() {
        return bundleId;
    }

    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }

    public Long getDownloadId() {
        return downloadId;
    }

    public void setDownloadId(Long downloadId) {
        this.downloadId = downloadId;
    }

    public ZonedDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(ZonedDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Long getExpirationDateMs() {
        return expirationDateMs;
    }

    public void setExpirationDateMs(Long expirationDateMs) {
        this.expirationDateMs = expirationDateMs;
    }

    public ZonedDateTime getExpirationDatePst() {
        return expirationDatePst;
    }

    public void setExpirationDatePst(ZonedDateTime expirationDatePst) {
        this.expirationDatePst = expirationDatePst;
    }

    public List<InApp> getInApp() {
        return inApp;
    }

    public void setInApp(List<InApp> inApp) {
        this.inApp = inApp;
    }

    public String getOriginalApplicationVersion() {
        return originalApplicationVersion;
    }

    public void setOriginalApplicationVersion(String originalApplicationVersion) {
        this.originalApplicationVersion = originalApplicationVersion;
    }

    public ZonedDateTime getOriginalPurchaseDate() {
        return originalPurchaseDate;
    }

    public void setOriginalPurchaseDate(ZonedDateTime originalPurchaseDate) {
        this.originalPurchaseDate = originalPurchaseDate;
    }

    public Long getOriginalPurchaseDateMs() {
        return originalPurchaseDateMs;
    }

    public void setOriginalPurchaseDateMs(Long originalPurchaseDateMs) {
        this.originalPurchaseDateMs = originalPurchaseDateMs;
    }

    public ZonedDateTime getOriginalPurchaseDatePst() {
        return originalPurchaseDatePst;
    }

    public void setOriginalPurchaseDatePst(ZonedDateTime originalPurchaseDatePst) {
        this.originalPurchaseDatePst = originalPurchaseDatePst;
    }

    public ZonedDateTime getReceiptCreationDate() {
        return receiptCreationDate;
    }

    public void setReceiptCreationDate(ZonedDateTime receiptCreationDate) {
        this.receiptCreationDate = receiptCreationDate;
    }

    public Long getReceiptCreationDateMs() {
        return receiptCreationDateMs;
    }

    public void setReceiptCreationDateMs(Long receiptCreationDateMs) {
        this.receiptCreationDateMs = receiptCreationDateMs;
    }

    public ZonedDateTime getReceiptCreationDatePst() {
        return receiptCreationDatePst;
    }

    public void setReceiptCreationDatePst(ZonedDateTime receiptCreationDatePst) {
        this.receiptCreationDatePst = receiptCreationDatePst;
    }

    public ReceiptType getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(ReceiptType receiptType) {
        this.receiptType = receiptType;
    }

    public ZonedDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(ZonedDateTime requestDate) {
        this.requestDate = requestDate;
    }

    public Long getRequestDateMs() {
        return requestDateMs;
    }

    public void setRequestDateMs(Long requestDateMs) {
        this.requestDateMs = requestDateMs;
    }

    public ZonedDateTime getRequestDatePst() {
        return requestDatePst;
    }

    public void setRequestDatePst(ZonedDateTime requestDatePst) {
        this.requestDatePst = requestDatePst;
    }

    public Long getVersionExternalIdentifier() {
        return versionExternalIdentifier;
    }

    public void setVersionExternalIdentifier(Long versionExternalIdentifier) {
        this.versionExternalIdentifier = versionExternalIdentifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt receipt = (Receipt) o;
        return Objects.equals(adamId, receipt.adamId) &&
            Objects.equals(appItemId, receipt.appItemId) &&
            Objects.equals(applicationVersion, receipt.applicationVersion) &&
            Objects.equals(bundleId, receipt.bundleId) &&
            Objects.equals(downloadId, receipt.downloadId) &&
            Objects.equals(expirationDate, receipt.expirationDate) &&
            Objects.equals(expirationDateMs, receipt.expirationDateMs) &&
            Objects.equals(expirationDatePst, receipt.expirationDatePst) &&
            Objects.equals(inApp, receipt.inApp) &&
            Objects.equals(originalApplicationVersion, receipt.originalApplicationVersion) &&
            Objects.equals(originalPurchaseDate, receipt.originalPurchaseDate) &&
            Objects.equals(originalPurchaseDateMs, receipt.originalPurchaseDateMs) &&
            Objects.equals(originalPurchaseDatePst, receipt.originalPurchaseDatePst) &&
            Objects.equals(receiptCreationDate, receipt.receiptCreationDate) &&
            Objects.equals(receiptCreationDateMs, receipt.receiptCreationDateMs) &&
            Objects.equals(receiptCreationDatePst, receipt.receiptCreationDatePst) &&
            receiptType == receipt.receiptType &&
            Objects.equals(requestDate, receipt.requestDate) &&
            Objects.equals(requestDateMs, receipt.requestDateMs) &&
            Objects.equals(requestDatePst, receipt.requestDatePst) &&
            Objects.equals(versionExternalIdentifier, receipt.versionExternalIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            adamId,
            appItemId,
            applicationVersion,
            bundleId,
            downloadId,
            expirationDate,
            expirationDateMs,
            expirationDatePst,
            inApp,
            originalApplicationVersion,
            originalPurchaseDate,
            originalPurchaseDateMs,
            originalPurchaseDatePst,
            receiptCreationDate,
            receiptCreationDateMs,
            receiptCreationDatePst,
            receiptType,
            requestDate,
            requestDateMs,
            requestDatePst,
            versionExternalIdentifier
        );
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Receipt.class.getSimpleName() + "[", "]")
            .add("adamId=" + adamId)
            .add("appItemId=" + appItemId)
            .add("applicationVersion='" + applicationVersion + "'")
            .add("bundleId='" + bundleId + "'")
            .add("downloadId=" + downloadId)
            .add("expirationDate=" + expirationDate)
            .add("expirationDateMs=" + expirationDateMs)
            .add("expirationDatePst=" + expirationDatePst)
            .add("inApp=" + inApp)
            .add("originalApplicationVersion='" + originalApplicationVersion + "'")
            .add("originalPurchaseDate=" + originalPurchaseDate)
            .add("originalPurchaseDateMs=" + originalPurchaseDateMs)
            .add("originalPurchaseDatePst=" + originalPurchaseDatePst)
            .add("receiptCreationDate=" + receiptCreationDate)
            .add("receiptCreationDateMs=" + receiptCreationDateMs)
            .add("receiptCreationDatePst=" + receiptCreationDatePst)
            .add("receiptType=" + receiptType)
            .add("requestDate=" + requestDate)
            .add("requestDateMs=" + requestDateMs)
            .add("requestDatePst=" + requestDatePst)
            .add("versionExternalIdentifier=" + versionExternalIdentifier)
            .toString();
    }

    @JsonDeserialize(using = ReceiptReceiptTypeDeserializer.class)
    public enum ReceiptType {
        PRODUCTION,
        PRODUCTIONVPP,
        PRODUCTIONSANDBOX,
        PRODUCTIONVPPSANDBOX
    }
}
