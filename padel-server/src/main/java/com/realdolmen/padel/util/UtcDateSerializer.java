package com.realdolmen.padel.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class UtcDateSerializer extends JsonSerializer<LocalDate> {

    @Override
    public void serialize(LocalDate date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        jsonGenerator.writeString(dateFormatter.format(date));
    }
}
