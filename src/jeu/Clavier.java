package jeu;

import java.awt.event.*;

public class Clavier implements KeyListener {

    @Override
    public void keyPressed(java.awt.event.KeyEvent e) {

        if (e.getKeyCode() == 68) { // touche D (droite)
            if (MarioMain.scene.getXPos() == -1) {
                MarioMain.scene.setXPos(0);
                MarioMain.scene.setXFonds1(-50);
                MarioMain.scene.setXFonds2(750);
            }
            MarioMain.scene.mario.setMarche(true);
            MarioMain.scene.mario.setVersDroite(true);
            MarioMain.scene.setDx(1);
        } else if (e.getKeyCode() == 81) { // touche Q (gauche)
            if (MarioMain.scene.getXPos() == 4431) {
                MarioMain.scene.setXPos(4430);
                MarioMain.scene.setXFonds1(-50);
                MarioMain.scene.setXFonds2(750);
            }
            MarioMain.scene.mario.setMarche(true);
            MarioMain.scene.mario.setVersDroite(false);
            MarioMain.scene.setDx(-1);
        }
        if(e.getKeyCode() == 90) { // touche Z (saut)
            MarioMain.scene.mario.setSaut(true);
        }

    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {
        MarioMain.scene.mario.setMarche(false);
        MarioMain.scene.setDx(0);

    }

    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {
    }

}