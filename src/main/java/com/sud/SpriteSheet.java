package com.sud;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Image;
import java.awt.Graphics;


public class SpriteSheet {
    private BufferedImage spriteSheet;
    private int spriteWidth;
    private int spriteHeight;

    public SpriteSheet(String path, int spriteWidth, int spriteHeight) {
        this.spriteWidth = spriteWidth;
        this.spriteHeight = spriteHeight;

        try {
            spriteSheet = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getSprite(int x, int y, int width, int height) {
        // Obtiene el sprite en la posición (x, y) del spritesheet
        BufferedImage sprite = spriteSheet.getSubimage(x * spriteWidth, y * spriteHeight, spriteWidth, spriteHeight);
    
        // Escala el sprite a un tamaño más pequeño
        Image scaledSprite = sprite.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    
        // Convierte la imagen escalada de nuevo a BufferedImage
        BufferedImage bufferedScaledSprite = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics g = bufferedScaledSprite.getGraphics();
        g.drawImage(scaledSprite, 0, 0, null);
        g.dispose();
    
        return bufferedScaledSprite;
    }    
}
