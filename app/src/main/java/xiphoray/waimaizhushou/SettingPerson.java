package xiphoray.waimaizhushou;

/**
 * Created by Jay on 2015/9/6 0006.
 */
public class SettingPerson {

    private String new_title;
    private String new_content;

    public SettingPerson(){}

    public SettingPerson(String new_title, String new_content) {
        this.new_title = new_title;
        this.new_content = new_content;
    }

    public String getNew_title() {
        return new_title;
    }

    public String getNew_content() {
        return new_content;
    }

    public void setNew_title(String new_title) {
        this.new_title = new_title;
    }

    public void setNew_content(String new_content) {
        this.new_content = new_content;
    }
}
