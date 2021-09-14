package personnages;

import java.awt.*;
import javax.swing.ImageIcon;

import jeu.MarioMain;
import objets.Objet;

public class Mario extends Personnage {

    private Image imgMario;
    private ImageIcon icoMario;
    private boolean saut;
    private int compteurSaut; // durée et hauteur du saut

    public Mario(int x, int y) {
        super(x, y, 28, 50);
        this.icoMario = new ImageIcon(getClass().getResource("/images/marioMarcheDroite.png"));
        this.imgMario = this.icoMario.getImage();
        this.saut = false;
        this.compteurSaut = 0;
    }

    public Image saute() {
        ImageIcon ico;
        Image img;
        String str;

        this.compteurSaut++;

        if (this.compteurSaut <= 40) {
            if (this.getY() > MarioMain.scene.getHautPlafond()) {
                this.setY(this.getY() - 4);
            } else {
                this.compteurSaut = 41;
            }
            if (this.isVersDroite() == true) {
                str = "/images/marioSautDroite.png";
            } else {
                str = "/images/marioSautGauche.png";
            }

        } else if (this.getY() + this.getHauteur() < MarioMain.scene.getYSol()) {
            this.setY(this.getY() + 1);
            if (this.isVersDroite() == true) {
                str = "/images/marioSautDroite.png";
            } else {
                str = "/images/marioSautGauche.png";
            }
        } else {
            if (this.isVersDroite() == true) {
                str = "/images/marioArretDroite.png";
            } else {
                str = "/images/marioArretGauche.png";
            }
            this.saut = false;
            this.compteurSaut = 0;
        }
        ico = new ImageIcon(getClass().getResource(str));
        img = ico.getImage();
        return img;
    }

    public void contact(Objet objet) {
        if ((super.contactAvant(objet) == true && this.isVersDroite() == true)
                || (super.contactArriere(objet) == true && this.isVersDroite() == false)) {
            MarioMain.scene.setDx(0);
            this.setMarche(false);
        }
        if (super.contactDessous(objet) == true && this.saut == true) {
            MarioMain.scene.setYSol(objet.getY());
        } else if (super.contactDessous(objet) == false) {
            MarioMain.scene.setYSol(293);
            if (this.saut == false) {
                this.setY(243);
            }
        }
        if (super.contactDessus(objet) == true) {
            MarioMain.scene.setHauteurPlafond(objet.getY() + objet.getHauteur());
        } else if (super.contactDessus(objet) == false && this.saut == false) {
            MarioMain.scene.setHauteurPlafond(0);
        }
    }

    /**
     * @return Image return the imgMario
     */
    public Image getImgMario() {
        return imgMario;
    }

    /**
     * @return boolean return the saut
     */
    public boolean isSaut() {
        return saut;
    }

    /**
     * @param saut the saut to set
     */
    public void setSaut(boolean saut) {
        this.saut = saut;
    }

}