
package sistema_hospital;



public class Medico extends Pessoa{
    
    private String crm;
    private String especialidade;
    private Hospital med;
    private String data;

    public void setData(String data) {
        this.data = data;
    }

    
    public Medico(){
    }
     public Medico(String nome,int idade,  String data, String crm, String especialidade){
        super(nome, idade);
        this.crm = crm;
        this.especialidade = especialidade;
        this.data = data;
    }
    public void setCrm( String crm){
        this.crm = crm;
    }
    public String getCrm(){
        return crm;
    }
     public void setEspecialidade( String especialidade){
        this.especialidade = especialidade;
    }
    public String getEspecialidade(){
        return especialidade;
    }
    public void setMed(Hospital med){
        this.med = med;
    }
    public Hospital getMed(){
        return med;
    }

    public String getData() {
        return data;
    }
}
    

