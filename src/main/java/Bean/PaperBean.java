package Bean;

public class PaperBean {
   public  int objectid;
   public  String title;
   public  String content;
   public  String code;

    int singlechoice,fillblank,tof;

    public int getObjectid() {
        return objectid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setObjectid(int objectid) {
        this.objectid = objectid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSinglechoice() {
        return singlechoice;
    }

    public void setSinglechoice(int singlechoice) {
        this.singlechoice = singlechoice;
    }

    public int getFillblank() {
        return fillblank;
    }

    public void setFillblank(int fillblank) {
        this.fillblank = fillblank;
    }

    public int getTof() {
        return tof;
    }

    public void setTof(int tof) {
        this.tof = tof;
    }

}
