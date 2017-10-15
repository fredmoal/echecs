package plateau;

import pions.DeplacementImpossibleException;
import pions.Pion;

import java.util.Collection;

/**
 * Created by YohanBoichut on 25/09/2017.
 */
public interface EchiquierInterface extends ControleurDeplacementPion {

    Collection<Pion> getPionsJoueur(int idJoueur);
    Collection<Pion> getPionsRestants();
    void deplacerPion(int idJoueur,Pion piece, int x, int y) throws DeplacementImpossibleException,
            DeplacementNonAutoriseException;



}
