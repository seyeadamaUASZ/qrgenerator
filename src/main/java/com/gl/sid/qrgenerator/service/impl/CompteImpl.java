package com.gl.sid.qrgenerator.service.impl;

import com.gl.sid.qrgenerator.models.Compte;
import com.gl.sid.qrgenerator.repositories.CompteRepository;
import com.gl.sid.qrgenerator.service.ICompte;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompteImpl implements ICompte {
    private CompteRepository repo;

    public CompteImpl(CompteRepository repo) {
        this.repo = repo;
    }

    @Override
    public Compte addCompte(Compte compte) {
        int max = 100;
        int min = 1;
        int range = max - min + 1;
        String numCompte = "CO"+(int)(Math.random() * range) + min;
        compte.setNumCompte(numCompte);
        return repo.save(compte);
    }

    @Override
    public List<Compte> listCompte() {
        return repo.findAll();
    }

    @Override
    public Optional<Compte> getCompteById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Compte updateCompte(Long id) {
        Optional<Compte> compteOp = repo.findById(id);
        if(compteOp.isPresent()){
            Compte compte = compteOp.get();
            compte.setId(id);
            return repo.saveAndFlush(compte);
        }
        return null;
    }

    @Override
    public Compte findCompteByPhone(String phone) {
        return repo.findCompteByPhone(phone);
    }

    @Override
    public Compte findCompteById(Long id) {
        return repo.findCompteById(id);
    }
}
