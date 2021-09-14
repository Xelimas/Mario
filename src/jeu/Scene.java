package jeu;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import objets.Bloc;
import objets.Objet;
import objets.TuyauRouge;
import personnages.Mario;

import java.awt.*;
import java.util.ArrayList;

public class Scene extends JPanel {

    private ImageIcon icoFond;
    private Image imgFond1;
    private Image imgFond2;

    private ImageIcon icoChateau1;
    private Image imgChateau1;
    private ImageIcon icoDepart;
    private Image imgDepart;

    private int xFonds1;
    private int xFonds2;
    private int dx;
    private int xPos;
    private int ySol;
    private int hauteurPlafond;

    public Mario mario;

    public TuyauRouge tuyauRouge1;
    public TuyauRouge tuyauRouge2;
    public TuyauRouge tuyauRouge3;
    public TuyauRouge tuyauRouge4;
    public TuyauRouge tuyauRouge5;
    public TuyauRouge tuyauRouge6;
    public TuyauRouge tuyauRouge7;
    public TuyauRouge tuyauRouge8;

    public Bloc bloc1;
    public Bloc bloc2;
    public Bloc bloc3;
    public Bloc bloc4;
    public Bloc bloc5;
    public Bloc bloc6;
    public Bloc bloc7;
    public Bloc bloc8;
    public Bloc bloc9;
    public Bloc bloc10;
    public Bloc bloc11;
    public Bloc bloc12;

    private ImageIcon icoDrapeau;
    private Image imgDrapeau;
    private ImageIcon icoChateauFin;
    private Image imgChateauFin;

    private ArrayList<Objet> tabObjets;

    public Scene() {

        super();
        this.xFonds1 = -50;
        this.xFonds2 = 750;
        this.dx = 0;
        this.xPos = -1;
        this.ySol = 293;
        this.hauteurPlafond = 0;
        icoFond = new ImageIcon(getClass().getResource("/images/fondEcran.png"));
        this.imgFond1 = this.icoFond.getImage();
        this.imgFond2 = this.icoFond.getImage();

        this.icoChateau1 = new ImageIcon(getClass().getResource("/images/chateau1.png"));
        this.imgChateau1 = this.icoChateau1.getImage();
        this.icoDepart = new ImageIcon(getClass().getResource("/images/depart.png"));
        this.imgDepart = this.icoDepart.getImage();

        mario = new Mario(300, 245);
        tuyauRouge1 = new TuyauRouge(600, 230);
        tuyauRouge2 = new TuyauRouge(1000, 230);
        tuyauRouge3 = new TuyauRouge(1600, 230);
        tuyauRouge4 = new TuyauRouge(1900, 230);
        tuyauRouge5 = new TuyauRouge(2500, 230);
        tuyauRouge6 = new TuyauRouge(3000, 230);
        tuyauRouge7 = new TuyauRouge(3800, 230);
        tuyauRouge8 = new TuyauRouge(4500, 230);

        bloc1 = new Bloc(400, 180);
        bloc2 = new Bloc(1200, 180);
        bloc3 = new Bloc(1270, 170);
        bloc4 = new Bloc(1340, 160);
        bloc5 = new Bloc(2000, 180);
        bloc6 = new Bloc(2600, 160);
        bloc7 = new Bloc(2650, 180);
        bloc8 = new Bloc(3500, 160);
        bloc9 = new Bloc(3550, 140);
        bloc10 = new Bloc(4000, 170);
        bloc11 = new Bloc(4200, 200);
        bloc12 = new Bloc(4300, 210);

        this.icoChateauFin = new ImageIcon(getClass().getResource("/images/chateauFin.png"));
        this.imgChateauFin = this.icoChateauFin.getImage();

        this.icoDrapeau = new ImageIcon(getClass().getResource("/images/drapeau.png"));
        this.imgDrapeau = this.icoDrapeau.getImage();

        tabObjets = new ArrayList<Objet>();

        this.tabObjets.add(this.tuyauRouge1);
        this.tabObjets.add(this.tuyauRouge2);
        this.tabObjets.add(this.tuyauRouge3);
        this.tabObjets.add(this.tuyauRouge4);
        this.tabObjets.add(this.tuyauRouge5);
        this.tabObjets.add(this.tuyauRouge6);
        this.tabObjets.add(this.tuyauRouge7);
        this.tabObjets.add(this.tuyauRouge8);

        this.tabObjets.add(this.bloc1);
        this.tabObjets.add(this.bloc2);
        this.tabObjets.add(this.bloc3);
        this.tabObjets.add(this.bloc4);
        this.tabObjets.add(this.bloc5);
        this.tabObjets.add(this.bloc6);
        this.tabObjets.add(this.bloc7);
        this.tabObjets.add(this.bloc8);
        this.tabObjets.add(this.bloc9);
        this.tabObjets.add(this.bloc10);
        this.tabObjets.add(this.bloc11);
        this.tabObjets.add(this.bloc12);

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new Clavier());

