package personnages;

import java.awt.*;
import javax.swing.ImageIcon;

import jeu.MarioMain;

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

        if (this.compteurSaut <= 35) {
            if (this.getY() > MarioMain.scene.getHauteurPlafond()) {
                this.setY(this.getY() - 4);
            } else {
                this.compteurSaut = 36;
            }
            if (this.isVersDroite() == true) {
                str = "/images/marioSautDroite.png";
            } else {
                str = "/images/mariosautGauche.png";
            }
        } else if (this.getY() + this.getHauteur() < MarioMain.scene.getYSol()) {
            this.setY(this.getY() + 1);
            if (this.isVersDroite() == true) {
                str = "/images/marioArretDroite.png";
            } else {
                str = "/images/marioArretGauche";
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