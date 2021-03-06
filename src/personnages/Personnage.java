package personnages;

import java.awt.*;
import javax.swing.ImageIcon;

import jeu.MarioMain;
import objets.Objet;

public class Personnage {

    private int largeur, hauteur;
    private int x, y;
    private boolean marche;
    private boolean versDroite;
    public int compteur;
    protected boolean vivant;

    public Personnage(int x, int y, int largeur, int hauteur) {
        this.x = x;
        this.y = y;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.compteur = 0;
        this.marche = false;
        this.versDroite = true;
        this.vivant = true;

    }

    public Image marche(String nom, int frequence) {

        String str;
        ImageIcon ico;
        Image img;

        if (this.marche == false) {
            if (this.versDroite == true) {
                str = "/images/" + nom + "ArretDroite.png";
            } else {
                str = "/images/" + nom + "ArretGauche.png";
            }
        } else {
            this.compteur++;
            if (this.compteur / frequence == 0) {
                if (this.versDroite == true) {
                    str = "/images/" + nom + "ArretDroite.png";
                } else {
                    str = "/images/" + nom + "ArretGauche.png";
                }
            } else {
                if (this.versDroite == true) {
                    str = "/images/" + nom + "MarcheDroite.png";
                } else {
                    str = "/images/" + nom + "MarcheGauche.png";
                }

            }
            if (this.compteur == 2 * frequence) {
                this.compteur = 0;
            }
        }
        ico = new ImageIcon(getClass().getResource(str));
        img = ico.getImage();
        return img;
    }

    public void deplacement() {
        if (MarioMain.scene.getXPos() >= 0) {
            this.x = this.x - MarioMain.scene.getDx();
        }
    }

    protected boolean contactAvant(Objet objet) {

        if (this.x + this.largeur < objet.getX() || this.x + this.largeur > objet.getX() + 5
                || this.y + this.hauteur <= objet.getY() || this.y >= objet.getY() + objet.getHauteur()) {
            return false;
        } else {
            return true;
        }

    }

    protected boolean contactArriere(Objet objet) {

        if (this.x > objet.getX() + objet.getLargeur() || this.x + this.largeur < objet.getX() + objet.getLargeur() - 5
                || this.y + this.hauteur <= objet.getY() || this.y >= objet.getY() + objet.getHauteur()) {
            return false;
        } else {
            return true;
        }

    }

    protected boolean contactDessous(Objet objet) {

        if (this.x + this.largeur < objet.getX() + 5 || this.x > objet.getX() + objet.getLargeur() - 5
                || this.y + this.hauteur < objet.getY() || this.y + this.hauteur > objet.getY() + 5) {
            return false;
        } else {
            return true;
        }

    }

    protected boolean contactDessus(Objet objet) {

        if (this.x + this.largeur < objet.getX() + 5 || this.x > objet.getX() + objet.getLargeur() - 5
                || this.y < objet.getY() + objet.getHauteur() || this.y > objet.getY() + objet.getHauteur() + 5) {
            return false;
        } else {
            return true;
        }

    }

    public boolean proche(Objet objet) {
        if ((this.x > objet.getX() - 10 && this.x < objet.getX() + objet.getLargeur() + 10)
                || (this.x + this.largeur > objet.getX() - 10
                        && this.x + this.largeur < objet.getX() + objet.getLargeur() + 10)) {
            return true;
        } else {
            return false;
        }
    }

    protected boolean contactAvant(Personnage personnage) {

        if (this.isVersDroite() == true) {
            if (this.x + this.largeur < personnage.getX() || this.x + this.largeur > personnage.getX() + 5
                    || this.y + this.hauteur <= personnage.getY()
                    || this.y >= personnage.getY() + personnage.getHauteur()) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    protected boolean contactArriere(Personnage personnage) {

        if (this.x > personnage.getX() + personnage.getLargeur()
                || this.x + this.largeur < personnage.getX() + personnage.getLargeur() - 5
                || this.y + this.hauteur <= personnage.getY()
                || this.y >= personnage.getY() + personnage.getHauteur()) {
            return false;
        } else {
            return true;
        }

    }

    protected boolean contactDessous(Personnage personnage) {
        if (this.x + this.largeur < personnage.getX() || this.x > personnage.getX() + personnage.getLargeur()
                || this.y + this.hauteur < personnage.getY() || this.y + this.hauteur > personnage.getY()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean proche(Personnage personnage) {
        if ((this.x > personnage.getX() - 10 && this.x < personnage.getX() + personnage.getLargeur() + 10)
                || (this.x + this.largeur > personnage.getX() - 10
                        && this.x + this.largeur < personnage.getX() + personnage.getLargeur() + 10)) {
            return true;
        } else {
            return false;
        }
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

    /**
     * @return boolean return the versDroite
     */
    public boolean isVivant() {
        return vivant;
    }

    /**
     * @param versDroite the versDroite to set
     */
    public void setVivant(boolean vivant) {
        this.vivant = vivant;
    }

}