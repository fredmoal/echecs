package facades;

import facades.exceptions.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestServicesEchecEnLigne {

    private FonctionnalitesUtilisateurs facadeUtilisateur;
    private FonctionnalitesSalons facadeSalon;


    @Before
    public void initialisation() {
        ServicesEchecEnLigne instance = new ServicesEchecEnLigne();
        facadeUtilisateur = instance;
        facadeSalon = instance;
    }


    /**
     * Méthode testant une inscription successful
     */
    @Test
    public void testInscriptionOK() throws PseudoDejaPrisException {

        facadeUtilisateur.inscription("Yohan","mdp");
        Assert.assertTrue(true);
    }


    /**
     * Méthode testant une inscription successful
     */
    @Test(expected = PseudoDejaPrisException.class)
    public void testInscriptionKO() throws PseudoDejaPrisException {

        facadeUtilisateur.inscription("Yohan","mdp");
        facadeUtilisateur.inscription("Yohan","xxx");
    }


    /**
     * Méthode testant une désinscription réussie
     */
    @Test
    public void testDesincriptionOK() throws PseudoDejaPrisException, DesinscriptionImpossibleException {
        facadeUtilisateur.inscription("Yohan","mdp");
        facadeUtilisateur.desinscription("Yohan","mdp");
        Assert.assertTrue(true);
    }

    /**
     * Méthode testant une désinscription foireuse avec un login inexistant
     */
    @Test(expected = DesinscriptionImpossibleException.class)
    public void testDesincriptionKO1() throws PseudoDejaPrisException, DesinscriptionImpossibleException {
        facadeUtilisateur.desinscription("Yohan","mdp");
    }


    /**
     * Méthode testant une désinscription réussie
     */
    @Test(expected = DesinscriptionImpossibleException.class)
    public void testDesincriptionKO2() throws PseudoDejaPrisException, DesinscriptionImpossibleException {
        facadeUtilisateur.inscription("Yohan","mdp");
        facadeUtilisateur.desinscription("Yohan","mdp1");

    }

    /**
     * Méthode testant une création de salon dans le cas normal
     *  - le joueur est inscrit
     *  - le joueur est connecté
     *  - le nom de salon n'est pas déjà pris
     *
     * @throws PseudoDejaPrisException
     * @throws CouplePseudoMDPIncoherentException
     * @throws SalonPortantCeNomDejaExistantException
     * @throws CreationSalonImpossibleException
     */

    @Test
    public void testCreationSalonOK() throws PseudoDejaPrisException, CouplePseudoMDPIncoherentException, SalonPortantCeNomDejaExistantException, CreationSalonImpossibleException {
        facadeUtilisateur.inscription("Yohan","mdp");
        facadeUtilisateur.connexion("Yohan","mdp");
        facadeSalon.creationSalon("Yohan","monSalon");
        Assert.assertTrue(true);

    }


    /**
     * Méthode testant une création foireuse i.e. il y a une demande
     * de création d'un joueur existant mais non connecté
     *
     * @throws PseudoDejaPrisException
     * @throws CouplePseudoMDPIncoherentException
     * @throws SalonPortantCeNomDejaExistantException
     * @throws CreationSalonImpossibleException
     */

    @Test(expected = CreationSalonImpossibleException.class)
    public void testCreationSalonKO1() throws PseudoDejaPrisException, CouplePseudoMDPIncoherentException, SalonPortantCeNomDejaExistantException, CreationSalonImpossibleException {
        facadeUtilisateur.inscription("Yohan","mdp");
        facadeSalon.creationSalon("Yohan","monSalon");
    }


}
