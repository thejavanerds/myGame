package com.thejavanerds.zhscraft.myGame;



import com.nishu.utils.ShaderProgram;

import java.util.HashMap;

public class ResourceManager {
    private static HashMap<String, Texture> textures = new HashMap();
    private static HashMap<String, ShaderProgram> shaders = new HashMap();
    private static HashMap<String, Font> fonts = new HashMap();
    private static HashMap<String, HashMap<?, ?>> userLists = new HashMap();

    public ResourceManager() {
    }

    public static void addFont(String name, Font font) {
        if(textures.get(name) != null) {
            throw new IllegalStateException("Cannot add the same font twice. Delete the font first and then re-upload it!");
        } else {
            fonts.put(name, font);
        }
    }

    public static Font loadFont(String name) {
        if(fonts.get(name) == null) {
            throw new IllegalStateException("Could not find the font program with key: " + name);
        } else {
            return (Font)fonts.get(name);
        }
    }

    public static void addTexture(String name, Texture texture) {
        if(textures.get(name) != null) {
            throw new IllegalStateException("Cannot add the same texture twice. Delete the texture first and then re-upload it!");
        } else {
            textures.put(name, texture);
        }
    }

    public static Texture loadTexture(String name) {
        if(textures.get(name) == null) {
            throw new IllegalStateException("Could not find the texture with key: " + name);
        } else {
            return (Texture)textures.get(name);
        }
    }

    public static void addShaderProgram(String name, ShaderProgram program) {
        if(textures.get(name) != null) {
            throw new IllegalStateException("Cannot add the same shader program twice. Delete the program first and then re-upload it!");
        } else {
            shaders.put(name, program);
        }
    }

    public static ShaderProgram loadShaderProgram(String name) {
        if(shaders.get(name) == null) {
            throw new IllegalStateException("Could not find the shader program with key: " + name);
        } else {
            return (ShaderProgram)shaders.get(name);
        }
    }

    public static void addList(String name, HashMap<?, ?> map) {
        if(userLists.get(name) != null) {
            throw new IllegalStateException("Cannot add the same user list twice. Delete the user list first and then re-upload it!");
        } else {
            userLists.put(name, map);
        }
    }

    public static HashMap<?, ?> getList(String name) {
        if(userLists.get(name) == null) {
            throw new IllegalStateException("Could not find the user list with key: " + name);
        } else {
            return (HashMap)userLists.get(name);
        }
    }

    public static <T> Object getObjectFromList(String name, String objectName) {
        if(userLists.get(name) == null) {
            throw new IllegalStateException("Could not find the user list with key: " + name);
        } else if(((HashMap)userLists.get(name)).get(objectName) == null) {
            throw new IllegalStateException("Could not find the object in the user list with key: " + objectName);
        } else {
            return ((HashMap)userLists.get(name)).get(objectName);
        }
    }
}
