package util;

/**
 * Created by WZES on 2017/1/28.
 */

public class Software {
    private String name;
    private int imageId;
    public Software(String name, int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
