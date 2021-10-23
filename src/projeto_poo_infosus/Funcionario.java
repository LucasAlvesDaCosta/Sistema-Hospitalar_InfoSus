
package sistema_hospital;

public class Funcionario extends Pessoa{
    
    private int matricula;
    
    public Funcionario(){
    }
    public Funcionario(String Nome, int idade, int matricula){
        super( Nome, idade);

    }
    
    public void setMatricula(int matricula){
        this.matricula = matricula;
    }
    public int getMatricula(){
        return matricula;
    }
}
