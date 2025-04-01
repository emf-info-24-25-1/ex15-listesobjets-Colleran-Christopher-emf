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
        if (p != null)
        {
            Personne[] tempPersonne;
            // ajuster la taille du nouveau tableau temporaire +1 par rapport au tableau de base
            tempPersonne = new Personne[personnes.length + 1];
            for (int i = 0; i < personnes.length; i++) {
                tempPersonne[i] = personnes[i];
            }
            tempPersonne[tempPersonne.length - 1] = p;
            marcher = true;
            // met l'ancien tableau à niveau
            personnes = tempPersonne;
        }
        return marcher;
    }

    public boolean supprimer(Personne p) {
        boolean suppressionReussi = false;
        if (p != null)
        {
            Personne[] temp = new Personne[personnes.length - 1];
            int x = 0;
            for (int i = 0; i < personnes.length; i++) {
                if (p != personnes[i]) {
                    temp[x] = personnes[i];
                    x++;
                }
            }
            personnes = temp;
        }
        return suppressionReussi;
    }

    public void afficher() {
        for (int i = 0; i < personnes.length; i++) {
            System.out.println(personnes[i]);
        }
    }
}
