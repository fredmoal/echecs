package joueurs;

public class Joueur {

    private String pseudo;
    private String mdp;

    private Joueur(String pseudo, String mdp) {
        this.pseudo = pseudo;
        this.mdp = mdp;
    }


    public static Joueur creerJoueur(String nom, String mdp) {
        return new Joueur(nom,mdp);
    }



    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}


