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

public class ReceiptTest {
    private ObjectMapper objectMapper;

    @BeforeEach
    private void beforeEach() {
        this.objectMapper = ObjectMapperFactory.defaultObjectMapper();
    }

    @Test
    public void testDeserialization() throws Exception {
        final Receipt value = objectMapper.readValue(getClass().getResource("ReceiptTest/testDeserialization.json"), Receipt.class);

        Assertions.assertEquals("bundle_id", value.getBundleId());
        Assertions.assertEquals("42.42", value.getApplicationVersion());
        Assertions.assertEquals(2, value.getInApp().size());
        Assertions.assertEquals("41.41", value.getOriginalApplicationVersion());
        Assertions.assertEquals(
            ZonedDateTime.of(LocalDateTime.of(2018, 9, 23, 3, 42, 42), ZoneId.of("Etc/GMT")).toInstant(),
            value.getReceiptCreationDate().toInstant()
        );
        Assertions.assertEquals(Long.valueOf(1563494400000L), value.getReceiptCreationDateMs());
        Assertions.assertEquals(
            ZonedDateTime.of(LocalDateTime.of(2019, 7, 18, 17, 00, 00), ZoneId.of("America/Los_Angeles")).toInstant(),
            value.getReceiptCreationDatePst().toInstant()
        );
        Assertions.assertEquals(
            ZonedDateTime.of(LocalDateTime.of(2019, 7, 23, 9, 00, 00), ZoneId.of("Etc/GMT")).toInstant(),
            value.getRequestDate().toInstant()
        );
        Assertions.assertEquals(Long.valueOf(1563875196800L), value.getRequestDateMs());
        Assertions.assertEquals(
            ZonedDateTime.of(LocalDateTime.of(2019, 7, 23, 2, 00, 00), ZoneId.of("America/Los_Angeles")).toInstant(),
            value.getRequestDatePst().toInstant()
        );
        Assertions.assertEquals(
            ZonedDateTime.of(LocalDateTime.of(2019, 9, 23, 3, 42, 42), ZoneId.of("Etc/GMT")).toInstant(),
            value.getExpirationDate().toInstant()
        );
        Assertions.assertEquals(Long.valueOf(1563875196800L), value.getExpirationDateMs());
        Assertions.assertEquals(
            ZonedDateTime.of(LocalDateTime.of(2019, 7, 23, 2, 00, 00), ZoneId.of("America/Los_Angeles")).toInstant(),
            value.getExpirationDatePst().toInstant()
        );
        Assertions.assertEquals(
            ZonedDateTime.of(LocalDateTime.of(2019, 9, 23, 3, 42, 42), ZoneId.of("Etc/GMT")).toInstant(),
            value.getOriginalPurchaseDate().toInstant()
        );
        Assertions.assertEquals(Long.valueOf(1563875196800L), value.getOriginalPurchaseDateMs());
        Assertions.assertEquals(
            ZonedDateTime.of(LocalDateTime.of(2019, 7, 23, 2, 00, 00), ZoneId.of("America/Los_Angeles")).toInstant(),
            value.getOriginalPurchaseDatePst().toInstant()
        );
        Assertions.assertEquals(Long.valueOf(32051403290714L), value.getDownloadId());
        Assertions.assertEquals(Long.valueOf(141916214L), value.getVersionExternalIdentifier());
        Assertions.assertEquals(Long.valueOf(141916214L), value.getAdamId());
        Assertions.assertEquals(Long.valueOf(141916214L), value.getAppItemId());
        Assertions.assertEquals(Receipt.ReceiptType.PRODUCTION, value.getReceiptType());
    }

    @Test
    public void testDeserializationEmptyInApp() throws Exception {
        final Receipt value = objectMapper.readValue(
            getClass().getResource("ReceiptTest/testDeserializationEmptyInApp.json"),
            Receipt.class
        );

        Assertions.assertEquals(0, value.getInApp().size());
    }

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(Receipt.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @Test
    public void testToString() throws Exception {
        Assertions.assertNotNull(objectMapper.readValue(getClass().getResource("ReceiptTest/testToString.json"), Receipt.class).toString());
    }
}
