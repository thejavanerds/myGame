package com.thejavanerds.zhscraft.myGame;

/**
 * Created by ZhsCraft on 2/6/2015.
 */
public abstract class Screen implements ScreenObject {
    @Override
    public abstract void Init();

    @Override
    public abstract void InitGL();

    @Override
    public abstract void Update();

    @Override
    public abstract void Render();
    @Override
    public abstract void Dispose();
}
