package objets;

import java.awt.*;
import javax.swing.ImageIcon;

public class TuyauRouge extends Objet {

    private Image imgTuyauRouge;
    private ImageIcon icoTuyauRouge;

    public TuyauRouge(int x, int y) {
        super(x, y, 43, 65);
        this.icoTuyauRouge = new ImageIcon(getClass().getResource("/images/tuyauRouge.png"));
        this.imgTuyauRouge = this.icoTuyauRouge.getImage();

    }

    /**
     * @return Image return the imgTuyauRouge
     */
    public Image getImgTuyauRouge() {
        return imgTuyauRouge;
    }

}