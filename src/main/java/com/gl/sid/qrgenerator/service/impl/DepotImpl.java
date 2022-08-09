package com.gl.sid.qrgenerator.service.impl;

import com.gl.sid.qrgenerator.models.Compte;
import com.gl.sid.qrgenerator.models.Depot;
import com.gl.sid.qrgenerator.models.Operation;
import com.gl.sid.qrgenerator.repositories.DepotRepository;
import com.gl.sid.qrgenerator.service.ICompte;
import com.gl.sid.qrgenerator.service.IDepot;
import org.springframework.stereotype.Service;

@Service
public class DepotImpl implements IDepot {
   private DepotRepository repository;
   private ICompte iCompte;

    public DepotImpl(DepotRepository repository, ICompte iCompte) {
        this.repository = repository;
        this.iCompte = iCompte;
    }

    @Override
    public Operation addDepot(Depot depot) {
        Compte compte = iCompte.findCompteById(depot.getCompte().getId());
        double amount = depot.getAmount()+ compte.getBalance();
        compte.setBalance(amount);
        iCompte.updateCompte(compte.getId());
        return repository.save(depot);
    }
}
