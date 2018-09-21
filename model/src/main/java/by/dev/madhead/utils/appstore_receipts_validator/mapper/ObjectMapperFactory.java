package by.dev.madhead.utils.appstore_receipts_validator.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperFactory {
    public static ObjectMapper defaultObjectMapper() {
        final ObjectMapper result = new ObjectMapper();

        return result;
    }
}
