
package sistema_hospital;

import java.util.ArrayList;


public class Hospital {
    private String plantao;
    private String nome;
    private ArrayList<Medico> medico;
    private ArrayList<Medicacao> medicacao;
    private ArrayList<Equipamento> equipamento;
    
    public Hospital(){
        medico = new ArrayList();
        medicacao = new ArrayList();
        equipamento = new ArrayList();
    }
    public Hospital( String plantao, String nome){
        this.nome = nome;
        this.plantao = plantao;
        medico = new ArrayList();
        medicacao = new ArrayList();
        equipamento = new ArrayList();
        
    }
    public void setPlantrao(String plantao){
        this.plantao = plantao;
    }
    public String getPlantao(){
        return plantao;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    public void setMedico(ArrayList<Medico> medico){
        this.medico = medico;
    }
    public  ArrayList<Medico> getMedico(){
        return medico;
    }
    public void setMedicacao(ArrayList<Medicacao>medicacao){
        this.medicacao = medicacao;
    }
    public  ArrayList<Medicacao>getMedicacao(){
        return medicacao;
    }
    public void setEquipamento(ArrayList <Equipamento> equipamento){
        this.equipamento = equipamento;
    }
    public  ArrayList <Equipamento> getEquipamento(){
        return equipamento;
    }
    public void exibirEquipamentos(){
    }
    public void exibirMedicamentos(){
    }
    public void addMed(Medico m){
        m.setMed(this);
        medico.add(m);
    }
    public void addMedi(Medicacao me){
        me.setMedi(this);
        medicacao.add(me);
    }
    public void addEqui(Equipamento eq){
        eq.setEqui(this);
        equipamento.add(eq);
    }
 
}
    
