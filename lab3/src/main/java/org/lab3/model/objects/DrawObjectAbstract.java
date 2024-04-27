package org.lab3.model.objects;

public abstract class DrawObjectAbstract implements DrawObject {
    protected double screenPosX;
    protected double screenPosY;
    protected double screenSize = 100;
    protected int screenHorizontalDirection = 1;
    protected int screenLayerLevel = 0;
    protected int screenWidth;
    protected int screenHeight;
    protected int resourcesIndexInResourcesList;
    protected int currentImageIndex;
//    protected ResourcesContext resourcesContext;
//    protected BufferedImage image;

    public DrawObjectAbstract(String atlas) {
//        resourcesContext = new ResourcesContext();
//        resourcesContext.addImage(atlas);
    }

    @Override
    public double getScreenPosX() {
        return screenPosX;
    }

    @Override
    public void setScreenPosX(double screenPosX) {
        this.screenPosX = screenPosX;
    }

    @Override
    public double getScreenPosY() {
        return screenPosY;
    }

    @Override
    public void setScreenPosY(double screenPosY) {
        this.screenPosY = screenPosY;
    }

    @Override
    public int getScreenHorizontalDirection() {
        return screenHorizontalDirection;
    }

    @Override
    public void setScreenHorizontalDirection(int screenHorizontalDirection) {
        this.screenHorizontalDirection = screenHorizontalDirection;
    }

    @Override
    public int getScreenLayerLevel() {
        return screenLayerLevel;
    }

    @Override
    public void setScreenLayerLevel(int screenLayerLevel) {
        this.screenLayerLevel = screenLayerLevel;
    }

    @Override
    public double getScreenSize() {
        return screenSize;
    }

    @Override
    public int getScreenWidth() {
        return screenWidth;
    }

    @Override
    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    @Override
    public int getScreenHeight() {
        return screenHeight;
    }

    @Override
    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    @Override
    public int getResourcesIndexInResourcesList() {
        return resourcesIndexInResourcesList;
    }

    @Override
    public void setResourcesIndexInResourcesList(int resourcesIndexInResourcesList) {
        this.resourcesIndexInResourcesList = resourcesIndexInResourcesList;
    }

    @Override
    public int getCurrentImageIndex() {
        return currentImageIndex;
    }

    @Override
    public void setCurrentImageIndex(int currentImageIndex) {
        this.currentImageIndex = currentImageIndex;
    }

    /*@Override
    public BufferedImage getImage() {
        return image;
    }*/
}
