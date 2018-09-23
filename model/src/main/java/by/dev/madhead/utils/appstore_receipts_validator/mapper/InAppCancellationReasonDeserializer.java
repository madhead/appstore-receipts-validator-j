package by.dev.madhead.utils.appstore_receipts_validator.mapper;

import by.dev.madhead.utils.appstore_receipts_validator.model.InApp;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class InAppCancellationReasonDeserializer extends StdScalarDeserializer<InApp.CancellationReason> {
    public InAppCancellationReasonDeserializer() {
        super(InApp.CancellationReason.class);
    }

    @Override
    public InApp.CancellationReason deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {
        if (p.currentToken() != JsonToken.VALUE_STRING) {
            throw new InvalidFormatException(p, "Invalid Cancellation Reason", null, InApp.CancellationReason.class);
        } else {
            switch (p.getValueAsString()) {
                case "0":
                    return InApp.CancellationReason.ANOTHER_REASON;
                case "1":
                    return InApp.CancellationReason.ISSUE;
                default:
                    throw new InvalidFormatException(p, "Unknown Cancellation Reason", null, InApp.CancellationReason.class);
            }
        }
    }
}
