package com.gl.sid.qrgenerator.controllers;

import com.gl.sid.qrgenerator.models.Operation;
import com.gl.sid.qrgenerator.models.Transfert;
import com.gl.sid.qrgenerator.service.ITransfert;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfert")
public class TransfertContoller {
    private ITransfert iTransfert;

    public TransfertContoller(ITransfert iTransfert) {
        this.iTransfert = iTransfert;
    }

    @PostMapping
    public ResponseEntity<Operation> transfertMoneyToAnotherAccount(@RequestBody Transfert transfert){
        return ResponseEntity.ok().body(iTransfert.addTranfert(transfert));
    }
}
