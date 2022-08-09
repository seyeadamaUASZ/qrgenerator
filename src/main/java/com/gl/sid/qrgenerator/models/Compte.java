package com.gl.sid.qrgenerator.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "db_compte")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numCompte;
    private String name;
    private String phone;
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] qrcode;
    private double balance;


}
