package com.recipe.app.utils;

import com.recipe.app.models.Payload;
import com.recipe.app.models.data.ValueMessage;

import java.util.Arrays;

public class PayloadUtils {

    public static String getTextMessage(final Payload<ValueMessage> payload){
        return Arrays.stream(payload.getValue().getMessages()).findFirst().get().getText().getBody();
    }

}
