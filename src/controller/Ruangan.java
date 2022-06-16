package controller;

import java.util.ArrayList;

public class Ruangan {
    private String namaRuangan;
    private String kapasitasRuangan;
    private ArrayList<String> statusSesi;

    public Ruangan(String namaRuangan,String kapasitasRuangan, ArrayList<String> statusSesi){
        this.namaRuangan = namaRuangan;
        this.kapasitasRuangan = kapasitasRuangan;
        this.statusSesi = statusSesi;
    }

    public Ruangan(String namaRuangan,String kapasitasRuangan){
        this.namaRuangan = namaRuangan;
        this.kapasitasRuangan = kapasitasRuangan;
    }

    public Ruangan(){
        
    }

    public String getNamaRuangan(){
        return this.namaRuangan;
    }   
    public void setNamaRuangan(String namaRuangan) {
        this.namaRuangan = namaRuangan;
    }

    public String getKapasitasRuangan(){
        return this.kapasitasRuangan;
    }

    public void setKapasitasRuangan(String kapasitasRuangan){
        this.kapasitasRuangan = kapasitasRuangan;
    }

    public ArrayList<String> getStatusSesi(){
        return this.statusSesi;
    }
}
