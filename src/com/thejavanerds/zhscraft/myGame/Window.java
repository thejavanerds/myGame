package com.thejavanerds.zhscraft.myGame;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

/**
 * Created by ZhsCraft on 2/6/2015.
 */
public class Window {
    public static void createWindow(int width, int height, boolean mouseCaptured){
        try{
            Display.setDisplayMode(new DisplayMode(width, height));
            Mouse.setGrabbed(mouseCaptured);
            Display.create();
        }catch(LWJGLException ex){
            ex.printStackTrace();
        }
    }

    public static void createWindow(int width, int height, String title, boolean mouseCaptured, boolean fullscreen){
        try{
            Display.setDisplayMode(new DisplayMode(width, height));
            Mouse.setGrabbed(mouseCaptured);
            Display.setFullscreen(fullscreen);
            Display.setTitle(title);
            Display.create();
        }catch(LWJGLException ex){
            ex.printStackTrace();
        }
    }

    public static void Update()
    {
        Display.update();
    }

    public static void Update(int targetFPS){
        Display.update();
        Display.sync(targetFPS);
    }

    public static boolean isWindowCloseRequested(){
        return Display.isCloseRequested();
    }

    public static void Dispose()
    {
        Display.destroy();
    }
}
