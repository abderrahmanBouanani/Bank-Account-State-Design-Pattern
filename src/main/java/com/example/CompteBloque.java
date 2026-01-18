package com.example;

public class CompteBloque implements EtatCompte {
    @Override
    public void retirer(double montant, Compte compte) throws Exception {
        System.out.println("CompteBloque: Tentative de retrait de " + montant + " refusée.");
        throw new Exception("Opération refusée : Compte Bloqué !");
    }

    @Override
    public void deposer(double montant, Compte compte) {
        System.out.println("CompteBloque: Dépôt de " + montant + " autorisé.");
    }

    @Override
    public String getEtatName() {
        return "CompteBloque";
    }
}
