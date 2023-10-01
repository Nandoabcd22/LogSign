package com.example.logsign.models;

public class Mahasiswa {

    // apa fungsi models?
    // 1. mempresentasikan data artinya models diigunakan untuk mempresentasikan data yang akan ditampilkan
    //      atau digunakan dalam aplikasi anda

    // 2. Models sering digunakan dalam kombinasi dengan tampilan view untuk menampilkan data kepada pengguna
    private String nama;
    private String npm;
    private String nohp;

    public Mahasiswa(String nama, String npm, String nohp){
        this.nama = nama;
        this.npm = npm;
        this.nohp = nohp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

}
