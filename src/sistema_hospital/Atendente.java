
package sistema_hospital;

public class Atendente  {
    
    private String login = "123";
    private String nomeAtendente;

    public String getNomeAtendente() {
        return nomeAtendente= "livia";
    }
   
    public Atendente(){
    }
    
    public Atendente(String nome, int idade, String login){
        
        this.login = login;
        
    } 
    public void setLogin(String login){
        this.login = login;
    }
    public String getLogin(){
        return login;
    }
    public void inserirDados(){
        
    }
    public void alterarDados(){
        
    }
    
}
