
package sistema_hospital;

public class Equipamento {
    
    private int disponivel;
    private String nome;
    private int quantidade;
    private Hospital equi;
    
    public Equipamento(){
    }
    
    public Equipamento(int disponivel, String nome,int quantidade ){
        this.disponivel = disponivel;
        this.quantidade = quantidade;
        this.nome = nome;
    }
    
    public void setEqui(Hospital equi){
        this.equi= equi;
    }
    public Hospital getEqui(){
        return equi;
    }
    public void setDisponivel(int disponivel){
        this.disponivel = disponivel;
    }
    public int getdisponivel(){
        return disponivel;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    public int getQuantidade(){
        return quantidade;
    }    
}
