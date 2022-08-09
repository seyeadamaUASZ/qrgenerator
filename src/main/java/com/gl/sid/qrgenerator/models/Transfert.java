package com.gl.sid.qrgenerator.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TR")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transfert  extends Operation{
    private double amount;
    private Long idCompteTransfert;
}
