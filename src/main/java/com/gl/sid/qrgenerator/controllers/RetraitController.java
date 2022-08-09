package com.gl.sid.qrgenerator.controllers;

import com.gl.sid.qrgenerator.models.Operation;
import com.gl.sid.qrgenerator.models.Retrait;
import com.gl.sid.qrgenerator.service.IRetrait;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/retrait")
public class RetraitController {
    private IRetrait iRetrait;

    public RetraitController(IRetrait iRetrait) {
        this.iRetrait = iRetrait;
    }

    @PostMapping
    public ResponseEntity<Operation> retireMoneyToAccount(@RequestBody Retrait retrait){
        return ResponseEntity.ok().body(iRetrait.addRetrait(retrait));
    }
}
