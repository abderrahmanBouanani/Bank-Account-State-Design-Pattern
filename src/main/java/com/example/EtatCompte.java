package com.example;

public interface EtatCompte {

    void retirer(double montant, Compte compte) throws Exception;

    void deposer(double montant, Compte compte);

    String getEtatName();
}
