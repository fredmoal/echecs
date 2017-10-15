package salons;

import joueurs.Joueur;

import java.util.ArrayList;
import java.util.List;

public class Salon {

    private String nomSalon;
    private Joueur proprietaire;

    private Joueur adversaire;
    private List<Joueur> spectateurs;


    private Salon(String nomSalon, Joueur proprietaire) {
        this.nomSalon = nomSalon;
        this.proprietaire = proprietaire;
        spectateurs = new ArrayList<Joueur>();
    }


    public static Salon creationSalon(String nomSalon, Joueur proprietaire) {
        return new Salon(nomSalon, proprietaire);
    }


    public String getNomSalon() {
        return nomSalon;
    }

    public void setNomSalon(String nomSalon) {
        this.nomSalon = nomSalon;
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Joueur getAdversaire() {
        return adversaire;
    }

    public void setAdversaire(Joueur adversaire) {
        this.adversaire = adversaire;
    }
}
