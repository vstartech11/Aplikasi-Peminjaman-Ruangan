package action;

public class User {
    private String nim;
    private String nama;
    private String email;
    private String noTelpon ;
    private String password;
    private String status;
    public User(String nim,String nama,String email, String noTelpon,String passwird,String status){
        this.nim = nim;
        this.nama = nama;
        this.email = email;
        this.noTelpon = noTelpon;
        this.status = status;
    }
    protected String getNIM(){
        return this.nim;
    }
    protected String getNama(){
        return this.nama;
    }
    protected String getEmail(){
        return this.email;
    }
    protected String getNoTelpon(){
        return this.noTelpon;
    }
    protected String getpassword(){
        return this.password;
    }
    protected String getStatus(){
        return this.status;
    }
}
