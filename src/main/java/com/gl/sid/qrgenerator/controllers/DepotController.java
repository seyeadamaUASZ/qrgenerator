package com.gl.sid.qrgenerator.controllers;

import com.gl.sid.qrgenerator.models.Depot;
import com.gl.sid.qrgenerator.models.Operation;
import com.gl.sid.qrgenerator.service.IDepot;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/depot")
public class DepotController {
    private IDepot iDepot;

    public DepotController(IDepot iDepot) {
        this.iDepot = iDepot;
    }

    @PostMapping
    public ResponseEntity<Operation>  depotMoneyToAccount(@RequestBody Depot depot){
        return ResponseEntity.ok().body(iDepot.addDepot(depot));
    }

}
