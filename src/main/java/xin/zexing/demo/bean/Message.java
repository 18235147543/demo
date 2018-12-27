package xin.zexing.demo.bean;

import java.io.Serializable;

/**
 * Created by czx on 2018/12/25.
 */
public class Message implements Serializable {
    private  String  name;
    private  String  year;

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Message{" +
                "name='" + name + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
