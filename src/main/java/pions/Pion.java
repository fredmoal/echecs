package pions;

/**
 * Created by YohanBoichut on 22/09/2017.
 */
public interface Pion {
    int X = 0;
    int Y = 0;

    int getX();
    int getY();
    void setX(int x);
    void setY(int y);
    void deplacer(int x, int y) throws DeplacementImpossibleException;



}
