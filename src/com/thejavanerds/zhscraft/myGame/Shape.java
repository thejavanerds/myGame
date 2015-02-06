package com.thejavanerds.zhscraft.myGame;

/**
 * Created by ZhsCraft on 2/6/2015.
 */
public class Shape {

    public static float[] createCubeVertices(float x, float y, float z, float size) {
        return new float[]{
                //button face
                x, y, z + size,
                x + size, y, z + size,
                x + size, y, z,
                x, y, z,

                //top face
                x, y + size, z,
                x + size, y + size, z,
                x + size, y + size, z + size,
                x, y + size, z + size,

                //font face
                x, y, z,
                x + size, y, z,
                x + size, y + size, z,
                x, y + size, z,

                //backface
                x, y + size, z + size,
                x + size, y + size, z + size,
                x + size, y, z + size,
                x, y + size, z,

                //left face
                x + size, y, z,
                x + size, y, z + size,
                x + size, y + size, z + size,
                x + size, y + size, z,

                //right face
                x, y, z + size,
                x, y, z,
                x, y + size, z,
                x, y + size, z + size,
        };
    }
}
