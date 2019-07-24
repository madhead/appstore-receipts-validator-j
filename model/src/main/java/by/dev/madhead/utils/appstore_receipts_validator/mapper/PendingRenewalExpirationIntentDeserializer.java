package by.dev.madhead.utils.appstore_receipts_validator.mapper;

import by.dev.madhead.utils.appstore_receipts_validator.model.PendingRenewal;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class PendingRenewalExpirationIntentDeserializer extends StdScalarDeserializer<PendingRenewal.ExpirationIntent> {
    public PendingRenewalExpirationIntentDeserializer() {
        super(PendingRenewal.ExpirationIntent.class);
    }

    @Override
    public PendingRenewal.ExpirationIntent deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {
        if (p.currentToken() != JsonToken.VALUE_STRING) {
            throw new InvalidFormatException(p, "Invalid Expiration Intent", null, PendingRenewal.ExpirationIntent.class);
        } else {
            switch (p.getValueAsString()) {
                case "1":
                    return PendingRenewal.ExpirationIntent.CUSTOMER_CANCELED;
                case "2":
                    return PendingRenewal.ExpirationIntent.BILLING_ERROR;
                case "3":
                    return PendingRenewal.ExpirationIntent.CUSTOMER_DECLINED_PRICE;
                case "4":
                    return PendingRenewal.ExpirationIntent.PRODUCT_NOT_AVAILABLE;
                case "5":
                    return PendingRenewal.ExpirationIntent.UNKNOWN_ERROR;
                default:
                    throw new InvalidFormatException(p, "Unknown Expiration Intent", null, PendingRenewal.ExpirationIntent.class);
            }
        }
    }
}
