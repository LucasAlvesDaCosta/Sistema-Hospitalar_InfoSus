
package sistema_hospital;

public abstract class Pessoa {
    private String nomeAtendente;

    public String getNomeAtendente() {
        return nomeAtendente;
    }

    public void setNomeAtendente(String nomeAtendente) {
        this.nomeAtendente = nomeAtendente;
    }
    private String nome;
    private int idade;
    
    public Pessoa(){
    }
    
    public Pessoa(String nome, int idade){
        this.idade = idade;
        this.nome = nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setIdade( int idade){
        this.idade = idade;
    }
    public String getNome(){
        return nome;
    }
    public int getIdade(){
        return idade;
    }
    
    
    
}
