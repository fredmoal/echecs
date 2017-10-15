package pions;

import plateau.ControleurDeplacementPion;

/**
 * Created by YohanBoichut on 26/09/2017.
 */
public interface FabriquePion {
    enum TypePion  {TOUR,CAVALIER,FOU,ROI,DAME,
        PION_ASCENDANT,PION_DESCENDANT,PION};

    Pion creation(TypePion p, int x, int y, ControleurDeplacementPion c);
}
