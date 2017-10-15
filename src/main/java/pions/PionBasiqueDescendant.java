package pions;

import plateau.ControleurDeplacementPion;

/**
 * Created by YohanBoichut on 26/09/2017.
 */
public class PionBasiqueDescendant extends PionBasique {

    public PionBasiqueDescendant(ControleurDeplacementPion controleur) {
        super(controleur);
    }

    public PionBasiqueDescendant(int x, int y, ControleurDeplacementPion controleur) {
        super(x, y, controleur);
    }

    public void deplacer(int x, int y) throws DeplacementImpossibleException {
            boolean diagonale = (y ==getY()+1) && ( x == getX()-1||x == getX()+1);
            if ((x == getX() && y ==getY()+1) ||
                    (diagonale && getControleur().isDeplacementPourPionClassiqueAuthorise(this,x,y))) {
                setX(x);
                setY(y);
            }
            else {
                throw new DeplacementImpossibleException();
            }
    }

}
