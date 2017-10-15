package plateau;

import pions.*;

import java.util.*;

import static pions.FabriquePion.TypePion.*;

/**
 * Created by YohanBoichut on 25/09/2017.
 */
public class EchiquierClassique implements EchiquierInterface {

    private static final int NB_COLONNES = 8;
    private static final int NB_LIGNES = 8;
    private static final int NB_JOUEURS = 2;
    public static final int ID_JOUEUR_1 = 0;
    public static final int ID_JOUEUR_2 = 1;

    private Map<Integer,Integer> joueurs;
    private Collection<Pion>[] pionsJoueurs;

    private Pion[][] plateau;

    private static final FabriquePion.TypePion[][] DISPOSITION = new FabriquePion.TypePion[][]{{TOUR,PION},{CAVALIER,PION},{FOU,PION},{DAME,PION},{ROI,PION},{FOU,PION},{CAVALIER,PION},{TOUR,PION}};


    public EchiquierClassique(int idJoueur1, int idJoueur2) {

        joueurs = new HashMap<Integer, Integer>();
        pionsJoueurs = new Collection[NB_JOUEURS];
        joueurs.put(idJoueur1, ID_JOUEUR_1);
        joueurs.put(idJoueur2, ID_JOUEUR_2);
        pionsJoueurs[ID_JOUEUR_1] = new ArrayList<Pion>();
        pionsJoueurs[ID_JOUEUR_2] = new ArrayList<Pion>();
        initialiserPlateau();

    }



    private void initialiserPlateau() {
        plateau = new Pion[NB_COLONNES][NB_LIGNES];
        for (int i=0; i<NB_COLONNES;i++) {
            plateau[i][7]=FabriquePionClassique.getInstance().creation(DISPOSITION[i][0]==PION ? PION_ASCENDANT:DISPOSITION[i][0],i,7,this);
            plateau[i][6]=FabriquePionClassique.getInstance().creation(DISPOSITION[i][1]==PION ? PION_ASCENDANT:DISPOSITION[i][1],i,6,this);
            plateau[i][0]=FabriquePionClassique.getInstance().creation(DISPOSITION[i][0]==PION ? PION_DESCENDANT:DISPOSITION[i][0],i,0,this);
            plateau[i][1]=FabriquePionClassique.getInstance().creation(DISPOSITION[i][1]==PION ? PION_DESCENDANT:DISPOSITION[i][1],i,1,this);
        }
    }

    public Pion[][] getPlateau() {
        return plateau;
    }

    public Collection<Pion> getPionsJoueur(int idJoueur) {
        return pionsJoueurs[joueurs.get(idJoueur)];
    }



    public Collection<Pion> getPionsRestants() {
        Collection<Pion> resultat = new ArrayList<Pion>();
        for (Collection<Pion> c : pionsJoueurs) {
            resultat.addAll(c);
        }
        return resultat;
    }

    public void deplacerPion(int idJoueur, Pion piece, int x, int y) throws DeplacementImpossibleException, DeplacementNonAutoriseException {
        if (x<0 || y <0 || x>= NB_COLONNES || y >= NB_LIGNES) {
            throw new DeplacementNonAutoriseException();
        }

        if (plateau[x][y]!= null && pionsJoueurs[idJoueur].contains(plateau[x][y]!= null))
            throw new DeplacementNonAutoriseException();

        piece.deplacer(x,y);
        if (plateau[x][y]!= null) {
            int idAdversaire = joueurs.get(idJoueur)==ID_JOUEUR_1?ID_JOUEUR_2:ID_JOUEUR_1;
            pionsJoueurs[idAdversaire].remove(plateau[x][y]);

        }
        plateau[x][y] = piece;


    }

    public boolean isDeplacementPourPionClassiqueAuthorise(Pion p, int x, int y) {
        int idJoueur = pionsJoueurs[ID_JOUEUR_1].contains(p)?ID_JOUEUR_1:ID_JOUEUR_2;
        return getPlateau()[x][y] != null && !pionsJoueurs[idJoueur].contains(getPlateau()[x][y]);
    }

    public boolean isTransformationDamePossible(PionBasique pionBasique) {
        int idJoueur = pionsJoueurs[ID_JOUEUR_1].contains(pionBasique)?ID_JOUEUR_1:ID_JOUEUR_2;
        int borne = joueurs.get(idJoueur) == ID_JOUEUR_2? NB_LIGNES-1:0;
        return pionBasique.getY()== borne;
    }

    public boolean isTransformationDamePossible(Pion pionBasique) {
        return false;
    }

    public void transformationDame(PionBasique pionBasique) throws TransformationNonSupporteeException {
        int idJoueur = pionsJoueurs[ID_JOUEUR_1].contains(pionBasique)?ID_JOUEUR_1:ID_JOUEUR_2;
        Pion nouvelleDame = FabriquePionClassique.getInstance().creation(DAME,pionBasique.getX(),pionBasique.getY(),this);
        pionsJoueurs[idJoueur].remove(pionBasique);
        pionsJoueurs[idJoueur].add(nouvelleDame);
    }

    public void transformationDame(Pion pionBasique) throws TransformationNonSupporteeException {
        throw new TransformationNonSupporteeException();
    }


    @Override
    public String toString() {
        String resultat = "";
        for(int i=0;i<NB_LIGNES;i++) {
            for(int j=0;j<NB_COLONNES;j++) {
                resultat+="["+(plateau[j][i]==null?" ":plateau[j][i])+"]" ;
            }
            resultat+="\n";
        }

        return resultat;

    }

}
