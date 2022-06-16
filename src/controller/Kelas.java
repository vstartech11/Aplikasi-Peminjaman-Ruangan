package controller;

import java.util.ArrayList;

public class Kelas extends Ruangan{
  private String idRuangan;
  private String fasilitas;
  private String keteranganRuangan;

  public Kelas(String namaRuangan, String kapasitasRuangan, ArrayList<String> statusSesi, String idRuangan, String fasilitas) {
    super(namaRuangan, kapasitasRuangan, statusSesi);
    this.idRuangan = idRuangan;
    this.fasilitas = fasilitas;
  }

  public Kelas(String namaRuangan, String kapasitasRuangan, String idRuangan, String fasilitas) {
    super(namaRuangan, kapasitasRuangan);
    this.idRuangan = idRuangan;
    this.fasilitas = fasilitas;
  }

  public Kelas(){

  }

  public String getIdRuangan(){
    return this.idRuangan;
  }

  public String getKetRuangan(){
    return this.keteranganRuangan;
  }

  public String getFasilitas() {
    return this.fasilitas;
  }
}
