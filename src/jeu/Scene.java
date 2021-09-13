package jeu;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import objets.Bloc;
import objets.TuyauRouge;
import personnages.Mario;

import java.awt.*;

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

    public Mario mario;
    public TuyauRouge tuyauRouge1;
    public Bloc bloc1;

    public Scene() {

        super();
        this.xFonds1 = -50;
        this.xFonds2 = 750;
        this.dx = 0;
        this.xPos = -1;
        icoFond = new ImageIcon(getClass().getResource("/images/fondEcran.png"));
        this.imgFond1 = this.icoFond.getImage();
        this.imgFond2 = this.icoFond.getImage();

        this.icoChateau1 = new ImageIcon(getClass().getResource("/images/chateau1.png"));
        this.imgChateau1 = this.icoChateau1.getImage();
        this.icoDepart = new ImageIcon(getClass().getResource("/images/depart.png"));
        this.imgDepart = this.icoDepart.getImage();

        mario = new Mario(300, 245);
        tuyauRouge1 = new TuyauRouge(600, 230);
        bloc1 = new Bloc(400, 180);

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new Clavier());

        Thread chronoEcran = new Thread(new Chrono());
        chronoEcran.start();
    }

    public void deplacementFond() {

        if (this.xPos >= 0) {
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

        if (this.mario.contactAvant(tuyauRouge1) == true) {
            this.mario.setMarche(false);
            this.dx = 0;
        }

        this.deplacementFond();
        this.tuyauRouge1.deplacement();

        g2.drawImage(this.imgFond1, this.xFonds1, 0, null);
        g2.drawImage(this.imgFond2, this.xFonds2, 0, null);
        g2.drawImage(this.mario.marche("mario", 25), 300, 245, null);
        g2.drawImage(imgChateau1, 10 - this.xPos, 95, null);
        g2.drawImage(imgDepart, 220 - this.xPos, 234, null);
        g2.drawImage(this.tuyauRouge1.getImgTuyauRouge(), this.tuyauRouge1.getX(), this.tuyauRouge1.getY(), null);
        g2.drawImage(this.bloc1.getImgBloc(), this.bloc1.getX() - this.xPos, this.bloc1.getY(), null);
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
     * @param xFonds1 the xFonds1 to set
     */
    public void setXFonds1(int xFonds1) {
        this.xFonds1 = xFonds1;
    }

    /**
     * @return int return the xFonds2
     */
    public int getXFonds2() {
        return xFonds2;
    }

    /**
     * @param xFonds2 the xFonds2 to set
     */
    public void setXFonds2(int xFonds2) {
        this.xFonds2 = xFonds2;
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

}
