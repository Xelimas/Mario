package jeu;

import java.awt.event.*;

import jeu.MarioMain;

public class Clavier implements KeyListener{


    @Override
    public void keyPressed(java.awt.event.KeyEvent e) {
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