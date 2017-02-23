package util;

import org.litepal.crud.DataSupport;


/**
 * Created by WZES on 2017/2/12.
 */

public class Homework extends DataSupport{
    String date;

    boolean isFinish;
    String number;
    String content;

    public Homework(String date, boolean isFinish, String content, String number) {
        this.date = date;
        this.isFinish = isFinish;
        this.content = content;
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isFinish() {
        return isFinish;
    }

    public void setFinish(boolean finish) {
        isFinish = finish;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
