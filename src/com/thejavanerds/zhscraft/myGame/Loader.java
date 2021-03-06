package com.thejavanerds.zhscraft.myGame;

import com.thejavanerds.zhscraft.myGame.com.thejavanerds.zhscraft.world.World;
import org.lwjgl.opengl.Display;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

public class Loader extends Screen {


    public static int WIDTH = 1280;
    public static int HEIGHT = 720;

    private GameLoop gameLoop;

    public World world;

    public Loader() {
        gameLoop = new GameLoop();
        gameLoop.setScreen(this);
        gameLoop.setDebugMode(true);
        gameLoop.start(60);
    }

    @Override
    public void Init() {
        initCamera();
        world = new World();

    }

    @Override
    public void InitGL() {
        glViewport(0, 0, Display.getWidth(), Display.getHeight());
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();

        gluPerspective(67.0f, WIDTH / HEIGHT, 0.001f, 1000f);
        glMatrixMode(GL_MODELVIEW);

        glEnable(GL_DEPTH_TEST);
    }

    @Override
    public void Update() {
        world.Update();
    }

    @Override
    public void Render() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        glClearColor(0.2f, 0.2f, 0.85f, 0.2f);

        world.Render();
    }

    @Override
    public void Dispose() {
        world.Dispose();
    }


    private void initCamera() {

    }


    public static void main(String[] args) {
        Window.createWindow(WIDTH, HEIGHT, "MyGame", false, false);
        new Loader();
    }


}
