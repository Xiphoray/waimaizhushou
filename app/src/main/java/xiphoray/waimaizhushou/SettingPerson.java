package xiphoray.waimaizhushou;

public class SettingPerson {

    private String new_title;
    private String new_content;



    public SettingPerson(String new_title, String new_content) {
        this.new_title = new_title;
        this.new_content = new_content;
    }

    String getNew_title() {
        return new_title;
    }

    String getNew_content() {
        return new_content;
    }

//    public SettingPerson(){}
//
//    public void setNew_title(String new_title) {
//        this.new_title = new_title;
//    }
//
//    public void setNew_content(String new_content) {
//        this.new_content = new_content;
//    }
}
