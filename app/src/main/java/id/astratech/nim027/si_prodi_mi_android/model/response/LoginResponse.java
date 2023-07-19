package id.astratech.nim027.si_prodi_mi_android.model.response;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import id.astratech.nim027.si_prodi_mi_android.model.Mahasiswa;

public class LoginResponse {

    @SerializedName("data")
    @Expose
    private Mahasiswa mMahasiswa;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("status")
    @Expose
    private int status;

    @SerializedName("password")
    @Expose
    private String password;

    public Mahasiswa getMahasiswa() {
        return mMahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        mMahasiswa = mahasiswa;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "mMahasiswa=" + mMahasiswa +
                ", message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
