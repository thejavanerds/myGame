package com.thejavanerds.zhscraft.myGame.com.thejavanerds.zhscraft.world;

import com.nishu.utils.Color4f;

/**
 * Created by ZhsCraft on 2/6/2015.
 */
public class BlockVoid extends Block {

    public BlockVoid() {
    }

    public int getBlockID() {
        return 0;
    }

    @Override
    public Color4f getColor() {
        return Color4f.BLACK;
    }
}
