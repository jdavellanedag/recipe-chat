package com.recipe.app.models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Payload<T> {

    String field;
    T value;



}
