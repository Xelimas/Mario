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


    public Scene() {

        super();
        this.xFonds1 = -50;
        icoFond = new ImageIcon(getClass().getResource("/images/fondEcran.png"));
        this.imgFond1 = this.icoFond.getImage();
        icoMario = new ImageIcon(getClass().getResource("/images/marioMarcheDroite.png"));
        this.imgMario = this.icoMario.getImage();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics2D)g;

        g2.drawImage(this.imgFond1, this.xFonds1, 0, null);
        g2.drawImage(imgMario, 300, 245, null);
    }
}