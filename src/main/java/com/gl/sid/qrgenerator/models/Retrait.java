package com.gl.sid.qrgenerator.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Retrait extends Operation {
    private double amount;
}
