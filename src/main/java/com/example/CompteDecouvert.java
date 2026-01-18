package com.example;

public class CompteDecouvert implements EtatCompte {
    @Override
    public void retirer(double montant, Compte compte) {
        System.out.println("Attention: Compte à découvert. Retrait de " + montant + " autorisé.");
    }

    @Override
    public void deposer(double montant, Compte compte) {
        System.out.println("CompteDecouvert: Dépôt de " + montant + " autorisé.");
    }

    @Override
    public String getEtatName() {
        return "CompteDecouvert";
    }
}
