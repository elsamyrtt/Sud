package com.sud;
import java.awt.Image;
import java.awt.Graphics;


public class Player {
    // Variables para la posición del jugador
    private int x, y;
    private int width, height;
    // Variable para el sprite actual del jugador
    private Image currentSprite;

    // Constructor
    public Player(int x, int y, SpriteSheet spriteSheet,int width,int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.currentSprite = spriteSheet.getSprite(0, 0, width, height); // Inicializa con el primer sprite
    }

    // Método para mover al jugador
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    // Método para cambiar el sprite del jugador
    public void changeSprite(int spriteIndex, int row, SpriteSheet spriteSheet) {
        currentSprite = spriteSheet.getSprite(spriteIndex, row,width,height);
    }
    

    // Método para dibujar al jugador
    public void draw(Graphics g) {
        g.drawImage(currentSprite, x, y, null);
    }
}
