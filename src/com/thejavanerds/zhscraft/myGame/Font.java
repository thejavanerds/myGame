package com.thejavanerds.zhscraft.myGame;


public class Font {
    private Texture texture;

    public Font() {
    }

    public Texture loadFont(String name, String location) {
        texture = Texture.loadTexture(location);
        ResourceManager.addTexture(name, texture);
        return this.texture;
    }

    public void bind() {
        this.texture.bind();
    }
}