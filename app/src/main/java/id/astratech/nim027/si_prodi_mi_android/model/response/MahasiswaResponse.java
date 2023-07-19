package id.astratech.nim027.si_prodi_mi_android.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class MahasiswaResponse {
    @SerializedName("nim")
    @Expose
    private String nim;

    @SerializedName("nama")
    @Expose
    private String nama;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("kelas")
    @Expose
    private String kelas;


    @Override
    public String toString() {
        return "MahasiswaResponse    {" +
                "nim='" + nim + '\'' +
                ", nama='" + nama + '\'' +
                ", email='" + email + '\'' +
                ", kelas='" + kelas + '\'' +
                '}';
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
}
