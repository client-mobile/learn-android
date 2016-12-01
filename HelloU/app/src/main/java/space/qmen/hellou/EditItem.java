package space.qmen.hellou;

/**
 * Created by Luo_0412 on 2016/12/1.
 */

public class EditItem {
    private String user_no;
    private String user_name;

    public EditItem() {

    }

    public EditItem(String user_no, String user_name) {
        this.user_no = user_no;
        this.user_name = user_name;
    }

    public String getUserNo() {
        return user_no;
    }

    public String getUserName() {
        return user_name;
    }

    public void setbUserNo(String user_no) {
        this.user_no = user_no;
    }

    public void setUserName(String user_name) {
        this.user_name = user_name;
    }
}
