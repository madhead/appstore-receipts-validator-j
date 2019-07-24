package by.dev.madhead.utils.appstore_receipts_validator.mapper;

import by.dev.madhead.utils.appstore_receipts_validator.model.VerifyReceiptResponse;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class VerifyReceiptResponseEnvironmentDeserializer extends StdScalarDeserializer<VerifyReceiptResponse.Environment> {
    public VerifyReceiptResponseEnvironmentDeserializer() {
        super(VerifyReceiptResponse.Environment.class);
    }

    @Override
    public VerifyReceiptResponse.Environment deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.currentToken() != JsonToken.VALUE_STRING) {
            throw new InvalidFormatException(p, "Invalid Verify Receipt Response Environment", null, VerifyReceiptResponse.Environment.class);
        } else {
            final String value = p.getValueAsString();

            switch (value) {
                case "Sandbox":
                    return VerifyReceiptResponse.Environment.SANDBOX;
                case "Production":
                    return VerifyReceiptResponse.Environment.PRODUCTION;
                default:
                    throw new InvalidFormatException(p, "Unknown Verify Receipt Response Environment", null, VerifyReceiptResponse.Environment.class);
            }
        }
    }
}
