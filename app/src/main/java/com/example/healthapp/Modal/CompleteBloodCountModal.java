package com.example.healthapp.Modal;

import android.widget.EditText;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CompleteBloodCountModal {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("userId")
    @Expose
    private Long userId;

    @SerializedName("haemoglobin")
    @Expose
    private Double haemoglobin;

    @SerializedName("haematocrit")
    @Expose
    private Double haematocrit;

    @SerializedName("RBC")
    @Expose
    private Double RBC;

    @SerializedName("MCV")
    @Expose
    private Double MCV;

    @SerializedName("MCH")
    @Expose
    private Double MCH;

    @SerializedName("MCHC")
    @Expose
    private Double MCHC;

    @SerializedName("WBC")
    @Expose
    private Double WBC;

    @SerializedName("Neutrophils")
    @Expose
    private Double Neutrophils;

    @SerializedName("Lymghocytes")
    @Expose
    private Double Lymghocytes;

    @SerializedName("eosinophils")
    @Expose
    private Double eosinophils;

    @SerializedName("Monocytes")
    @Expose
    private Double Monocytes;

    @SerializedName("Basophil")
    @Expose
    private Double Basophil;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getHaemoglobin() {
        return haemoglobin;
    }

    public void setHaemoglobin(Double haemoglobin) {
        this.haemoglobin = haemoglobin;
    }

    public Double getHaematocrit() {
        return haematocrit;
    }

    public void setHaematocrit(Double haematocrit) {
        this.haematocrit = haematocrit;
    }

    public Double getRBC() {
        return RBC;
    }

    public void setRBC(Double RBC) {
        this.RBC = RBC;
    }

    public Double getMCV() {
        return MCV;
    }

    public void setMCV(Double MCV) {
        this.MCV = MCV;
    }

    public Double getMCH() {
        return MCH;
    }

    public void setMCH(Double MCH) {
        this.MCH = MCH;
    }

    public Double getMCHC() {
        return MCHC;
    }

    public void setMCHC(Double MCHC) {
        this.MCHC = MCHC;
    }

    public Double getWBC() {
        return WBC;
    }

    public void setWBC(Double WBC) {
        this.WBC = WBC;
    }

    public Double getNeutrophils() {
        return Neutrophils;
    }

    public void setNeutrophils(Double neutrophils) {
        Neutrophils = neutrophils;
    }

    public Double getLymghocytes() {
        return Lymghocytes;
    }

    public void setLymghocytes(Double lymghocytes) {
        Lymghocytes = lymghocytes;
    }

    public Double getEosinophils() {
        return eosinophils;
    }

    public void setEosinophils(Double eosinophils) {
        this.eosinophils = eosinophils;
    }

    public Double getMonocytes() {
        return Monocytes;
    }

    public void setMonocytes(Double monocytes) {
        Monocytes = monocytes;
    }

    public Double getBasophil() {
        return Basophil;
    }

    public void setBasophil(Double basophil) {
        Basophil = basophil;
    }

    @Override
    public String toString() {
        return "CompleteBloodCountModal{" +
                "id=" + id +
                ", haemoglobin=" + haemoglobin +
                ", haematocrit=" + haematocrit +
                ", RBC=" + RBC +
                ", MVC=" + MCV +
                ", MCH=" + MCH +
                ", MCHC=" + MCHC +
                ", WBC=" + WBC +
                ", Neutrophils=" + Neutrophils +
                ", Lymghocytes=" + Lymghocytes +
                ", eosinophils=" + eosinophils +
                ", Monocytes=" + Monocytes +
                ", Basophil=" + Basophil +
                '}';
    }
}
