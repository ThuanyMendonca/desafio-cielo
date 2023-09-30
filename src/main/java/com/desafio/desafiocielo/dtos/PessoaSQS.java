package com.desafio.desafiocielo.dtos;

import java.util.UUID;

public class PessoaSQS {
    private String type;
    private UUID messageId;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UUID getMessageId() {
        return messageId;
    }

    public void setMessageId(UUID messageId) {
        this.messageId = messageId;
    }
}
