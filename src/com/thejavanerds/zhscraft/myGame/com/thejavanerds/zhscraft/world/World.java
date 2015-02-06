package com.thejavanerds.zhscraft.myGame.com.thejavanerds.zhscraft.world;

import com.nishu.utils.Camera;
import com.nishu.utils.Camera3D;
import com.thejavanerds.zhscraft.myGame.Loader;
import com.thejavanerds.zhscraft.myGame.Screen;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

/**
 * Created by ZhsCraft on 2/6/2015.
 */
public class World extends Screen {

    private Camera camera;


    public World(){
        InitGL();
        Init();
    }

    @Override
    public void Init() {
        this.camera = new Camera3D.CameraBuilder().setAspectRatio(Loader.WIDTH / Loader.HEIGHT).setRotation(0, 0, 0).setPosition(0, 0, 0).setAspectRatio(67).build();

    }

    @Override
    public void InitGL() {

    }

    @Override
    public void Update() {
        camera.updateKeys(32, 1);
        camera.updateMouse(1, 90, -90);
        if(Mouse.isButtonDown(0)){
            Mouse.setGrabbed(true);
        }

        if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
            Mouse.setGrabbed(false);
        }
    }

    @Override
    public void Render() {

    }

    @Override
    public void Dispose() {
        Display.destroy();
        System.exit(0);
    }
}
