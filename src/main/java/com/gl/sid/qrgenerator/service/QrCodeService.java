package com.gl.sid.qrgenerator.service;

public interface QrCodeService {
    byte[] generateQrCode(String qrcontent,int width,int height);
}
