package cn.luojs.uiwidgetsapp.model;

/**
 * Created by Luo_0412 on 2016/11/11.
 * widget类 name + img
 */

public class Widget {

    // 属性
    private String name;
    private int imageId;

    /**
     * 有参构造函数
     * @param name
     * @param imageId
     */
    public Widget(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    /**
     * getter
     * @return
     */
    public String getName() {
        return name;
    }
    public int getImageId() {
        return imageId;
    }


}
