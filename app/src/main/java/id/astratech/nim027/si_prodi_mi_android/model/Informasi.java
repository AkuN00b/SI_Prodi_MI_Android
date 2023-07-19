package id.astratech.nim027.si_prodi_mi_android.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.util.UUID;

public class Informasi {
    @SerializedName("idInformasi")
    @Expose
    private UUID idInformasi;

    @SerializedName("judulInformasi")
    @Expose
    private String judulInformasi;

    @SerializedName("deskripsiInformasi")
    @Expose
    private String deskripsiInformasi;

    @SerializedName("createdbyInformasi")
    @Expose
    private String createdbyInformasi;

    @SerializedName("createddateInformasi")
    @Expose
    private String createddateInformasi;

    @SerializedName("modifiedbyInformasi")
    @Expose
    private String modifiedbyInformasi;

    @SerializedName("modifieddateInformasi")
    @Expose
    private String modifieddateInformasi;

    @SerializedName("statusInformasi")
    @Expose
    private String statusInformasi;

    public Informasi(UUID idInformasi, String judulInformasi, String deskripsiInformasi, String createdbyInformasi, String createddateInformasi, String modifiedbyInformasi, String modifieddateInformasi, String statusInformasi) {
        this.idInformasi = idInformasi;
        this.judulInformasi = judulInformasi;
        this.deskripsiInformasi = deskripsiInformasi;
        this.createdbyInformasi = createdbyInformasi;
        this.createddateInformasi = createddateInformasi;
        this.modifiedbyInformasi = modifiedbyInformasi;
        this.modifieddateInformasi = modifieddateInformasi;
        this.statusInformasi = statusInformasi;
    }

    public Informasi() {

    }

    public UUID getIdInformasi() {
        return idInformasi;
    }

    public void setIdInformasi(UUID idInformasi) {
        this.idInformasi = idInformasi;
    }

    public String getJudulInformasi() {
        return judulInformasi;
    }

    public void setJudulInformasi(String judulInformasi) {
        this.judulInformasi = judulInformasi;
    }

    public String getDeskripsiInformasi() {
        return deskripsiInformasi;
    }

    public void setDeskripsiInformasi(String deskripsiInformasi) {
        this.deskripsiInformasi = deskripsiInformasi;
    }

    public String getCreatedbyInformasi() {
        return createdbyInformasi;
    }

    public void setCreatedbyInformasi(String createdbyInformasi) {
        this.createdbyInformasi = createdbyInformasi;
    }

    public String getCreateddateInformasi() {
        return createddateInformasi;
    }

    public void setCreateddateInformasi(String createddateInformasi) {
        this.createddateInformasi = createddateInformasi;
    }

    public String getModifiedbyInformasi() {
        return modifiedbyInformasi;
    }

    public void setModifiedbyInformasi(String modifiedbyInformasi) {
        this.modifiedbyInformasi = modifiedbyInformasi;
    }

    public String getModifieddateInformasi() {
        return modifieddateInformasi;
    }

    public void setModifieddateInformasi(String modifieddateInformasi) {
        this.modifieddateInformasi = modifieddateInformasi;
    }

    public String getStatusInformasi() {
        return statusInformasi;
    }

    public void setStatusInformasi(String statusInformasi) {
        this.statusInformasi = statusInformasi;
    }
}
