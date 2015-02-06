package com.thejavanerds.zhscraft.myGame.com.thejavanerds.zhscraft.world;

import com.nishu.utils.Vector3f;

import static org.lwjgl.opengl.GL15.*;

/**
 * Created by ZhsCraft on 2/6/2015.
 */
public class Chunk {

    private Vector3f pos;

    private int[][][] blocks;
    private int vID, cID;
    private boolean isActive;

    public Chunk(float x, float y, float z) {
        this(new Vector3f(x, y, z));
    }

    public Chunk(Vector3f pos) {
        this.pos = pos;
    }


    public void Update()
    {

    }

    public void Render(){

    }

    public void rebuild()
    {

    }

    public void Dispose()
    {

    }

    private void checkBlockInView(){

    }

    public boolean isActive()
    {
        return this.isActive;
    }

    public void setActive(boolean flag){
        this.isActive = flag;
    }
}
