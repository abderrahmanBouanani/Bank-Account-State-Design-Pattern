package com.example;

public class CompteNormal implements EtatCompte {
    @Override
    public void retirer(double montant, Compte compte) {
        System.out.println("CompteNormal: Retrait de " + montant + " autorisé.");
    }

    @Override
    public void deposer(double montant, Compte compte) {
        System.out.println("CompteNormal: Dépôt de " + montant + " autorisé.");
    }

    @Override
    public String getEtatName() {
        return "CompteNormal";
    }
}
