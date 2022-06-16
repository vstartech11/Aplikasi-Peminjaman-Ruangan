package controller;

public class Kelas extends Ruangan{
  private String idRuangan;
  private String keteranganRuangan;
  private int banyakFasilitas;

  public Kelas(String namaRuangan,String kapasitasRuangan,String statusSesi1,String statusSesi2,String statusSesi3,String statusSesi4,String idRuangan,String keteranganRuangan, int banyakFasilitas) {
    super(namaRuangan, kapasitasRuangan, statusSesi1, statusSesi2, statusSesi3, statusSesi4);
    this.idRuangan = idRuangan;
    this.keteranganRuangan = keteranganRuangan;
    this.banyakFasilitas = banyakFasilitas;
  }

  public String getIdRuangan(){
    return this.idRuangan;
  }

  public String getKetRuangan(){
    return this.keteranganRuangan;
  }

  public int getBanyakFasilitas(){
    return this.banyakFasilitas;
  }
}
