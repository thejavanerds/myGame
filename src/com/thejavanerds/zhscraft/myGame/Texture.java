package com.thejavanerds.zhscraft.myGame;

import org.lwjgl.BufferUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * Created by ZhsCraft on 2/6/2015.
 */
public class Texture {

    public int id, width, height;

    private Texture(int id, int width, int height) {
        this.id = id;
        this.width = width;
        this.height = height;
    }

    public static Texture LoadTexture(String location) {
        BufferedImage image = null;
        try {
            //Texture.class.getClassLoader().getResourceAsStream(location));
            image = ImageIO.read(new File("C:/darkz/textures/"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] pixels = new int[image.getWidth() * image.getHeight()];
        image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getHeight());

        ByteBuffer buffer = BufferUtils.createByteBuffer(image.getWidth() * image.getHeight() * 4);

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int pixel = pixels[y * image.getWidth() + x];
                buffer.put((byte) ((pixel >> 16 & 0xFF)));
                buffer.put((byte) ((pixel >> 8 & 0xff)));
                buffer.put((byte) ((pixel & 0xFF)));
                buffer.put((byte) ((pixel >> 24 & 0xFF)));
            }
        }
        return null;
    }


}
