package com.recipe.app.models.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ValueMessage {

    @JsonProperty("messaging_product")
    private String messagingProduct;
    private Metadata metadata;
    private Contact[] contacts;
    private Message[] messages;
}
