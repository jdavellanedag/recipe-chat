package com.recipe.app.controllers;

import com.recipe.app.models.Payload;
import com.recipe.app.models.data.ValueMessage;
import com.recipe.app.services.WebhookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        log.info("Verification initiated");
        if (webhookService.validateTokenAndMode(token, mode)) {
            log.info("Valid Token");
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        }
        log.warn("Invalid Token");
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PostMapping
    public ResponseEntity<Void> post(@RequestBody Payload<ValueMessage> body) {
        log.info("New message received");
        webhookService.processMessage(body);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
