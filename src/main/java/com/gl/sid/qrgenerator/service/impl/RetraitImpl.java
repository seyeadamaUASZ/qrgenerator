package com.gl.sid.qrgenerator.service.impl;

import com.gl.sid.qrgenerator.models.Compte;
import com.gl.sid.qrgenerator.models.Operation;
import com.gl.sid.qrgenerator.models.Retrait;
import com.gl.sid.qrgenerator.repositories.RetraitRepostory;
import com.gl.sid.qrgenerator.service.ICompte;
import com.gl.sid.qrgenerator.service.IRetrait;
import org.springframework.stereotype.Service;

@Service
public class RetraitImpl implements IRetrait {
    private RetraitRepostory repo;
    private ICompte iCompte;

    public RetraitImpl(RetraitRepostory repo, ICompte iCompte) {
        this.repo = repo;
        this.iCompte = iCompte;
    }

    @Override
    public Operation addRetrait(Retrait retrait) {
        Compte compte = iCompte.findCompteById(retrait.getCompte().getId());
        double amount = compte.getBalance() - retrait.getAmount();
        //update compte
        compte.setBalance(amount);
        iCompte.updateCompte(compte.getId());
        return repo.save(retrait);
    }
}
