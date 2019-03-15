package app.tfkproject.objekwisatabatam.model;

/**
 * Created by taufik on 21/04/18.
 */

public class ItemObjekWisata {
    String id, nama, lokasi, deskripsi, gambar, latitude, longitude;

    public ItemObjekWisata(String id, String nama, String lokasi, String deskripsi, String gambar, String latitude, String longitude){
        this.id = id;
        this.gambar = gambar;
        this.lokasi = lokasi;
        this.deskripsi = deskripsi;
        this.nama = nama;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
