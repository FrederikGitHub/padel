package com.realdolmen.padel.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import io.micrometer.core.instrument.util.StringUtils;

import java.io.IOException;
import java.time.LocalDate;

public class UtcDateDeserializer extends JsonDeserializer<LocalDate> {

    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        LocalDate resolvedDate  = null;
        if (StringUtils.isNotEmpty(jsonParser.getValueAsString())){
            String dateAsString = jsonParser.getValueAsString();
            resolvedDate = LocalDate.parse(dateAsString);
        }

        return resolvedDate;
    }
}
