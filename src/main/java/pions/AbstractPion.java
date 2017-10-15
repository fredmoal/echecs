package pions;



/**
 * Created by YohanBoichut on 22/09/2017.
 */
public abstract class AbstractPion implements Pion {

    private int x;
    private int y;


    public AbstractPion() {
        this(X,Y);
    }

    public AbstractPion(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y =y;
    }
}
