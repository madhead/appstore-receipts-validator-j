package by.dev.madhead.utils.appstore_receipts_validator.model;

import by.dev.madhead.utils.appstore_receipts_validator.mapper.ObjectMapperFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class InAppTest {
    private ObjectMapper objectMapper;

    @BeforeEach
    private void bedoreEach() {
        this.objectMapper = ObjectMapperFactory.defaultObjectMapper();
    }


    @Test
    public void testDeserialization() throws Exception {
        final InApp value = objectMapper.readValue(getClass().getResource("InAppTest/testDeserialization.json"), InApp.class);

        Assertions.assertEquals(42, (int) value.getQuantity());
        Assertions.assertEquals("product_id", value.getProductId());
        Assertions.assertEquals("transaction_id", value.getTransactionId());
        Assertions.assertEquals("original_transaction_id", value.getOriginalTransactionId());
        Assertions.assertEquals(
            ZonedDateTime.of(LocalDateTime.of(2018, 9, 23, 3, 42, 42), ZoneId.of("Etc/GMT")).toInstant(),
            value.getPurchaseDate().toInstant()
        );
        Assertions.assertEquals(
            ZonedDateTime.of(LocalDateTime.of(2017, 9, 23, 3, 42, 42), ZoneId.of("Etc/GMT")).toInstant(),
            value.getOriginalPurchaseDate().toInstant()
        );
        Assertions.assertEquals(
            ZonedDateTime.of(LocalDateTime.of(2019, 9, 23, 3, 42, 42), ZoneId.of("Etc/GMT")).toInstant(),
            value.getExpiresDate().toInstant()
        );
        Assertions.assertEquals(InApp.ExpirationIntent.CUSTOMER_CANCELED, value.getExpirationIntent());
        Assertions.assertEquals(Boolean.TRUE, value.getInBillingRetryPeriod());
        Assertions.assertEquals(true, value.getTrialPeriod());
        Assertions.assertEquals(false, value.getInIntroOfferPeriod());
        Assertions.assertEquals(
            ZonedDateTime.of(LocalDateTime.of(2018, 9, 22, 3, 42, 42), ZoneId.of("Etc/GMT")).toInstant(),
            value.getCancellationDate().toInstant()
        );
        Assertions.assertEquals(InApp.CancellationReason.ANOTHER_REASON, value.getCancellationReason());
        Assertions.assertEquals("app_item_id", value.getAppItemId());
        Assertions.assertEquals("42.42", value.getVersionExternalIdentifier());
        Assertions.assertEquals("web_order_line_item_id", value.getWebOrderLineItemId());
        Assertions.assertEquals(InApp.AutoRenewStatus.ON, value.getAutoRenewStatus());
        Assertions.assertEquals("auto_renew_product_id", value.getAutoRenewProductId());
        Assertions.assertEquals(InApp.PriceConsentStatus.AGREED, value.getPriceConsentStatus());
    }
}
