package com.realdolmen.padel.exception;

import java.io.Serializable;
import java.util.*;

public class Message implements IMessage, Serializable {
    private static final long serialVersionUID = 2387194968441597938L;
    public static final Map<String, String> EMPTY_PARAMS;
    private final MessageCode m_code;
    private Map<String, String> m_infoParam;

    public Message(MessageCode p_code, Map<String, String> p_infoParam) {
        this.m_infoParam = EMPTY_PARAMS;
        this.m_code = p_code;
        if (p_infoParam != null && !p_infoParam.isEmpty()) {
            this.m_infoParam = p_infoParam;
        }

    }

    public Message(IMessage p_msg) {
        this(p_msg.getMessageCode(), p_msg.getInfo());
    }

    public String getCode() {
        return this.m_code == null ? null : this.m_code.getCode();
    }

    public String getMessage() {
        return this.getMessage(Locale.getDefault());
    }

    public String getMessage(Locale p_locale) {
        return this.m_code == null ? null : this.m_code.getMessage(p_locale, this.getInfo());
    }

    public String getInfoString() {
        if (this.m_infoParam == null) {
            return null;
        } else {
            StringBuffer l_infoString = new StringBuffer();
            Iterator l_it = this.m_infoParam.entrySet().iterator();

            while(l_it.hasNext()) {
                Map.Entry l_entry = (Map.Entry)l_it.next();
                l_infoString.append(l_entry.getKey());
                l_infoString.append('=');
                l_infoString.append(l_entry.getValue());
                l_infoString.append(',');
            }

            return l_infoString.toString();
        }
    }

    public String getName() {
        return this.m_code == null ? null : this.m_code.getName();
    }

    public String getName(Locale p_locale) {
        return this.m_code == null ? null : this.m_code.getName(p_locale);
    }

    public String getSubSystem() {
        return this.m_code == null ? null : this.m_code.getSubSystem();
    }

    public String getSystem() {
        return this.m_code == null ? null : this.m_code.getSystem();
    }

    public MessageCode getMessageCode() {
        return this.m_code == null ? null : this.m_code;
    }

    public void setInfo(String p_key, String p_info) {
        if (this.m_infoParam == EMPTY_PARAMS) {
            this.m_infoParam = new HashMap();
        }

        this.m_infoParam.put(p_key, p_info);
    }

    public Severity getSeverity() {
        return null;
    }

    public Map<String, String> getInfo() {
        return this.m_infoParam;
    }

    public String toString() {
        return this.m_code + ":" + this.getMessage();
    }

    public void setInfo(Map<String, String> p_info) {
        this.m_infoParam = p_info;
    }

    static {
        EMPTY_PARAMS = Collections.EMPTY_MAP;
    }
}
