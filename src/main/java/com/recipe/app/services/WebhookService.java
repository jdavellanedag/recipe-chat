package com.recipe.app.services;

import com.recipe.app.models.Payload;
import com.recipe.app.models.data.ValueMessage;
import com.recipe.app.utils.PayloadUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WebhookService {

    @Autowired
    private MessageService messageService;

    @Value("${app.verify-token}")
    private String VERIFY_TOKEN;
    private final String MODE = "subscribe";

    public boolean validateTokenAndMode(final String token, final String mode) {
        log.info("Validating token");
        return token.equals(VERIFY_TOKEN) && mode.equals(MODE);
    }

    public void processMessage(final Payload<ValueMessage> payload) {
        final String message = PayloadUtils.getTextMessage(payload);
        log.info(String.format("Message: %s", message));
        this.messageService.getMessageIntention(message);
    }

}
