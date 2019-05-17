package com.example.fishx.todolist;

public class detail {

    String planadi;
    String icerik;
    Boolean durum;

    public String getIcerik() {
        return icerik;
    }

    public String getPlanadi() {
        return planadi;
    }

    public Boolean getDurum() {
        return durum;
    }

    public void setDurum(Boolean durum) {
        this.durum = durum;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public void setPlanadi(String planadi) {
        this.planadi = planadi;
    }
}
