package services;

import models.Personne;

public class ListePersonne_Dynamique {

    private Personne[] personnes;

    public ListePersonne_Dynamique() {
        this.personnes = new Personne[0];
    }

    public int getNombre() {
        return personnes.length;
    }

    public void vider() {
        for (int i = 0; i < personnes.length; i++) {
            personnes[i] = null;
        }
        personnes = new Personne[0];
    }

    public boolean ajouter(Personne p) {
        boolean marcher = false;
        Personne[] tempPersonne;
        // ajouter la valeur
        tempPersonne = new Personne[personnes.length + 1];
        for (int i = 0; i < personnes.length; i++) {
            tempPersonne[i] = personnes[i];
        }
        tempPersonne[tempPersonne.length - 1] = p;
        marcher = true;
        // met l'ancien tableau à niveau
        personnes = tempPersonne;
        return marcher;
    }

    public boolean supprimer(Personne p) {
        boolean marcher = false;
        Personne[] tempPersonne;
        tempPersonne = new Personne[personnes.length - 1];
        // ça va chercher la valeur
        /*for (int i = 0; i < tempPersonne.length; i++) {
            if (tempPersonne[i] == p) {
                tempPersonne[i] = null;
                marcher = true;
                // ça va bouger les valeurs
                for (int j = i; j < tempPersonne.length; j++) {
                    tempPersonne[j] = tempPersonne[j + 1];
                    if (j == tempPersonne.length - 1) {
                        break;
                    }
                }
                personnes = tempPersonne;
            }
        }*/
        int x = 0;
        for (int i = 0; i < personnes.length; i++) {
            if (p != personnes[i]) {
                tempPersonne[i] = personnes[x];
                x++;
            }
            else{
                x++;
            }
        }
        marcher = true;
        personnes = tempPersonne;
        return marcher;
    }

    public void afficher() {
        for (int i = 0; i < personnes.length; i++) {
            System.out.println(personnes[i]);
        }
    }
}
