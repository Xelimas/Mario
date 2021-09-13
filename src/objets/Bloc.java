package objets;

import java.awt.*;
import javax.swing.ImageIcon;

public class Bloc extends Objet {

    private Image imgBloc;
    private ImageIcon icoBloc;

    public Bloc(int x, int y) {

        super(x, y, 43, 65);
        this.icoBloc = new ImageIcon(getClass().getResource("/images/bloc.png"));
        this.imgBloc = this.icoBloc.getImage();
    }


    /**
     * @return Image return the imgBloc
     */
    public Image getImgBloc() {
        return imgBloc;
    }

    

}