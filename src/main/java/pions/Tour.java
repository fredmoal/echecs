package pions;

/**
 * Created by YohanBoichut on 22/09/2017.
 */
public class Tour extends AbstractPion {

    public Tour() {
        super();

    }

    public Tour(int x, int y) {
        super(x, y);
    }




    public void deplacer(int x, int y)
            throws DeplacementImpossibleException {

        int deplacementHorizontal = Math.abs(x - getX());
        int deplacementVertical = Math.abs(y - getY());

        if ((deplacementVertical>0 && deplacementHorizontal==0) ||
            (deplacementHorizontal >0 && deplacementVertical ==0)) {
            this.setX(x);
            this.setY(y);

        }
        else {
            throw new DeplacementImpossibleException();
        }



    }
    @Override
    public String toString() {
        return "T";
    }

}
