package util;

import cn.bmob.v3.BmobObject;

/**
 * Created by WZES on 2017/2/12.
 */

public class MessageNet extends BmobObject{
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SEND = 1;
    private String user;
    private String content;
    private int type;
    public MessageNet() {
    }
    public MessageNet(String user, String content, int type) {
        this.user = user;
        this.type = type;
        this.content = content;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
