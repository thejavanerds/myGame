package com.thejavanerds.zhscraft.myGame.com.thejavanerds.zhscraft.world;

import com.nishu.utils.Color4f;

/**
 * Created by ZhsCraft on 2/6/2015.
 */
public abstract class Block {

    public final static Block VOID = new BlockVoid();
    public final static Block GRASS = new BlockGrass();
    private boolean isActive;
    private Color4f color;

    public abstract int getBlockID();

    public static Block getBlockID(int id){
        switch (id){
            case 0:
                return Block.VOID;
            case 1:
                return Block.GRASS;
            default:
                return Block.VOID;
        }
    }

    public boolean isActive()
    {
        return this.isActive;
    }

    public void setActive(boolean flag){
        this.isActive = flag;
    }
}
