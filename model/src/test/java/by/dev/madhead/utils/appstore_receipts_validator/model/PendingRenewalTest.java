package by.dev.madhead.utils.appstore_receipts_validator.model;

import by.dev.madhead.utils.appstore_receipts_validator.mapper.ObjectMapperFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PendingRenewalTest {

    private ObjectMapper objectMapper;

    @BeforeEach
    private void beforeEach() {
        this.objectMapper = ObjectMapperFactory.defaultObjectMapper();
    }

    @Test
    public void testDeserialization() throws Exception {
        final PendingRenewal value = objectMapper.readValue(getClass().getResource("PendingRenewalTest/testDeserialization.json"), PendingRenewal.class);

        Assertions.assertEquals(PendingRenewal.ExpirationIntent.CUSTOMER_CANCELED, value.getExpirationIntent());
        Assertions.assertEquals("auto_renew_product_id", value.getAutoRenewProductId());
        Assertions.assertEquals("42", value.getOriginalTransactionId());
        Assertions.assertFalse(value.getInBillingRetryPeriod());
        Assertions.assertEquals("product_id", value.getProductId());
        Assertions.assertEquals(PendingRenewal.AutoRenewStatus.OFF, value.getAutoRenewStatus());
        Assertions.assertEquals(PendingRenewal.PriceConsentStatus.AGREED, value.getPriceConsentStatus());

    }

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(PendingRenewal.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @Test
    public void testToString() throws Exception {
        Assertions.assertNotNull(objectMapper.readValue(getClass().getResource("PendingRenewalTest/testToString.json"), PendingRenewal.class).toString());
    }


}
