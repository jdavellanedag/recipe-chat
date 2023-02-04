package com.recipe.app.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WebhookService {

    @Value("${app.verify-token}")
    private String VERIFY_TOKEN;
    private String MODE = "subscribe";

    public boolean validateTokenAndMode(final String token, final String mode) {
        return token.equals(VERIFY_TOKEN) && mode.equals(MODE);
    }

}
