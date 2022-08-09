package com.gl.sid.qrgenerator.controllers;

import com.gl.sid.qrgenerator.models.Compte;
import com.gl.sid.qrgenerator.service.ICompte;
import com.gl.sid.qrgenerator.service.QrCodeService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/compte")
public class CompteController {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private ICompte iCompte;
    private QrCodeService qrCodeService;

    public CompteController(ICompte iCompte, QrCodeService qrCodeService) {
        this.iCompte = iCompte;
        this.qrCodeService = qrCodeService;
    }

    @PostMapping
    public ResponseEntity<Compte> createAccount(@RequestBody Compte compte){
        String contentToGenerateQrCode ="http://localhost:9070/compte/"+compte.getId();
        byte[] qrCode = qrCodeService.generateQrCode(contentToGenerateQrCode, WIDTH, HEIGHT);
        compte.setQrcode(qrCode);
        return ResponseEntity.ok().body(iCompte.addCompte(compte));
    }

    @GetMapping("qrcode/{id}")
    public ResponseEntity<byte[]> getQrCode(@PathVariable Long id) {
        Optional<Compte> comp = iCompte.getCompteById(id);
        if(comp.isPresent()){
            Compte co = comp.get();
            return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(co.getQrcode());
        }
        return null;
    }



    @GetMapping
    public ResponseEntity<List<Compte>> accountList(){
        return ResponseEntity.ok().body(iCompte.listCompte());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compte> checkAccount(@PathVariable Long id){
        Optional<Compte> optionalCompte = iCompte.getCompteById(id);
        if(optionalCompte.isPresent()){
            Compte compte = optionalCompte.get();
            return ResponseEntity.ok().body(compte);
        }
        return null;
    }
}
