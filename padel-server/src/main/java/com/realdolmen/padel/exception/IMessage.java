package com.realdolmen.padel.exception;

import java.util.Locale;
import java.util.Map;

public interface IMessage {
    String getSystem();

    String getSubSystem();

    String getCode();

    String getName();

    String getName(Locale var1);

    String getMessage();

    String getMessage(Locale var1);

    MessageCode getMessageCode();

    Map<String, String> getInfo();

    String getInfoString();

    void setInfo(Map<String, String> var1);

    void setInfo(String var1, String var2);

    Severity getSeverity();
}
