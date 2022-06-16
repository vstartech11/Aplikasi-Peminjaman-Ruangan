package action;

import view.LoginForm;

public class User extends LoginForm{
    private String nim;
    private String nama;
    private String email;
    private String noTelpon;
    private String password;
    private String status;
    // public User(String nim,String password){
    //     th
    // }
    public User(String nim,String nama,String email, String noTelpon,String password, String status){
        this.nim = nim;
        this.nama = nama;
        this.email = email;
        this.noTelpon = noTelpon;
        this.password = password;
        this.status = status;
    }
    public User(String nim,String password){
        this.nim = nim;
        this.password = password;
    }
    public String getNim(){
        return this.nim;
    }
    public String getNama(){
        return this.nama;
    }
    public String getEmail(){
        return this.email;
    }
    public String getNoTelpon(){
        return this.noTelpon;
    }
    public String getPassword(){
        return this.password;
    }
    public String getStatus(){
        return this.status;
    }

}
