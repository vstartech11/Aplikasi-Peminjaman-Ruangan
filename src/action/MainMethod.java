package action;
import view.Register;
import view.formLogin;
import view.MainLayout;

public class MainMethod extends MainLayout {
    private String username;

    public MainMethod(String username){
        this.username = username;

        System.out.println(this.username);
        if(this.username.equals("admin")){
            setPengelolaanVisibility(true);
        } else {
            setPengelolaanVisibility(false);
        }
        // logoutMenu.addActionListener(new java.awt.event.ActionListener() {
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
            
        //     }
        //   });
    }
    
    public void mainSetUsername(String username){
        this.username = username;
    }

    public String mainGetUsername(){
        return this.username; 
    }

    public static void main(String[] args) {
    }
}
