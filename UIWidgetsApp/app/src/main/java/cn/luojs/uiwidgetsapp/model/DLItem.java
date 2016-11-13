package cn.luojs.uiwidgetsapp.model;

/**
 * Created by Jay on 2015/10/8 0008.
 */
public class DLItem {

    private int iconId;
    private String iconName;

    public DLItem() {
    }

    public DLItem(int iconId, String iconName) {
        this.iconId = iconId;
        this.iconName = iconName;
    }

    public int getIconId() {
        return iconId;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }
}