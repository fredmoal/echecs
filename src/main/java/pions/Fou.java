package pions;

/**
 * Created by YohanBoichut on 22/09/2017.
 */
public class Fou extends AbstractPion {

    public Fou() {
        super();

    }

    public Fou(int x, int y) {
        super(x, y);
    }




    public void deplacer(int x, int y)
            throws DeplacementImpossibleException {

        int deplacementHorizontal = Math.abs(x - getX());
        int deplacementVertical = Math.abs(y - getY());

        if (deplacementHorizontal>0 &&
                deplacementHorizontal == deplacementVertical) {
            this.setX(x);
            this.setY(y);

        }
        else {
            throw new DeplacementImpossibleException();
        }



    }

    @Override
    public String toString() {
        return "F";
    }
}