        Thread chronoEcran = new Thread(new Chrono());
        chronoEcran.start();
    }

    public void deplacementFond() {

        if (this.xPos >= 0 && this.xPos <= 4430) {
            this.xPos = this.xPos + this.dx;
            this.xFonds1 = this.xFonds1 - this.dx;
            this.xFonds2 = this.xFonds2 - this.dx;
        }

        if (this.xFonds1 == -800) {
            this.xFonds1 = 800;
        } else if (this.xFonds2 == -800) {
            this.xFonds2 = 800;
        } else if (this.xFonds1 == 800) {
            this.xFonds1 = -800;
        } else if (this.xFonds2 == 800) {
            this.xFonds2 = -800;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g;

        for (int i = 0; i < this.tabObjets.size(); i++) {
            if (this.mario.proche(this.tabObjets.get(i))) {
                this.mario.contact(this.tabObjets.get(i));
            }
        }

        this.deplacementFond();
        if (this.xPos >= 0 && this.xPos <= 4430) {
            for (int i = 0; i < this.tabObjets.size(); i++) {
                this.tabObjets.get(i).deplacement();
            }
        }
        g2.drawImage(this.imgFond1, this.xFonds1, 0, null);
        g2.drawImage(this.imgFond2, this.xFonds2, 0, null);
        g2.drawImage(imgChateau1, 10 - this.xPos, 95, null);
        g2.drawImage(imgDepart, 220 - this.xPos, 234, null);

        for (int i = 0; i < this.tabObjets.size(); i++) {
            g2.drawImage(this.tabObjets.get(i).getImgObjet(), this.tabObjets.get(i).getX(),
                    this.tabObjets.get(i).getY(), null);
        }

        g2.drawImage(imgDrapeau, 4650 - this.xPos, 115, null);
        g2.drawImage(imgChateauFin, 5000 - this.xPos, 145, null);

        if (this.mario.isSaut()) {
            g2.drawImage(this.mario.saute(), this.mario.getX(), this.mario.getY(), null);
        } else {
            g2.drawImage(this.mario.marche("mario", 25), this.mario.getX(), this.mario.getY(), null);
        }
    }

    /**
     * @return int return the dx
     */
    public int getDx() {
        return dx;
    }

    /**
     * @param dx the dx to set
     */
    public void setDx(int dx) {
        this.dx = dx;
    }

    /**
     * @return int return the xPos
     */
    public int getXPos() {
        return xPos;
    }

    /**
     * @param xPos the xPos to set
     */
    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    /**
     * @return int return the ySol
     */
    public int getYSol() {
        return ySol;
    }

    /**
     * @return int return the hauteurPlafond
     */
    public int getHautPlafond() {
        return hauteurPlafond;
    }

    /**
     * @param xFonds1 the xFonds1 to set
     */
    public void setXFonds1(int xFonds1) {
        this.xFonds1 = xFonds1;
    }

    /**
     * @param xFonds2 the xFonds2 to set
     */
    public void setXFonds2(int xFonds2) {
        this.xFonds2 = xFonds2;
    }

    /**
     * @return ImageIcon return the icoFond
     */
    public ImageIcon getIcoFond() {
        return icoFond;
    }

    /**
     * @param icoFond the icoFond to set
     */
    public void setIcoFond(ImageIcon icoFond) {
        this.icoFond = icoFond;
    }

    /**
     * @return Image return the imgFond1
     */
    public Image getImgFond1() {
        return imgFond1;
    }

    /**
     * @param imgFond1 the imgFond1 to set
     */
    public void setImgFond1(Image imgFond1) {
        this.imgFond1 = imgFond1;
    }

    /**
     * @return Image return the imgFond2
     */
    public Image getImgFond2() {
        return imgFond2;
    }

    /**
     * @param imgFond2 the imgFond2 to set
     */
    public void setImgFond2(Image imgFond2) {
        this.imgFond2 = imgFond2;
    }

    /**
     * @return ImageIcon return the icoChateau1
     */
    public ImageIcon getIcoChateau1() {
        return icoChateau1;
    }

    /**
     * @param icoChateau1 the icoChateau1 to set
     */
    public void setIcoChateau1(ImageIcon icoChateau1) {
        this.icoChateau1 = icoChateau1;
    }

    /**
     * @return Image return the imgChateau1
     */
    public Image getImgChateau1() {
        return imgChateau1;
    }

    /**
     * @param imgChateau1 the imgChateau1 to set
     */
    public void setImgChateau1(Image imgChateau1) {
        this.imgChateau1 = imgChateau1;
    }

    /**
     * @return ImageIcon return the icoDepart
     */
    public ImageIcon getIcoDepart() {
        return icoDepart;
    }

    /**
     * @param icoDepart the icoDepart to set
     */
    public void setIcoDepart(ImageIcon icoDepart) {
        this.icoDepart = icoDepart;
    }

    /**
     * @return Image return the imgDepart
     */
    public Image getImgDepart() {
        return imgDepart;
    }

    /**
     * @param imgDepart the imgDepart to set
     */
    public void setImgDepart(Image imgDepart) {
        this.imgDepart = imgDepart;
    }

    /**
     * @return int return the xFonds1
     */
    public int getXFonds1() {
        return xFonds1;
    }

    /**
     * @return int return the xFonds2
     */
    public int getXFonds2() {
        return xFonds2;
    }

    /**
     * @param ySol the ySol to set
     */
    public void setYSol(int ySol) {
        this.ySol = ySol;
    }

    /**
     * @return int return the hauteurPlafond
     */
    public int getHauteurPlafond() {
        return hauteurPlafond;
    }

    /**
     * @param hauteurPlafond the hauteurPlafond to set
     */
    public void setHauteurPlafond(int hauteurPlafond) {
        this.hauteurPlafond = hauteurPlafond;
    }

}
