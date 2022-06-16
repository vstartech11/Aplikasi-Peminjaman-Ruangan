package controller;

public class Lab extends Ruangan {
  private String idRuangan;
  private String keteranganRuangan;

  public Lab(String namaRuangan,String kapasitasRuangan,String statusSesi1,String statusSesi2,String statusSesi3,String statusSesi4,String idRuangan,String keteranganRuangan) {
    super(namaRuangan, kapasitasRuangan, statusSesi1, statusSesi2, statusSesi3, statusSesi4);
    this.idRuangan = idRuangan;
    this.keteranganRuangan = keteranganRuangan;
  }

  public String getIdRuangan(){
    return this.idRuangan;
  }

  public String getKetRuangan(){
    return this.keteranganRuangan;
  }
}
