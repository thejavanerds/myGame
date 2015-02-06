package com.thejavanerds.zhscraft.myGame.com.thejavanerds.zhscraft.world;

/**
 * Created by ZhsCraft on 2/6/2015.
 */
public class Block {

    public final static Block VOID = new BlockVoid();

    private int BlockID;
    private boolean isActive;

    public Block(int id){
        this.BlockID = id;
    }



    public int getBlockID(){
        return BlockID;
    }
    public void setBlockID(int id)
    {
        BlockID = id;
    }

    public boolean isActive()
    {
        return this.isActive;
    }

    public void setActive(boolean flag){
        this.isActive = flag;
    }
}
