package com.recipe.app.models.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Contact {
    private Profile profile;

    @JsonProperty("wa_id")
    private String waID;
}
