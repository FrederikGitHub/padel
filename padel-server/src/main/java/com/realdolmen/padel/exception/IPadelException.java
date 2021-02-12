package com.realdolmen.padel.exception;

public interface IPadelException extends IChainedMessage {
    Throwable getCause();

    String getCauseMessage();

    String getCauseClassFQN();
}
