package jeu;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.*;


public class Scene extends JPanel {
    
    private ImageIcon icoFond;
    private Image imgFond1;
    
    private ImageIcon icoMario;
    private Image imgMario;

    private int xFonds1;
    private int dx;


    public Scene() {

        super();
        this.xFonds1 = -50;
        this.dx = 0;
        icoFond = new ImageIcon(getClass().getResource("/images/fondEcran.png"));
        this.imgFond1 = this.icoFond.getImage();
        icoMario = new ImageIcon(getClass().getResource("/images/marioMarcheDroite.png"));
        this.imgMario = this.icoMario.getImage();

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new Clavier());

        Thread chronoEcran = new Thread(new Chrono());
        chronoEcran.start();
    }

    public void depalcementFond() {
        this.xFonds1 = this.xFonds1 - this.dx;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics2D)g;

        this.depalcementFond();

        g2.drawImage(this.imgFond1, this.xFonds1, 0, null);
        g2.drawImage(imgMario, 300, 245, null);
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
     * @return ImageIcon return the icoMario
     */
    public ImageIcon getIcoMario() {
        return icoMario;
    }

    /**
     * @param icoMario the icoMario to set
     */
    public void setIcoMario(ImageIcon icoMario) {
        this.icoMario = icoMario;
    }

    /**
     * @return Image return the imgMario
     */
    public Image getImgMario() {
        return imgMario;
    }

    /**
     * @param imgMario the imgMario to set
     */
    public void setImgMario(Image imgMario) {
        this.imgMario = imgMario;
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

}