package action;

public class Ruangan {
    private String idRuangan;
    private String namaRuangan;
    private String idFasilitas;
    private String kapasitasRuangan;
    private String statusSesi1;
    private String statusSesi2;
    private String statusSesi3;
    private String statusSesi4;

    public Ruangan(String idRuangan,String namaRuangan, String idFasilitas,String kapasitasRuangan,String statusSesi1,String statusSesi2,String statusSesi3,String statusSesi4){
        this.idFasilitas = idRuangan;
        this.namaRuangan =namaRuangan;
        this.idFasilitas = idFasilitas;
        this.kapasitasRuangan = kapasitasRuangan;
        this.statusSesi1 = statusSesi1;
        this.statusSesi2 = statusSesi2;
        this.statusSesi3 = statusSesi3;
        this.statusSesi4 = statusSesi4;
    }
    protected String getIdRuangan(){
        return this.idRuangan;
    }
    protected String getNamaRuangan(){
        return this.namaRuangan;
    }   
    protected String getIdFasilitas(){
        return this.idFasilitas;
    }
    protected String getKapasitasRuangan(){
        return this.kapasitasRuangan;
    }
    protected String getStatusSesi1(){
        return this.statusSesi1;
    }
    protected String getStatusSesi2(){
        return this.statusSesi2;
    }
    protected String getStatusSesi3(){
        return this.statusSesi3;
    }
    protected String getStatusSesi4(){
        return this.statusSesi4;
    }
}
