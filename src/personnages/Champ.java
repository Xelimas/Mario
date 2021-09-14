package personnages;

import javax.swing.ImageIcon;

import objets.Objet;

import java.awt.*;

public class Champ extends Personnage implements Runnable {

    private Image imgChamp;
    private ImageIcon icoChamp;

    private final int PAUSE = 15;
    private int dxChamp;

    public Champ(int x, int y) {
        super(x, y, 27, 30);
        super.setVersDroite(true);
        super.setMarche(true);
        this.dxChamp = 1;
        this.icoChamp = new ImageIcon(getClass().getResource("/images/champArretDroite.png"));
        this.imgChamp = this.icoChamp.getImage();

        Thread chronoChamp = new Thread(this);
        chronoChamp.start();
    }

    public void bouge() {
        if(super.isVersDroite() == true) {this.dxChamp = 1;}
        else {this.dxChamp = -1;}
        super.setX(super.getX() + this.dxChamp);
    }
    
    public void contact(Objet objet) {
        if(super.contactAvant(objet) == true && this.isVersDroite() == true) {
            super.setVersDroite(false);
            this.dxChamp = -1;
        }else if(super.contactArriere(objet) == true && this.isVersDroite() == false) {
            super.setVersDroite(true);
            this.dxChamp = 1;
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            
        }
        while (true) {
            this.bouge();

            try {
                Thread.sleep(PAUSE);
            } catch (InterruptedException e) {
            }
        }
    }





    /**
     * @return Image return the imgChamp
     */
    public Image getImgChamp() {
        return imgChamp;
    }






    



}