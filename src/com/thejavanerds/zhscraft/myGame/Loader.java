package com.thejavanerds.zhscraft.myGame;

import java.awt.*;

public class Loader extends Screen {


    public static int WIDTH = 1280;
    public static int HEIGHT = 720;


    public static void main(String[] args) {
        Window.createWindow(WIDTH, HEIGHT, "MyGame", true, false);
        new Loader();
    }


}
