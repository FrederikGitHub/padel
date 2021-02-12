package com.realdolmen.padel.exception;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class PadelRuntimeException extends RuntimeException implements IPadelException, Serializable {
    private static final long serialVersionUID = 1L;
    private IChainedMessage m_delegate;

    public PadelRuntimeException(MessageCode p_code) {
        this(p_code, Collections.EMPTY_MAP, (Throwable)null);
    }

    public PadelRuntimeException(MessageCode p_code, Map<String, String> p_info) {
        this(p_code, p_info, (Throwable)null);
    }

    public PadelRuntimeException(MessageCode p_code, Throwable p_cause) {
        this(p_code, Collections.EMPTY_MAP, p_cause);
    }

    public PadelRuntimeException(MessageCode p_code, Map<String, String> p_info, Throwable p_cause) {
        this((IChainedMessage)(new ChainedMessage(p_code, p_info, p_cause, Severity.error)));
    }

    public PadelRuntimeException(MessageCode p_code, Map<String, String> p_info, String p_causeClass, String p_causeMessage) {
        this((IChainedMessage)(new ChainedMessage(p_code, p_info, p_causeClass, p_causeMessage, Severity.error)));
    }

    public PadelRuntimeException(IPadelException e) {
        this(e.getMessageCode(), e.getInfo(), (Throwable)e);
    }

    public PadelRuntimeException(IChainedMessage msg) {
        super(msg.getMessage());
        if (msg.getWrappedException() != null) {
            this.initCause(msg.getWrappedException());
        }

        this.m_delegate = msg;
    }

    public String getCode() {
        return this.m_delegate.getCode();
    }

    public Map<String, String> getInfo() {
        return this.m_delegate.getInfo();
    }

    public String getInfoString() {
        return this.m_delegate.getInfoString();
    }

    public String getMessage() {
        return this.m_delegate.getMessage();
    }

    public String getMessage(Locale p_locale) {
        return this.m_delegate.getMessage(p_locale);
    }

    public MessageCode getMessageCode() {
        return this.m_delegate.getMessageCode();
    }

    public String getName() {
        return this.getName(Locale.getDefault());
    }

    public String getName(Locale p_locale) {
        return this.m_delegate.getName(p_locale);
    }

    public String getSubSystem() {
        return this.m_delegate.getSubSystem();
    }

    public String getSystem() {
        return this.m_delegate.getSystem();
    }

    public void setInfo(Map<String, String> p_info) {
        this.m_delegate.setInfo(p_info);
    }

    public String getCauseClassFQN() {
        return this.m_delegate.getCauseClassFQN();
    }

    public String getCauseMessage() {
        return this.m_delegate.getCauseMessage();
    }

    public void setInfo(String p_key, String p_info) {
        this.m_delegate.setInfo(p_key, p_info);
    }

    public void addCauseMessage(IMessage p_msg) {
        this.m_delegate.addCauseMessage(p_msg);
    }

    public void addCauseMessages(List<IMessage> p_causeMsgs) {
        this.m_delegate.addCauseMessages(p_causeMsgs);
    }

    public List<IMessage> getCauseMessages() {
        return this.m_delegate.getCauseMessages();
    }

    public Throwable getWrappedException() {
        return this.m_delegate.getWrappedException();
    }

    public void setWrappedException(Throwable p_throwable) {
        this.initCause(p_throwable);
        this.m_delegate.setWrappedException(p_throwable);
    }

    public String toString() {
        return this.getClass().getName() + ":" + this.m_delegate.toString();
    }

    public Severity getSeverity() {
        return this.m_delegate.getSeverity();
    }

    public void setSeverity(Severity severity) {
        this.m_delegate.setSeverity(severity);
    }
}
