package facades;

import facades.exceptions.*;
import joueurs.Joueur;
import salons.Salon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ServicesEchecEnLigne implements FonctionnalitesUtilisateurs,FonctionnalitesSalons {

    private Map<String, Joueur> joueursInscrits = new HashMap<String, Joueur>();

    private Set<Joueur> joueursConnectes = new HashSet<Joueur>();

    private Map<String,Salon> lesSalons = new HashMap<String, Salon>();

    private Map<String,String> joueursSalons = new HashMap<String, String>();

    public void inscription(String pseudo, String mdp) throws PseudoDejaPrisException {
        if (joueursInscrits.containsKey(pseudo)) {
            throw new PseudoDejaPrisException();
        }
        joueursInscrits.put(pseudo,Joueur.creerJoueur(pseudo, mdp));


    }

    public void desinscription(String pseudo, String mdp) throws DesinscriptionImpossibleException {
        Joueur j = this.joueursInscrits.get(pseudo);
        if (j == null || !mdp.equals(j.getMdp())) {
            throw new DesinscriptionImpossibleException();
        }
        this.joueursConnectes.remove(j);
        this.joueursInscrits.remove(pseudo);

    }

    public void connexion(String pseudo, String mdp) throws CouplePseudoMDPIncoherentException {
        Joueur j = this.joueursInscrits.get(pseudo);
        if (j == null || !mdp.equals(j.getMdp())) {
            throw new CouplePseudoMDPIncoherentException();
        }
        this.joueursConnectes.add(j);
    }


    public void deconnexion(String pseudo) {
        Joueur j = this.joueursInscrits.get(pseudo);
        if (j != null) {
            this.joueursConnectes.remove(j);
        }
    }

    public void creationSalon(String pseudo, String nomSalon) throws SalonPortantCeNomDejaExistantException,CreationSalonImpossibleException {
        Joueur proprietaire = this.joueursInscrits.get(pseudo);
        if (proprietaire == null || !joueursConnectes.contains(proprietaire)) {
            throw new CreationSalonImpossibleException();
        }

        if (lesSalons.containsKey(nomSalon)) {
            throw new SalonPortantCeNomDejaExistantException();
        }

        Salon salon = Salon.creationSalon(nomSalon,proprietaire);
        lesSalons.put(nomSalon,salon);
        joueursSalons.put(pseudo,nomSalon);
    }
}
