package by.dev.madhead.utils.appstore_receipts_validator.mapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class InAppUpgradedDeserializerTest {

    private ObjectMapper objectMapper;

    @BeforeEach
    private void beforeEach() {
        this.objectMapper = ObjectMapperFactory.defaultObjectMapper();
    }

    @Test
    public void testDeserializationTrue() throws Exception {
        Assertions.assertTrue(
            objectMapper.readValue(
                getClass().getResource("InAppUpgradedDeserializerTest/testDeserializationTrue.json"),
                UpgradedHolder.class
            ).upgraded
        );
    }

    @Test
    public void testDeserializationFalse() throws Exception {
        Assertions.assertFalse(
            objectMapper.readValue(
                getClass().getResource("InAppUpgradedDeserializerTest/testDeserializationFalse.json"),
                UpgradedHolder.class
            ).upgraded
        );
    }

    @Test
    public void testDeserializationUnknownValue() throws Exception {
        Assertions.assertFalse(
            objectMapper.readValue(
                getClass().getResource("InAppUpgradedDeserializerTest/testDeserializationUnknownValue.json"),
                UpgradedHolder.class
            ).upgraded
        );
    }

    @Test
    public void testDeserializationInvalidValue() {
        Assertions.assertThrows(
            JsonMappingException.class,
            () -> objectMapper.readValue(
                getClass().getResource("InAppUpgradedDeserializerTest/testDeserializationInvalidValue.json"),
                UpgradedHolder.class
            )
        );
    }

    private static class UpgradedHolder {

        @JsonProperty("is_upgraded")
        @JsonDeserialize(using = InAppUpgradedDeserializer.class)
        private Boolean upgraded;

        public UpgradedHolder() {
        }

        public UpgradedHolder(Boolean upgraded) {
            this.upgraded = upgraded;
        }

        public Boolean getUpgraded() {
            return upgraded;
        }

        public void setUpgraded(Boolean upgraded) {
            this.upgraded = upgraded;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UpgradedHolder that = (UpgradedHolder) o;
            return Objects.equals(upgraded, that.upgraded);
        }

        @Override
        public int hashCode() {
            return Objects.hash(upgraded);
        }
    }
}
