package com.recipe.app.models.data;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Message {
    private String from;
    private String id;
    private String timestamp;
    private String type;
    private Text text;
}
