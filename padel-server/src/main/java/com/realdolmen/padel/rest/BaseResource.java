package com.realdolmen.padel.rest;

import com.realdolmen.padel.exception.IMessage;
import com.realdolmen.padel.exception.PadelRuntimeException;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;

import java.util.function.Function;
import java.util.stream.Collectors;

public class BaseResource {
    protected ResponseEntity handleException(String defaultError, Exception e) {
        StringBuffer errorMessages = new StringBuffer(defaultError);
        if (e instanceof PadelRuntimeException) {
            PadelRuntimeException padelRuntimeException = (PadelRuntimeException)e;
            errorMessages = new StringBuffer("");
            if (StringUtils.isNotEmpty(e.getLocalizedMessage())){
                errorMessages.append(e.getLocalizedMessage());
            }
            if (!CollectionUtils.isEmpty(padelRuntimeException.getCauseMessages())){
                String causeMessages = padelRuntimeException.getCauseMessages().stream().map(new Function<IMessage, String>() {
                    @Override
                    public String apply(IMessage iMessage) {
                        return iMessage.getMessage();
                    }
                }).collect(Collectors.joining());
                errorMessages.append(causeMessages);
            }
        }

        ResponseEntity responseEntity = new ResponseEntity(errorMessages.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }
}
