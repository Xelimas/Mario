package jeu;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import affichage.CompteARebours;
import affichage.Score;
import audio.Audio;
import objets.Bloc;
import objets.Objet;
import objets.Piece;
import objets.TuyauRouge;
import personnages.Champ;
import personnages.Mario;
import personnages.Tortue;

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
    private ImageIcon icoDrapeau;
    private Image imgDrapeau;
    private ImageIcon icoChateauFin;
    private Image imgChateauFin;

    private int xFonds1;
    private int xFonds2;

    private int dx;
    private int xPos;
    private int ySol;
    private int hauteurPlafond;
    private boolean ok;

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

    public Piece piece1;
    public Piece piece2;
    public Piece piece3;
    public Piece piece4;
    public Piece piece5;
    public Piece piece6;
    public Piece piece7;
    public Piece piece8;
    public Piece piece9;
    public Piece piece10;

    public Champ champ1;
    public Champ champ2;
    public Champ champ3;
    public Champ champ4;
    public Champ champ5;
    public Champ champ6;
    public Champ champ7;
    public Champ champ8;

    public Tortue tortue1;
    public Tortue tortue2;
    public Tortue tortue3;
    public Tortue tortue4;
    public Tortue tortue5;
    public Tortue tortue6;
    public Tortue tortue7;
    public Tortue tortue8;
    public Tortue tortue9;

    public Mario mario;

    private ArrayList<Objet> tabObjets;
    private ArrayList<Piece> tabPieces;

    private ArrayList<Champ> tabChamps;
    private ArrayList<Tortue> tabTortues;

    private Score score;
    private Font police;
    private CompteARebours compteARebours;

    public Scene() {

        super();
        this.xFonds1 = -50;
        this.xFonds2 = 750;
        this.dx = 0;
        this.xPos = -1;
        this.ySol = 293;
        this.hauteurPlafond = 0;
        this.ok = true;
        icoFond = new ImageIcon(getClass().getResource("/images/fondEcran.png"));
        this.imgFond1 = this.icoFond.getImage();
        this.imgFond2 = this.icoFond.getImage();

        this.icoChateau1 = new ImageIcon(getClass().getResource("/images/chateau1.png"));
        this.imgChateau1 = this.icoChateau1.getImage();
        this.icoDepart = new ImageIcon(getClass().getResource("/images/depart.png"));
        this.imgDepart = this.icoDepart.getImage();

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

        piece1 = new Piece(402, 145);
        piece2 = new Piece(1202, 140);
        piece3 = new Piece(1272, 95);
        piece4 = new Piece(1342, 40);
        piece5 = new Piece(1650, 145);
        piece6 = new Piece(2650, 145);
        piece7 = new Piece(3000, 135);
        piece8 = new Piece(3400, 125);
        piece9 = new Piece(4200, 145);
        piece10 = new Piece(4600, 40);

        champ1 = new Champ(800, 263);
        champ2 = new Champ(1100, 263);
        champ3 = new Champ(2100, 263);
        champ4 = new Champ(2400, 263);
        champ5 = new Champ(3200, 263);
        champ6 = new Champ(3500, 263);
        champ7 = new Champ(3700, 263);
        champ8 = new Champ(4500, 263);

        tortue1 = new Tortue(950, 243);
        tortue2 = new Tortue(1500, 243);
        tortue3 = new Tortue(1800, 243);
        tortue4 = new Tortue(2400, 243);
        tortue5 = new Tortue(3100, 243);
        tortue6 = new Tortue(3600, 243);
        tortue7 = new Tortue(3900, 243);
        tortue8 = new Tortue(4200, 243);
        tortue9 = new Tortue(4400, 243);

        mario = new Mario(300, 245);

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

        tabPieces = new ArrayList<Piece>();

        this.tabPieces.add(this.piece1);
        this.tabPieces.add(this.piece2);
        this.tabPieces.add(this.piece3);
        this.tabPieces.add(this.piece4);
        this.tabPieces.add(this.piece5);
        this.tabPieces.add(this.piece6);
        this.tabPieces.add(this.piece7);
        this.tabPieces.add(this.piece8);
        this.tabPieces.add(this.piece9);
        this.tabPieces.add(this.piece10);

        tabChamps = new ArrayList<Champ>();
        this.tabChamps.add(this.champ1);
        this.tabChamps.add(this.champ2);
        this.tabChamps.add(this.champ3);
        this.tabChamps.add(this.champ4);
        this.tabChamps.add(this.champ5);
        this.tabChamps.add(this.champ6);
        this.tabChamps.add(this.champ7);
        this.tabChamps.add(this.champ8);

        tabTortues = new ArrayList<Tortue>();

        this.tabTortues.add(this.tortue1);
        this.tabTortues.add(this.tortue2);
        this.tabTortues.add(this.tortue3);
        this.tabTortues.add(this.tortue4);
        this.tabTortues.add(this.tortue5);
        this.tabTortues.add(this.tortue6);
        this.tabTortues.add(this.tortue7);
        this.tabTortues.add(this.tortue8);
        this.tabTortues.add(this.tortue9);

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new Clavier());

        score = new Score();
        police = new Font("Arial", Font.PLAIN, 18);
        compteARebours = new CompteARebours();

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

    private boolean partieGagnee() {
        if (this.compteARebours.getCompteurTemps() > 0 && this.mario.isVivant() == true
                && this.score.getNbrePiece() == 10 && this.xPos > 4400) {
            if (this.ok == true) {

                Audio.playSound("/audio/partieGagnee.wav");
                this.ok = false;

            }
            return true;
        } else {
            return false;
        }
    }

    private boolean partiePerdue() {
        if (this.mario.isVivant() == false || this.compteARebours.getCompteurTemps() <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean finDePartie() {
        if (this.partieGagnee() == true || this.partiePerdue() == true) {
            return true;
        } else {
            return false;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g;

        for (int i = 0; i < this.tabObjets.size(); i++) {
            if (this.mario.proche(this.tabObjets.get(i))) {
                this.mario.contact(this.tabObjets.get(i));
            }
            for (int j = 0; j < this.tabChamps.size(); j++) {
                if (this.tabChamps.get(j).proche(this.tabObjets.get(i))) {
                    this.tabChamps.get(j).contact(this.tabObjets.get(i));
                }
            }
            for (int j = 0; j < this.tabTortues.size(); j++) {
                if (this.tabTortues.get(j).proche(this.tabObjets.get(i))) {
                    this.tabTortues.get(j).contact(this.tabObjets.get(i));
                }
            }

        }

        for (int i = 0; i < this.tabPieces.size(); i++) {
            if (this.mario.proche(this.tabPieces.get(i))) {
                if (this.mario.contactPiece(this.tabPieces.get(i))) {
                    Audio.playSound("/audio/piece.wav");
                    this.tabPieces.remove(i);
                    this.score.setNbrePieces(this.score.getNbrePiece() + 1);
                }
            }
        }

        for (int i = 0; i < this.tabChamps.size(); i++) {

            for (int j = 0; j < this.tabChamps.size(); j++) {
                if (j != i) {
                    if (this.tabChamps.get(j).proche(this.tabChamps.get(i))) {
                        this.tabChamps.get(j).contact(this.tabChamps.get(i));
                    }
                }
            }
            for (int j = 0; j < this.tabTortues.size(); j++) {
                if (this.tabTortues.get(j).proche(this.tabChamps.get(i))) {
                    this.tabTortues.get(j).contact(this.tabChamps.get(i));
                }
            }
        }

        for (int i = 0; i < this.tabTortues.size(); i++) {

            for (int j = 0; j < this.tabChamps.size(); j++) {
                if (this.tabChamps.get(j).proche(this.tabTortues.get(i))) {
                    this.tabChamps.get(j).contact(this.tabTortues.get(i));
                }
            }
            for (int j = 1; j < this.tabTortues.size(); j++) {
                if (j != i) {
                    if (this.tabTortues.get(j).proche(this.tabTortues.get(i))) {
                        this.tabTortues.get(j).contact(this.tabTortues.get(i));
                    }
                }
            }
        }

        for (int i = 0; i < this.tabChamps.size(); i++) {
            if (this.mario.proche(this.tabChamps.get(i)) && this.tabChamps.get(i).isVivant() == true) {
                this.mario.contact(this.tabChamps.get(i));
                if (this.tabChamps.get(i).isVivant() == false) {
                    Audio.playSound("/audio/ecrasePersonnage.wav");
                }
            }
        }
        for (int i = 0; i < this.tabTortues.size(); i++) {
            if (this.mario.proche(this.tabTortues.get(i)) && this.tabTortues.get(i).isVivant() == true) {
                this.mario.contact(this.tabTortues.get(i));
                if (this.tabTortues.get(i).isVivant() == false) {
                    Audio.playSound("/audio/ecrasePersonnage.wav");
                }
            }
        }

        this.deplacementFond();
        if (this.xPos >= 0 && this.xPos <= 4430) {
            for (int i = 0; i < this.tabObjets.size(); i++) {
                this.tabObjets.get(i).deplacement();
            }
            for (int i = 0; i < this.tabPieces.size(); i++) {
                this.tabPieces.get(i).deplacement();
            }
            for (int i = 0; i < this.tabChamps.size(); i++) {
                this.tabChamps.get(i).deplacement();
            }
            for (int i = 0; i < this.tabTortues.size(); i++) {
                this.tabTortues.get(i).deplacement();
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

        for (int i = 0; i < this.tabPieces.size(); i++) {
            g2.drawImage(this.tabPieces.get(i).bouge(), this.tabPieces.get(i).getX(), this.tabPieces.get(i).getY(),
                    null);
        }

        g2.drawImage(imgDrapeau, 4650 - this.xPos, 115, null);
        g2.drawImage(imgChateauFin, 5000 - this.xPos, 145, null);
        if (this.mario.isVivant() == true) {
            if (this.mario.isSaut()) {
                g2.drawImage(this.mario.saute(), this.mario.getX(), this.mario.getY(), null);
            } else {
                g2.drawImage(this.mario.marche("mario", 25), this.mario.getX(), this.mario.getY(), null);
            }
        } else {
            g2.drawImage(this.mario.meurt(), this.mario.getX(), this.mario.getY(), null);
        }

        for (int i = 0; i < this.tabChamps.size(); i++) {
            if (this.tabChamps.get(i).isVivant() == true) {
                g2.drawImage(this.tabChamps.get(i).marche("champ", 45), this.tabChamps.get(i).getX(),
                        this.tabChamps.get(i).getY(), null);
            } else {
                g2.drawImage(this.tabChamps.get(i).meurt(), this.tabChamps.get(i).getX(),
                        this.tabChamps.get(i).getY() + 20, null);
            }
        }

        for (int i = 0; i < this.tabTortues.size(); i++) {
            if (this.tabTortues.get(i).isVivant() == true) {
                g2.drawImage(this.tabTortues.get(i).marche("tortue", 50), this.tabTortues.get(i).getX(),
                        this.tabTortues.get(i).getY(), null);
            } else {
                g2.drawImage(this.tabTortues.get(i).meurt(), this.tabTortues.get(i).getX(),
                        this.tabTortues.get(i).getY() + 30, null);

            }
        }

        g2.setFont(police);
        g2.drawString(this.score.getNbrePiece() + " pièces trouvées sur " + this.score.getNBRE_TOTAL_PIECES(), 460, 25);
        g2.drawString(this.compteARebours.getStr(), 5, 25);

        if (this.finDePartie() == true) {
            Font policeFin = new Font("Arial", Font.BOLD, 50);
            g2.setFont(policeFin);
            if (this.partieGagnee() == true) {
                g2.drawString("Vous avez gagné !! ", 120, 180);
            } else {
                g2.drawString("Vous avez perdu .... ", 120, 180);
            }
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
