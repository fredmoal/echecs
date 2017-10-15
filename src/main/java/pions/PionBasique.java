package pions;

import plateau.ControleurDeplacementPion;

/**
 * Created by YohanBoichut on 25/09/2017.
 */
public abstract class PionBasique extends AbstractPion {

    public ControleurDeplacementPion getControleur() {
        return controleur;
    }

    private ControleurDeplacementPion controleur;

    public PionBasique(ControleurDeplacementPion controleur) {
        super();
        this.controleur = controleur;
    }

    public PionBasique(int x, int y, ControleurDeplacementPion controleur) {
        super(x, y);
        this.controleur = controleur;
    }


    @Override
    public String toString() {
        return "P";
    }
}
