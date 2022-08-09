package com.gl.sid.qrgenerator.service;

import com.gl.sid.qrgenerator.models.Compte;

import java.util.List;
import java.util.Optional;

public interface ICompte {
     Compte addCompte(Compte compte);
     List<Compte> listCompte();
     Optional<Compte> getCompteById(Long id);
     Compte updateCompte(Long id);
     Compte findCompteByPhone(String phone);
     Compte findCompteById(Long id);
}
