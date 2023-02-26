package com.recipe.app.services;

import com.recipe.app.enums.IntentionEnum;

import java.util.Set;

public class MessageService {

    private final Set<String> QUERY_WORDS = Set.of("");
    private final Set<String> ADD_WORDS = Set.of("");

    // This is a lame approach but is WIP :)
    public IntentionEnum getMessageIntention(final String message) {


        return IntentionEnum.NOT_CLEAR;

    }

}
