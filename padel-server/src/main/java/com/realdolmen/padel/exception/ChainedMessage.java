package com.realdolmen.padel.exception;

import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChainedMessage extends Message implements IChainedMessage {
    private static final long serialVersionUID = -4507945788608278505L;
    private transient Throwable m_wrappedException;
    private List<IMessage> m_causeMsg;
    private String m_causeMessage;
    private String m_causeClass;
    private Severity m_severity;

    public ChainedMessage(MessageCode p_code, Map<String, String> p_infoParam, Throwable p_cause) {
        this(p_code, p_infoParam, p_cause, p_cause == null ? Severity.info : Severity.error);
    }

    public ChainedMessage(MessageCode p_code, Map<String, String> p_infoParam, Throwable p_cause, Severity p_severity) {
        super(p_code, p_infoParam);
        this.m_wrappedException = null;
        this.m_causeMsg = new ArrayList();
        this.m_severity = Severity.info;
        this.m_wrappedException = p_cause;
        this.m_severity = p_severity;
    }

    public ChainedMessage(IChainedMessage p_msg) {
        super(p_msg);
        this.m_wrappedException = null;
        this.m_causeMsg = new ArrayList();
        this.m_severity = Severity.info;
        this.m_severity = p_msg.getSeverity();
        this.m_wrappedException = p_msg.getWrappedException();
    }

    public ChainedMessage(MessageCode p_code, Map<String, String> p_info, String p_causeClass, String p_causeMessage, Severity p_severity) {
        super(p_code, p_info);
        this.m_wrappedException = null;
        this.m_causeMsg = new ArrayList();
        this.m_severity = Severity.info;
        this.m_causeMessage = p_causeMessage;
        this.m_causeClass = p_causeClass;
        this.m_severity = p_severity;
    }

    public ChainedMessage(MessageCode p_code, Map<String, String> p_info, String p_causeClass, String p_causeMessage) {
        this(p_code, p_info, p_causeClass, p_causeMessage, p_causeClass == null ? Severity.info : Severity.error);
    }

    public void addCauseMessage(IMessage p_msg) {
        this.m_causeMsg.add(p_msg);
    }

    public void addCauseMessages(List<IMessage> p_causeMsgs) {
        this.m_causeMsg.addAll(p_causeMsgs);
    }

    public List<IMessage> getCauseMessages() {
        return this.m_causeMsg;
    }

    public Throwable getWrappedException() {
        return this.m_wrappedException;
    }

    public void setWrappedException(Throwable p_throwable) {
        this.m_wrappedException = p_throwable;
    }

    public String getCauseClassFQN() {
        return this.getWrappedException() == null ? this.m_causeClass : this.getWrappedException().getClass().getName();
    }

    public String getCauseMessage() {
        return this.getWrappedException() == null ? this.m_causeMessage : this.getWrappedException().getMessage();
    }

    public void setCauseClassFQN(String p_causeClass) {
        this.m_causeClass = p_causeClass;
    }

    public void setCauseMessage(String p_causeMsg) {
        this.m_causeMessage = p_causeMsg;
    }

    private Object writeReplace() throws ObjectStreamException {
        this.m_causeMessage = this.getCauseMessage();
        this.m_causeClass = this.getCauseClassFQN();
        return this;
    }

    public Throwable getCause() {
        return this.getWrappedException();
    }

    public Severity getSeverity() {
        return this.m_severity;
    }

    public void setSeverity(Severity severity) {
        this.m_severity = severity;
    }

    public String toString() {
        return super.toString() + ":" + this.m_severity + ":" + this.m_causeMsg.size() + " detail(s)";
    }
}