package com.realdolmen.padel.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.realdolmen.padel.model.Week;

import java.io.IOException;

public class MyPairDeserializer extends KeyDeserializer {

    @Override
    public Week deserializeKey(
            String key,
            DeserializationContext ctxt) throws IOException,
            JsonProcessingException {

        return new Week(new Integer(key));
    }
}
