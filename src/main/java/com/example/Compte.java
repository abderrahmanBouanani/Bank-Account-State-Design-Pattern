package com.example;

public class Compte {
    private double solde;
    private EtatCompte etat;
    private EtatTransitionManager manager;

    public Compte(EtatTransitionManager manager) {
        this.manager = manager;
        this.solde = 0.0;
        this.etat = new CompteNormal();
    }

    public void retirer(double montant) {
        try {
            etat.retirer(montant, this);

            this.solde -= montant;

            verifierChangementEtat();

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public void deposer(double montant) {
        etat.deposer(montant, this);

        this.solde += montant;

        verifierChangementEtat();
    }

    private void verifierChangementEtat() {
        EtatCompte nouvelEtat = manager.checkTransition(this);

        if (nouvelEtat.getClass() != etat.getClass()) {
            this.etat = nouvelEtat;
        }
    }

    public double getSolde() {
        return solde;
    }

    public EtatCompte getEtat() {
        return etat;
    }

    public String getEtatName() {
        return etat.getEtatName();
    }
}
