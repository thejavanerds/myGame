package com.thejavanerds.zhscraft.myGame;


public class Loader extends Screen  {


    public static int WIDTH = 1280;
    public static int HEIGHT = 720;

    private GameLoop gameLoop;

    public Loader()
    {
        gameLoop = new GameLoop();
        gameLoop.setScreen(this);
        gameLoop.setDebugMode(true);
        gameLoop.start(5000);
    }

    @Override
    public void Init() {

    }

    @Override
    public void InitGL() {

    }

    @Override
    public void Update() {

    }

    @Override
    public void Render() {

    }

    @Override
    public void Dispose() {

    }

    public static void main(String[] args) {
        Window.createWindow(WIDTH, HEIGHT, "MyGame", false, false);
        new Loader();
    }


}
