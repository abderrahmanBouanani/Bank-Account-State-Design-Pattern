package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class EtatTransitionManager {

    private static class Transition {
        Class<? extends EtatCompte> source;
        Class<? extends EtatCompte> cible;
        Predicate<Compte> condition;

        public Transition(Class<? extends EtatCompte> source, Class<? extends EtatCompte> cible,
                Predicate<Compte> condition) {
            this.source = source;
            this.cible = cible;
            this.condition = condition;
        }
    }

    private List<Transition> transitions;

    private EtatTransitionManager(List<Transition> transitions) {
        this.transitions = transitions;
    }

    public EtatCompte checkTransition(Compte compte) {
        EtatCompte etatActuel = compte.getEtat();

        for (Transition t : transitions) {
            if (t.source.equals(etatActuel.getClass()) && t.condition.test(compte)) {
                try {
                    return t.cible.getDeclaredConstructor().newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException("Erreur lors de la création de l'état : " + t.cible.getName());
                }
            }
        }

        return etatActuel;
    }

    public static class Builder {
        private List<Transition> transitions = new ArrayList<>();

        public Builder addTransition(Class<? extends EtatCompte> source, Class<? extends EtatCompte> cible,
                Predicate<Compte> condition) {
            transitions.add(new Transition(source, cible, condition));
            return this;
        }

        public EtatTransitionManager build() {
            return new EtatTransitionManager(transitions);
        }
    }
}
