package com.gl.sid.qrgenerator.controllers;

import com.gl.sid.qrgenerator.service.QrCodeService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QrCodeController {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    private  QrCodeService qrCodeService;

    public QrCodeController(QrCodeService qrCodeService) {
        this.qrCodeService = qrCodeService;
    }


    @GetMapping("/generate-qr-code")
    public ResponseEntity<byte[]> getQrCode() {
        String contentToGenerateQrCode = "http://www.gainde2000.com";
        byte[] qrCode = qrCodeService.generateQrCode(contentToGenerateQrCode, WIDTH, HEIGHT);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(qrCode);
    }


}
