package programme;

import plateau.EchiquierClassique;
import plateau.EchiquierInterface;

/**
 * Created by YohanBoichut on 26/09/2017.
 */
public class Programme {

    public static void main(String... args) {
        EchiquierInterface monEchiquier = new EchiquierClassique(1,2);
        System.out.println(monEchiquier);
    }
}
