package personnages;

import java.awt.*;
import javax.swing.ImageIcon;

public class Mario extends Personnage {

    private Image imgMario;
    private ImageIcon icoMario;

    public Mario(int x, int y) {
        super(x, y, 28, 50);
        this.icoMario = new ImageIcon(getClass().getResource("/images/marioMarcheDroite.png"));
        this.imgMario = this.icoMario.getImage();
    }

    /**
     * @return Image return the imgMario
     */
    public Image getImgMario() {
        return imgMario;
    }

}