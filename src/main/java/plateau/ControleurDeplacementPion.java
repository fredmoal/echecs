package plateau;

import pions.Pion;
import pions.PionBasique;

/**
 * Created by YohanBoichut on 26/09/2017.
 */
public interface ControleurDeplacementPion {
    boolean isDeplacementPourPionClassiqueAuthorise(Pion pion, int x, int y);
    boolean isTransformationDamePossible(PionBasique pionBasique);
    boolean isTransformationDamePossible(Pion pionBasique);
    void transformationDame(PionBasique pionBasique) throws TransformationNonSupporteeException;
    void transformationDame(Pion pionBasique) throws TransformationNonSupporteeException;

}
