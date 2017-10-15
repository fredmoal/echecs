package pions;


/**
 * Created by YohanBoichut on 22/09/2017.
 */
public class Cavalier extends AbstractPion {
    public static final int VALEUR_DISTANCE_1 = 5;


    public Cavalier() {
        super();
    }

    public Cavalier(int x, int y) {
        super(x, y);
    }

    public void deplacer(int x, int y) throws DeplacementImpossibleException {
    /*
        (x-this.x)^2 + (y-this.y)^2 = 1 ou 2
    */
        int distanceCarree = (x-this.getX())*(x-this.getX()) +
                (y-this.getY())*(y-this.getY());
        if (distanceCarree == VALEUR_DISTANCE_1) {
            this.setX(x);;
            this.setY(y);;
        }
        else {
            throw new DeplacementImpossibleException();
        }
    }

    @Override
    public String toString() {
        return "C";
    }

}
