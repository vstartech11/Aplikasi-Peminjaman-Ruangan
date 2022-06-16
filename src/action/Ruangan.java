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

    public Ruangan(){

    }

    public String getIdRuangan(){
        return this.idRuangan;
    }
    public String getNamaRuangan(){
        return this.namaRuangan;
    }   
    public String getIdFasilitas(){
        return this.idFasilitas;
    }
    public String getKapasitasRuangan(){
        return this.kapasitasRuangan;
    }
    public String getStatusSesi1(){
        return this.statusSesi1;
    }
    public String getStatusSesi2(){
        return this.statusSesi2;
    }
    public String getStatusSesi3(){
        return this.statusSesi3;
    }
    public String getStatusSesi4(){
        return this.statusSesi4;
    }
}
