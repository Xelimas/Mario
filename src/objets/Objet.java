package objets;

import java.awt.*;
import javax.swing.ImageIcon;

import jeu.MarioMain;

public class Objet {

    private int largeur, hauteur;
    private int x, y;

    protected Image imgObjet;
    protected ImageIcon icoObjet;

    public Objet(int x, int y, int largeur, int hauteur) {
        this.x = x;
        this.y = y;
        this.largeur = largeur;
        this.hauteur = hauteur;

    }

    public void deplacement() {
        if (MarioMain.scene.getXPos() >= 0) {
            this.x = this.x - MarioMain.scene.getDx();
        }
    }

    /**
     * @return int return the largeur
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * @param largeur the largeur to set
     */
    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    /**
     * @return int return the hauteur
     */
    public int getHauteur() {
        return hauteur;
    }

    /**
     * @param hauteur the hauteur to set
     */
    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
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
     * @return Image return the imgObjet
     */
    public Image getImgObjet() {
        return imgObjet;
    }

}