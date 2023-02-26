package com.recipe.app.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BasicMessage {

    @JsonProperty("messaging_product")
    private String messagingProduct;
    private String to;
    private Text text;

    @Data
    @ToString
    static class Text {
        private String body;
    }
}
