package com.thejavanerds.zhscraft.myGame;


import com.nishu.utils.Time;

/**
 * Created by ZhsCraft on 2/6/2015.
 */
public class GameLoop {

    private Screen currentScreen;

    private double frameCap = 60.0;
    private boolean running = false;
    private boolean debug = false;

    public void setScreen(Screen screen) {
        if (currentScreen != null) currentScreen.Dispose();
        currentScreen = screen;
        currentScreen.InitGL();
        currentScreen.Init();

    }

    public void start(int frameCap) {
        if (running) return;
        running = true;
        this.frameCap = frameCap;
        run();
    }

    public void run() {
        int frames = 0;
        int frameCounter = 0;


        final double frameTime = 1.0 / frameCap;

        long lastTime = Time.getTime();
        double unprocessed = 0;

        while (running) {
            boolean render = false;
            long startTime = Time.getTime();
            long passTime = startTime - lastTime;
            lastTime = startTime;

            unprocessed += passTime / (double) Time.SECOND;
            frameCounter += passTime;

            while (unprocessed > frameTime) {
                render = true;
                unprocessed -= frameTime;

                if (Window.isWindowCloseRequested()) stop();

                Time.setDelta(frameTime);
                update();

                if (frameCounter >= Time.SECOND) {
                    if (debug) System.out.println("FPS: " + frames);
                    frames = 0;
                    frameCounter = 0;
                }
            }

            if (render) {
                render();
                frames++;
            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        stop();
    }

    private void stop() {
        if (!running) return;
        running = false;
        currentScreen.Dispose();
    }


    private void update() {
        currentScreen.Update();
    }

    private void render() {
        currentScreen.Render();
    }

    public double getFrameCap() {
        return frameCap;
    }

    public void setFrameCap(double frameCap) {
        this.frameCap = frameCap;
    }

    public boolean isDebugMode() {
        return debug;
    }

    public void setDebugMode(boolean flag) {
        debug = flag;
    }
}
