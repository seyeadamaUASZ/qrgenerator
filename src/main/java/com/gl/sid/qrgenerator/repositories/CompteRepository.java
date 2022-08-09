package com.gl.sid.qrgenerator.repositories;

import com.gl.sid.qrgenerator.models.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository <Compte,Long>{
    Compte findCompteByPhone(String phone);
    Compte findCompteById(Long id);
}
