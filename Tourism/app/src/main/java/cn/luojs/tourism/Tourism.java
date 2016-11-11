package cn.luojs.tourism;

/**
 * Created by Luo_0412 on 2016/11/3.
 */

public class Tourism {
    private String name;
    private String content;
    private int imageId;

    // 构造函数
    public Tourism(String name, String content, int imageId) {
        this.name = name;
        this.content = content;
        this.imageId = imageId;
    }

    // setter methods
    public void setName(String name) { this.name = name; }
    public void setContent(String content) { this.content = content;}
    public void setImageId(int imageId) { this.imageId = imageId;}

    // getter methods
    public String getName() { return name; }
    public String getContent() { return content;}
    public int getImageId() { return imageId; }

}
