package app.tfkproject.objekwisatabatam.model;

/**
 * Created by taufik on 17/05/18.
 */

public class ItemEvent {
    String id, no, tanggal, event;

    public ItemEvent(String id, String no, String tanggal, String event){
        this.id = id;
        this.no = no;
        this.tanggal = tanggal;
        this.event = event;
    }

    public String getId() {
        return id;
    }

    public String getNo() {
        return no;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getEvent() {
        return event;
    }
}
