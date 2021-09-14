package personnages;

import javax.swing.ImageIcon;

import objets.Objet;

import java.awt.*;

public class Tortue extends Personnage implements Runnable {

    private Image imgTortue;
    private ImageIcon icoTortue;

    private final int PAUSE = 15;
    private int dxTortue;

    public Tortue(int x, int y) {
        super(x, y, 43, 50);
        super.setVersDroite(true);
        super.setMarche(true);
        this.dxTortue = 1;
        this.icoTortue = new ImageIcon(getClass().getResource("/images/tortueArretGauche.png"));
        this.imgTortue = this.icoTortue.getImage();

        Thread chronoChamp = new Thread(this);
        chronoChamp.start();

    }

    public void bouge() {
        if (super.isVersDroite() == true) {
            this.dxTortue = 1;
        } else {
            this.dxTortue = -1;
        }
        super.setX(super.getX() + this.dxTortue);
    }

    public void contact(Objet objet) {
        if (super.contactAvant(objet) == true && this.isVersDroite() == true) {
            super.setVersDroite(false);
            this.dxTortue = -1;
        } else if (super.contactArriere(objet) == true && this.isVersDroite() == false) {
            super.setVersDroite(true);
            this.dxTortue = 1;
        }
    }

    public void contact(Personnage personnage) {
        if (super.contactAvant(personnage) == true && this.isVersDroite() == true) {
            super.setVersDroite(false);
            this.dxTortue = -1;
        } else if (super.contactArriere(personnage) == true && this.isVersDroite() == false) {
            super.setVersDroite(true);
            this.dxTortue = 1;
        }
    }

    public Image meurt() {
        String str;
        ImageIcon ico;
        Image img;

        str = "/images/tortueFermee.png";

        ico = new ImageIcon(getClass().getResource(str));
        img = ico.getImage();
        return img;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {

        }
        while (true) {
            if (this.isVivant() == true) {
                this.bouge();

                try {
                    Thread.sleep(PAUSE);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    /**
     * @return Image return the imgTortue
     */
    public Image getImgTortue() {
        return imgTortue;
    }

}