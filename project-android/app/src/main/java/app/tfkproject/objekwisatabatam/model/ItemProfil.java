package app.tfkproject.objekwisatabatam.model;

/**
 * Created by taufik on 17/05/18.
 */

public class ItemProfil {
    String id, nama, konten;

    public ItemProfil(String id, String nama, String konten){
        this.id = id;
        this.nama = nama;
        this.konten = konten;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getKonten() {
        return konten;
    }
}
