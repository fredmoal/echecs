package facades;

import facades.exceptions.CouplePseudoMDPIncoherentException;
import facades.exceptions.DesinscriptionImpossibleException;
import facades.exceptions.PseudoDejaPrisException;

public interface FonctionnalitesUtilisateurs {


    /**
     * Méthode d'inscription
     * @param pseudo du joueur
     * @param mdp du joueur
     * @throws PseudoDejaPrisException levée si le pseudo est déjà pris
     */
    void inscription(String pseudo,String mdp) throws PseudoDejaPrisException;

    /**
     * Méthode de désinscription
     * @param pseudo du joueur
     * @param mdp du joueur
     * @throws DesinscriptionImpossibleException levée si le mot de passe n'est pas
     * valide
     */

    void desinscription(String pseudo,String mdp) throws DesinscriptionImpossibleException;

    /**
     * Méthode de connexion
     * @param pseudo du joueur
     * @param mdp du joueur
     * @throws CouplePseudoMDPIncoherentException levée si le couple pseudo/mdp n'est pas bon
     */

    void connexion(String pseudo, String mdp) throws CouplePseudoMDPIncoherentException;

    /**
     * Méthode de déconnexion. Supprime le joueur des joueurs connectés
     * @param pseudo du joueur à déconnecter
     */

    void deconnexion(String pseudo);

}
