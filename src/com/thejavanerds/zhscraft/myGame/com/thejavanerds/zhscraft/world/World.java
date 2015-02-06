package com.thejavanerds.zhscraft.myGame.com.thejavanerds.zhscraft.world;


import com.nishu.utils.Camera3D;
import com.nishu.utils.Color4f;
import com.thejavanerds.zhscraft.myGame.Font;
import com.thejavanerds.zhscraft.myGame.Loader;
import com.thejavanerds.zhscraft.myGame.Screen;
import com.thejavanerds.zhscraft.myGame.Text;
import javafx.scene.Camera;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

/**
 * Created by ZhsCraft on 2/6/2015.
 */
public class World extends Screen {

    private Camera3D camera;
    private Font font;
    public boolean debug = false;

    public World() {
        InitGL();
        Init();
    }

    @Override
    public void Init() {
        this.camera = new Camera3D.CameraBuilder().setAspectRatio(Loader.WIDTH / Loader.HEIGHT).setRotation(0, 0, 0).setPosition(0, 0, 0).setAspectRatio(67).build();
        font = new Font();
        font.loadFont("default", "font.png");
    }

    @Override
    public void InitGL() {

    }

    @Override
    public void Update() {
        input();
    }

    private void input() {
        camera.updateKeys(32, 1);
        camera.updateMouse(1, 90, -90);
        if (Mouse.isButtonDown(0)) {
            Mouse.setGrabbed(true);
        }

        while (Keyboard.next()) {
            if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
                Mouse.setGrabbed(false);
            }

            if (Keyboard.isKeyDown(Keyboard.KEY_F3)) {
                debug = !debug;
            }
        }
    }


    @Override
    public void Render() {
        if (debug)
            debugText();


    }

    public void debugText() {
        render2D();

        Text.renderString(font, "X:" + (int) camera.getX() + " Y:" + (int) camera.getY() + " Z:" + (int) camera.getZ(), 0f, 0.95f, 0.5f, new Color4f(1, 1, 1, 1));
        Text.renderString(font, "rotX:" + (int) camera.getYaw() + " rotY:" + (int) camera.getPitch() + " rotZ:" + (int) camera.getRoll(), 0f, 0.915f, 0.5f, new Color4f(1, 1, 1, 1));


        render3D();
    }

    public void render2D() {
        glClearDepth(1);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();

        glViewport(0, 0, Loader.WIDTH, Loader.HEIGHT);
        glOrtho(0, 1, 0, 1, -1, 1);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();

    }

    public void render3D() {
        glViewport(0, 0, Display.getWidth(), Display.getHeight());
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();

        gluPerspective(67.0f, Loader.WIDTH / Loader.HEIGHT, 0.001f, 1000f);
        glMatrixMode(GL_MODELVIEW);

        glEnable(GL_DEPTH_TEST);
    }

    @Override
    public void Dispose() {
        Display.destroy();
        System.exit(0);
    }
}
