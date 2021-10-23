
package sistema_hospital;


public class Medicacao {
    private String nome;
    private int quantidademedi;
    private Hospital medi;
    
    public Medicacao(){
    }
    
    public Medicacao( String nome, int quantidademedi){
        this.nome = nome;
        this.quantidademedi = quantidademedi; 
    }

    public void setMedi(Hospital medi){
        this.medi = medi;
    }
    public Hospital getMedi(){
        return medi;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    public void setQuantidademedi(int quantidademedi){
        this.quantidademedi = quantidademedi;
    }
    public int getQuantidademedi(){
        return quantidademedi;
    }
    
}
