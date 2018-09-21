package by.dev.madhead.utils.appstore_receipts_validator.mapper;

import by.dev.madhead.utils.appstore_receipts_validator.model.InApp;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class InAppExpirationIntentDeserializer extends StdScalarDeserializer<InApp.ExpirationIntent> {
    public InAppExpirationIntentDeserializer() {
        super(InApp.ExpirationIntent.class);
    }

    @Override
    public InApp.ExpirationIntent deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {
        if (p.currentToken() != JsonToken.VALUE_STRING) {
            throw new InvalidFormatException(p, "Invalid Expiration Intent", null, InApp.ExpirationIntent.class);
        } else {
            switch (p.getValueAsString()) {
                case "1":
                    return InApp.ExpirationIntent.CUSTOMER_CANCELED;
                case "2":
                    return InApp.ExpirationIntent.BILLING_ERROR;
                case "3":
                    return InApp.ExpirationIntent.CUSTOMER_DECLINED_PRICE;
                case "4":
                    return InApp.ExpirationIntent.PRODUCT_NOT_AVAILABLE;
                case "5":
                    return InApp.ExpirationIntent.UNKNOWN_ERROR;
                default:
                    throw new InvalidFormatException(p, "Unknown Expiration Intent", null, InApp.ExpirationIntent.class);
            }
        }
    }
}
