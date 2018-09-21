package by.dev.madhead.utils.appstore_receipts_validator.model;

import by.dev.madhead.utils.appstore_receipts_validator.mapper.ObjectMapperFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ReceiptTest {
    private ObjectMapper objectMapper;

    @BeforeEach
    private void bedoreEach() {
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
        Assertions.assertEquals(
            ZonedDateTime.of(LocalDateTime.of(2019, 9, 23, 3, 42, 42), ZoneId.of("Etc/GMT")).toInstant(),
            value.getExpirationDate().toInstant()
        );
    }

    @Test
    public void testDeserializationEmptyInApp() throws Exception {
        final Receipt value = objectMapper.readValue(
            getClass().getResource("ReceiptTest/testDeserializationEmptyInApp.json"),
            Receipt.class
        );

        Assertions.assertEquals(0, value.getInApp().size());
    }
}
