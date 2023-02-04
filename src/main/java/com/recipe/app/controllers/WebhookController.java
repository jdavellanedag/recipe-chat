package com.recipe.app.controllers;

import com.recipe.app.services.WebhookService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("webhook")
@Slf4j
public class WebhookController {

    @Autowired
    private WebhookService webhookService;

    @GetMapping
    public ResponseEntity<Integer> get(
            @RequestParam(name = "hub.mode") String mode,
            @RequestParam(name = "hub.challenge") int challenge,
            @RequestParam(name = "hub.verify_token") String token ) {
        log.info(String.format("Verification initiated with %s and %s", mode, token));
        if (webhookService.validateTokenAndMode(token, mode)) {
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

}
