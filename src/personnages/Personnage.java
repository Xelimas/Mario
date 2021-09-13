package personnages;



public class Personnage {
    
    private int largeur, hauteur;
    private int x, y;
    private boolean marche;
    private boolean versDroite;
    public int compteur;

    public Personnage(int x, int y ,int largeur,int hauteur) {
        this.x = x;
        this.y = y;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.compteur = 0;
        this.marche = false;
        this.versDroite = true;

    }

    

    

    /**
     * @return int return the largeur
     */
    public int getLargeur() {
        return largeur;
    }


    /**
     * @return int return the hauteur
     */
    public int getHauteur() {
        return hauteur;
    }


    /**
     * @return int return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return int return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return boolean return the marche
     */
    public boolean isMarche() {
        return marche;
    }

    /**
     * @param marche the marche to set
     */
    public void setMarche(boolean marche) {
        this.marche = marche;
    }

    /**
     * @return boolean return the versDroite
     */
    public boolean isVersDroite() {
        return versDroite;
    }

    /**
     * @param versDroite the versDroite to set
     */
    public void setVersDroite(boolean versDroite) {
        this.versDroite = versDroite;
    }

}