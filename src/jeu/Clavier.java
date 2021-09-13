package jeu;

import java.awt.event.*;



public class Clavier implements KeyListener{


    @Override
    public void keyPressed(java.awt.event.KeyEvent e) {
        if(MarioMain.scene.getXPos() == -1) {
            MarioMain.scene.setXPos(0);
            MarioMain.scene.setXFonds1(-50);
            MarioMain.scene.setXFonds2(750);
        }
        if (e.getKeyCode() == 68) { // touche D (droite)
           MarioMain.scene.setDx(1);
        }else if (e.getKeyCode() == 81) { // touche Q (gauche)
            MarioMain.scene.setDx(-1); 
        }
        
        
    }


    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {
        MarioMain.scene.setDx(0); 
        
    }

    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {  }

    
    
}