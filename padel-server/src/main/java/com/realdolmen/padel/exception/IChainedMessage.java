package com.realdolmen.padel.exception;

import java.util.List;

public interface IChainedMessage extends IMessage{
    List<IMessage> getCauseMessages();

    void addCauseMessages(List<IMessage> var1);

    void addCauseMessage(IMessage var1);

    Throwable getWrappedException();

    void setWrappedException(Throwable var1);

    String getCauseMessage();

    String getCauseClassFQN();

    void setSeverity(Severity var1);

    Severity getSeverity();
}
