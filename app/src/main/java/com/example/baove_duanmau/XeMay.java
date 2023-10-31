package com.example.baove_duanmau;

public class XeMay {
    private int id;
    private String tenxe;
    private int giaban;
    private int trangthai;

    public XeMay(int id, String tenxe, int giaban, int trangthai) {
        this.id = id;
        this.tenxe = tenxe;
        this.giaban = giaban;
        this.trangthai = trangthai;
    }

    public XeMay(String tenxe, int giaban, int trangthai) {
        this.tenxe = tenxe;
        this.giaban = giaban;
        this.trangthai = trangthai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenxe() {
        return tenxe;
    }

    public void setTenxe(String tenxe) {
        this.tenxe = tenxe;
    }

    public int getGiaban() {
        return giaban;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
}
