package com.thejavanerds.zhscraft.myGame;

/**
 * Created by ZhsCraft on 2/6/2015.
 */
public interface ScreenObject {
    public void Init();
    public void InitGL();
    public void Update();
    public void Render();
    public void Dispose();
}
