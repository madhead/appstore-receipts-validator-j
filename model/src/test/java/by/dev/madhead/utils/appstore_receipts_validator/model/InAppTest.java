package by.dev.madhead.utils.appstore_receipts_validator.model;

import by.dev.madhead.utils.appstore_receipts_validator.mapper.ObjectMapperFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class InAppTest {
    private ObjectMapper objectMapper;

    @BeforeEach
    private void beforeEach() {
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
        Assertions.assertEquals(Long.valueOf(1563269415000L), value.getPurchaseDateMs());
        Assertions.assertEquals(
            ZonedDateTime.of(LocalDateTime.of(2019, 7, 16, 2, 30, 15), ZoneId.of("America/Los_Angeles")).toInstant(),
            value.getPurchaseDatePst().toInstant()
        );
        Assertions.assertEquals(
            ZonedDateTime.of(LocalDateTime.of(2017, 9, 23, 3, 42, 42), ZoneId.of("Etc/GMT")).toInstant(),
            value.getOriginalPurchaseDate().toInstant()
        );
        Assertions.assertEquals(Long.valueOf(1563269416000L), value.getOriginalPurchaseDateMs());
        Assertions.assertEquals(
            ZonedDateTime.of(LocalDateTime.of(2019, 7, 16, 2, 30, 16), ZoneId.of("America/Los_Angeles")).toInstant(),
            value.getOriginalPurchaseDatePst().toInstant()
        );
        Assertions.assertEquals(
            ZonedDateTime.of(LocalDateTime.of(2019, 9, 23, 3, 42, 42), ZoneId.of("Etc/GMT")).toInstant(),
            value.getExpiresDate().toInstant()
        );
        Assertions.assertEquals(Long.valueOf(1563528615000L), value.getExpiresDateMs());
        Assertions.assertEquals(
            ZonedDateTime.of(LocalDateTime.of(2019, 7, 19, 2, 30, 15), ZoneId.of("America/Los_Angeles")).toInstant(),
            value.getExpiresDatePst().toInstant()
        );
        Assertions.assertEquals(true, value.getTrialPeriod());
        Assertions.assertEquals(false, value.getInIntroOfferPeriod());
        Assertions.assertEquals(
            ZonedDateTime.of(LocalDateTime.of(2018, 9, 22, 3, 42, 42), ZoneId.of("Etc/GMT")).toInstant(),
            value.getCancellationDate().toInstant()
        );
        Assertions.assertEquals(Long.valueOf(1563528615000L), value.getCancellationDateMs());
        Assertions.assertEquals(
            ZonedDateTime.of(LocalDateTime.of(2019, 7, 19, 2, 30, 15), ZoneId.of("America/Los_Angeles")).toInstant(),
            value.getCancellationDatePst().toInstant()
        );
        Assertions.assertEquals(InApp.CancellationReason.ANOTHER_REASON, value.getCancellationReason());
        Assertions.assertEquals("web_order_line_item_id", value.getWebOrderLineItemId());
        Assertions.assertEquals("promotional_offer_id", value.getPromotionalOfferId());
        Assertions.assertTrue(value.getUpgraded());
    }

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(InApp.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @Test
    public void testToString() throws Exception {
        Assertions.assertNotNull(objectMapper.readValue(getClass().getResource("InAppTest/testToString.json"), InApp.class).toString());
    }
}
