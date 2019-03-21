package Game.World;

import Game.Entities.DynamicEntities.BaseDynamicEntity;
import Game.Entities.DynamicEntities.Mario;
import Game.Entities.DynamicEntities.Mushroom;
import Game.Entities.StaticEntities.*;
import Main.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MapBuilder {

    public static int pixelMultiplier = 48;

    public static int boundBlock = new Color(0,0,0).getRGB();
    public static int mario = new Color(255,0,0).getRGB();
    public static int surfaceBlock = new Color(255,106,0).getRGB();
    public static int breakBlock = new Color(0,38,255).getRGB();
    public static int misteryBlock = new Color(255,216,0).getRGB();
    public static int mushroom = new Color(178,0,255).getRGB();

    public static Map createMap(BufferedImage mapImage, Handler handler){
        Map mapInCreation = new Map(handler);

        for (int i = 0; i < mapImage.getWidth(); i++) {
            for (int j = 0; j < mapImage.getHeight(); j++) {
                int currentPixel = mapImage.getRGB(i, j);
                int xPos = i*pixelMultiplier;
                int yPos = j*pixelMultiplier;
                if(currentPixel == boundBlock){
                    BaseStaticEntity BoundBlock = new BoundBlock(xPos,yPos,pixelMultiplier,pixelMultiplier,handler);
                    mapInCreation.addBlock(BoundBlock);
                }else if(currentPixel == mario){
                    BaseDynamicEntity Mario = new Mario(xPos,yPos,pixelMultiplier,pixelMultiplier,handler);
                    mapInCreation.addEnemy(Mario);
                }else if(currentPixel == surfaceBlock){
                    BaseStaticEntity SurfaceBlock = new SurfaceBlock(xPos,yPos,pixelMultiplier,pixelMultiplier,handler);
                    mapInCreation.addBlock(SurfaceBlock);
                }else if(currentPixel == breakBlock){
                    BaseStaticEntity BreakBlock = new BreakBlock(xPos,yPos,pixelMultiplier,pixelMultiplier,handler);
                    mapInCreation.addBlock(BreakBlock);
                }else if(currentPixel == misteryBlock){
                    BaseStaticEntity MisteryBlock = new MisteryBlock(xPos,yPos,pixelMultiplier,pixelMultiplier,handler);
                    mapInCreation.addBlock(MisteryBlock);
                }else if(currentPixel == mushroom){
                    BaseDynamicEntity Mushroom = new Mushroom(xPos,yPos,pixelMultiplier,pixelMultiplier,handler);
                    mapInCreation.addEnemy(Mushroom);
                }
            }

        }

        return mapInCreation;
    }

}
