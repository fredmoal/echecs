package pions;

import plateau.ControleurDeplacementPion;

/**
 * Created by YohanBoichut on 26/09/2017.
 */
public class FabriquePionClassique implements FabriquePion {


    private static FabriquePion monInstance;

    private FabriquePionClassique(){}

    public static FabriquePion getInstance() {
        if (monInstance == null) {
            monInstance = new FabriquePionClassique();
        }
        return monInstance;
    }


    public Pion creation(TypePion p, int x, int y, ControleurDeplacementPion c) {
        switch (p) {
            case CAVALIER: {
                return new Cavalier(x,y);

            }
            case TOUR: {
                return new Tour(x,y);
            }
            case FOU: {
            return new Fou(x,y);
            }case ROI: {
                return new Roi(x,y);
                        }
            case DAME: {
            return new Dame(x,y);
            }
            case PION_ASCENDANT: {
            return new PionBasiqueAscendant(x,y,c);
            }
            case PION_DESCENDANT: {
                return new PionBasiqueDescendant(x,y,c);
            }

        }
        return null;
    }
}
