package by.dev.madhead.utils.appstore_receipts_validator.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public final class Receipt {
    @JsonProperty("bundle_id")
    private String bundleId;

    @JsonProperty("application_version")
    private String applicationVersion;

    @JsonProperty("in_app")
    private List<InApp> inApp;

    @JsonProperty("original_application_version")
    private String originalApplicationVersion;

    @JsonProperty("receipt_creation_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss VV")
    private ZonedDateTime receiptCreationDate;

    @JsonProperty("expiration_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss VV")
    private ZonedDateTime expirationDate;

    public String getBundleId() {
        return bundleId;
    }

    public void setBundleId(final String bundleId) {
        this.bundleId = bundleId;
    }

    public String getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(final String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public List<InApp> getInApp() {
        return inApp;
    }

    public void setInApp(final List<InApp> inApp) {
        this.inApp = inApp;
    }

    public String getOriginalApplicationVersion() {
        return originalApplicationVersion;
    }

    public void setOriginalApplicationVersion(final String originalApplicationVersion) {
        this.originalApplicationVersion = originalApplicationVersion;
    }

    public ZonedDateTime getReceiptCreationDate() {
        return receiptCreationDate;
    }

    public void setReceiptCreationDate(final ZonedDateTime receiptCreationDate) {
        this.receiptCreationDate = receiptCreationDate;
    }

    public ZonedDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(final ZonedDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Receipt receipt = (Receipt) o;

        return Objects.equals(bundleId, receipt.bundleId) &&
               Objects.equals(applicationVersion, receipt.applicationVersion) &&
               Objects.equals(inApp, receipt.inApp) &&
               Objects.equals(originalApplicationVersion, receipt.originalApplicationVersion) &&
               Objects.equals(receiptCreationDate, receipt.receiptCreationDate) &&
               Objects.equals(expirationDate, receipt.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bundleId, applicationVersion, inApp, originalApplicationVersion, receiptCreationDate, expirationDate);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Receipt.class.getSimpleName() + "[", "]")
            .add("bundleId='" + bundleId + "'")
            .add("applicationVersion='" + applicationVersion + "'")
            .add("inApp=" + inApp)
            .add("originalApplicationVersion='" + originalApplicationVersion + "'")
            .add("receiptCreationDate=" + receiptCreationDate)
            .add("expirationDate=" + expirationDate)
            .toString();
    }
}
