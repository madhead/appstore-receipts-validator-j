package by.dev.madhead.utils.appstore_receipts_validator.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VerifyReceiptRequest {
    @JsonProperty("receipt-data")
    private String receiptData;

    @JsonProperty("password")
    private String password;

    @JsonProperty("exclude-old-transactions")
    private Boolean excludeOldTransactions;

    public VerifyReceiptRequest() {
        this(null, null, null);
    }

    public VerifyReceiptRequest(final String receiptData) {
        this(receiptData, null, null);
    }

    public VerifyReceiptRequest(final String receiptData, final String password, final Boolean excludeOldTransactions) {
        this.receiptData = receiptData;
        this.password = password;
        this.excludeOldTransactions = excludeOldTransactions;
    }

    public String getReceiptData() {
        return receiptData;
    }

    public void setReceiptData(final String receiptData) {
        this.receiptData = receiptData;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public Boolean getExcludeOldTransactions() {
        return excludeOldTransactions;
    }

    public void setExcludeOldTransactions(final Boolean excludeOldTransactions) {
        this.excludeOldTransactions = excludeOldTransactions;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final VerifyReceiptRequest that = (VerifyReceiptRequest) o;

        return Objects.equals(receiptData, that.receiptData) &&
               Objects.equals(password, that.password) &&
               Objects.equals(excludeOldTransactions, that.excludeOldTransactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiptData, password, excludeOldTransactions);
    }

    @Override
    public String toString() {
        return MoreObjects
            .toStringHelper(this)
            .add("receipt-data", receiptData)
            .add("password", password)
            .add("exclude-old-transactions", excludeOldTransactions)
            .toString();
    }
}
