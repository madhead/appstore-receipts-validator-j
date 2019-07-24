package by.dev.madhead.utils.appstore_receipts_validator.mapper;

import by.dev.madhead.utils.appstore_receipts_validator.model.VerifyReceiptResponse;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class VerifyReceiptResponseStatusDeserializer extends StdScalarDeserializer<VerifyReceiptResponse.Status> {
    public VerifyReceiptResponseStatusDeserializer() {
        super(VerifyReceiptResponse.Status.class);
    }

    @Override
    public VerifyReceiptResponse.Status deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {
        if (p.currentToken() != JsonToken.VALUE_NUMBER_INT) {
            throw new InvalidFormatException(p, "Invalid Verify Receipt Response Status", null, VerifyReceiptResponse.Status.class);
        } else {
            final int value = p.getValueAsInt();

            switch (value) {
                case 0:
                    return VerifyReceiptResponse.Status.VALID;
                case 21000:
                    return VerifyReceiptResponse.Status.INVALID_JSON;
                case 21002:
                    return VerifyReceiptResponse.Status.INVALID_RECEIPT_DATA;
                case 21003:
                    return VerifyReceiptResponse.Status.AUTHENTICATION_ERROR;
                case 21004:
                    return VerifyReceiptResponse.Status.INVALID_SHARED_SECRET;
                case 21005:
                    return VerifyReceiptResponse.Status.RECEIPT_SERVER_UNAVAILABLE;
                case 21006:
                    return VerifyReceiptResponse.Status.SUBSCRIPTION_EXPIRED;
                case 21007:
                case 21008:
                    return VerifyReceiptResponse.Status.WRONG_ENVIRONMENT;
                case 21010:
                    return VerifyReceiptResponse.Status.AUTHORIZATION_ERROR;
                default:
                    if ((21100 <= value) && (value <= 21199)) {
                        return VerifyReceiptResponse.Status.INTERNAL_ERROR;
                    } else {
                        throw new InvalidFormatException(p, "Unknown Verify Receipt Response Status", null, VerifyReceiptResponse.Status.class);
                    }
            }
        }
    }
}
