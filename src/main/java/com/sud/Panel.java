package com.sud;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Panel extends JPanel {
    // Crea una instancia de Player
    private Player player;

    private SpriteSheet spriteSheet;

    public Panel() {

        // Carga tu spritesheet aquí
        spriteSheet = new SpriteSheet("alpha/src/main/resources/sprites/spritesheet-player.png", 96, 104);

        // Inicializa el jugador
        player = new Player(10, 10, spriteSheet, 60,60);       


        Timer walkd = new Timer(60, new ActionListener() {
            private int spriteIndex = 0;
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cambia al siguiente sprite en la primera fila cada vez que se activa el timer
                player.changeSprite(spriteIndex, 7, spriteSheet); // 0 representa la primera fila
                spriteIndex = (spriteIndex + 1) % 10; // 10 es el número de sprites en cada fila
        
                // Repinta el panel para reflejar el cambio de sprite
                repaint();
            }
        });
        Timer walka = new Timer(60,new ActionListener() {
            private int spriteIndex = 0;
           
            @Override
            public void actionPerformed(ActionEvent e) {
               player.changeSprite(spriteIndex, 4, spriteSheet); // 0 representa la primera fila
               spriteIndex = (spriteIndex + 1) % 10; // 10 es el número de sprites en cada fila
                repaint();
            } 
        });
        
        Timer idlea = new Timer(60,new ActionListener() {
            private int spriteIndex = 0;
           
            @Override
            public void actionPerformed(ActionEvent e) {
               player.changeSprite(spriteIndex, 0, spriteSheet); // 0 representa la primera fila
               spriteIndex = (spriteIndex + 1) % 10; // 10 es el número de sprites en cada fila
               if(spriteIndex == 3){
                spriteIndex = 0;
               }
               repaint();
            } 
        });
        Timer walki = new Timer(60, new ActionListener() {
            private int spriteIndex = 0;
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cambia al siguiente sprite en la primera fila cada vez que se activa el timer
                player.changeSprite(spriteIndex, 5, spriteSheet); // 0 representa la primera fila
                spriteIndex = (spriteIndex + 1) % 10; // 10 es el número de sprites en cada fila
        
                // Repinta el panel para reflejar el cambio de sprite
                repaint();
            }
        });
        Timer walkar = new Timer(60, new ActionListener() {
            private int spriteIndex = 0;
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cambia al siguiente sprite en la primera fila cada vez que se activa el timer
                player.changeSprite(spriteIndex, 6, spriteSheet); // 0 representa la primera fila
                spriteIndex = (spriteIndex + 1) % 10; // 10 es el número de sprites en cada fila
        
                // Repinta el panel para reflejar el cambio de sprite
                repaint();
            }
        });
        
        Timer idlear = new Timer(60, new ActionListener() {
            private int spriteIndex = 0;
        
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cambia al siguiente sprite en la primera fila cada vez que se activa el timer
                player.changeSprite(spriteIndex, 2, spriteSheet); // 0 representa la primera fila
                repaint();
            }
        });
        
        

        // Inicia el timer cuando se presiona la tecla 'D'
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    // Mueve el jugador a la derecha cuando se presiona la tecla 'D'
                    player.move(2.5, 0);
                    idlea.stop();
                    idlear.stop();
                    // Inicia el timer para cambiar los sprites y crear la animación de caminar
                    walkd.start();
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    // Mueve el jugador a la derecha cuando se presiona la tecla 'D'
                    player.move(-2.5, 0);
                    idlea.stop();
                    idlear.stop();
                    // Inicia el timer para cambiar los sprites y crear la animación de caminar
                    walki.start();
                }
                if(e.getKeyCode() == KeyEvent.VK_S){
                    player.move(0, 2.5);
                    idlea.stop();
                    idlear.stop();
                    walka.start();
                }
                if(e.getKeyCode() == KeyEvent.VK_W){
                    player.move(0, -2.5);
                    idlea.stop();
                    idlear.stop();
                    walkar.start();
                }
                
            }
        
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    // Detiene el timer cuando se suelta la tecla 'D'
                    walki.stop();
            
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    // Detiene el timer cuando se suelta la tecla 'D'
                    walkd.stop();
            
                }
                if (e.getKeyCode() == KeyEvent.VK_S){
                    walka.stop();
                    idlea.start();
                }
                
                if (e.getKeyCode() == KeyEvent.VK_W){
                    walkar.stop();
                    idlear.start();
                }
            }
        });

        // Hace que el panel pueda recibir eventos de teclado
        this.setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibuja el sprite del jugador
        player.draw(g);
    }
}
