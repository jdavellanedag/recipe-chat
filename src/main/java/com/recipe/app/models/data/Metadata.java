package com.recipe.app.models.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Metadata {

    @JsonProperty("display_phone_number")
    private String displayPhoneNumber;

    @JsonProperty("phone_number_id")
    private String phoneNumberID;

}
