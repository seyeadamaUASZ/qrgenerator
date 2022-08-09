package com.gl.sid.qrgenerator.service.impl;

import com.gl.sid.qrgenerator.models.Compte;
import com.gl.sid.qrgenerator.models.Operation;
import com.gl.sid.qrgenerator.models.Transfert;
import com.gl.sid.qrgenerator.repositories.TransfertRepository;
import com.gl.sid.qrgenerator.service.ICompte;
import com.gl.sid.qrgenerator.service.ITransfert;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransfertImpl implements ITransfert {
    private TransfertRepository repository;
    private ICompte iCompte;

    public TransfertImpl(TransfertRepository repository, ICompte iCompte) {
        this.repository = repository;
        this.iCompte = iCompte;
    }

    @Override
    public Operation addTranfert(Transfert transfert) {
        Optional<Compte> compte = iCompte.getCompteById(transfert.getIdCompteTransfert());
        if(compte.isPresent()){
            Compte compteTo = compte.get();
            double amount = transfert.getAmount() + compteTo.getBalance();
            compteTo.setBalance(amount);
            iCompte.updateCompte(compteTo.getId());

            // compte ayant transfere
            Compte compteAyantTransfere = iCompte.findCompteById(transfert.getCompte().getId());
            double amountDefalque = compteAyantTransfere.getBalance() - transfert.getAmount();
            compteAyantTransfere.setBalance(amountDefalque);
            iCompte.updateCompte(compteAyantTransfere.getId());
            return repository.save(transfert);
        }
        return null;
    }
}
