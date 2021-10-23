package sistema_hospital;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JPrincipal extends javax.swing.JFrame {

    ArrayList<Medico> Listmedico;
    ArrayList<Medicacao> ListMedicamento;
    ArrayList<Equipamento> ListEquipamento;
    String modoMedico;
    String modoMedicamento;
    String modoEquipamento;
    String novo = "";
    String novo1 = "";
    String novo2 = "";
    String aux = "";
    String especialidadeMe;
     int dia, mes, ano;
       
    //mapear  lista de medicos para a tabela de medicos
    public void LoadTableMedico() {
        //modelador da tabela recebendo um vetor de colunas
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Crm", "Especialidade", "Data", "Nome", "idade"}, 0);

        //percorrer lista de medicos para cada item adicionar no modelo
        for (int i = 0; i < Listmedico.size(); i++) {
            Object linha[] = new Object[]{Listmedico.get(i).getCrm(),
                Listmedico.get(i).getEspecialidade(),
                Listmedico.get(i).getData(),
                Listmedico.get(i).getNome(),
                Listmedico.get(i).getIdade()+""};
           
            

            modelo.addRow(linha);
            

        }
        ArrayList array = new ArrayList();
        
        novo += "NOME: "+campoNomeMedico.getText().trim() +"  CRM:  "+campoCrmMedico.getText().trim()+"  IDADE:   "+
        campoIdadeMedico.getText().trim()+"  DATA PLANTAO:  "+aux+"\n";
        
        array.add(novo);
        tabelaMedicos.setModel(modelo);//manupulando a tabela para receber a estrurura da tabela

        //setando as larguras para atualiza-las
        tabelaMedicos.getColumnModel().getColumn(0).setPreferredWidth(200);
        tabelaMedicos.getColumnModel().getColumn(1).setPreferredWidth(150);
        tabelaMedicos.getColumnModel().getColumn(2).setPreferredWidth(200);
        tabelaMedicos.getColumnModel().getColumn(3).setPreferredWidth(200);
        tabelaMedicos.getColumnModel().getColumn(4).setPreferredWidth(150);

    }

    public void LoadTableMedicamento() {
        //modelador da tabela recebendo um vetor de colunas
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{ "Nome", "Quantidade"}, 0);

        //percorrer lista de medicos para cada item adicionar no modelo
        for (int i = 0; i < ListMedicamento.size(); i++) {
            Object linha[] = new Object[]{ListMedicamento.get(i).getNome(),
                ListMedicamento.get(i).getQuantidademedi()};

            modelo.addRow(linha);

        }
        ArrayList array = new ArrayList();
        
        novo1 += "NOME:  "+campoNomeMedicamento.getText().trim()
        +"  QUANTIDADE:  "+campoQuantidadeMedicamento.getText().trim()+"\n";
        
        array.add(novo1);
        
        tabelaMedicamento.setModel(modelo);//manupulando a tabela para receber a estrurura da tabela

        //setando as larguras para atualiza-las
        tabelaMedicamento.getColumnModel().getColumn(0).setPreferredWidth(200);
        tabelaMedicamento.getColumnModel().getColumn(1).setPreferredWidth(150);

    }

    public void LoadTableEquipamento() {
        //modelador da tabela recebendo um vetor de colunas
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Nome", "Quantidade", "Disponivel"}, 0);

        //percorrer lista de medicos para cada item adicionar no modelo
        for (int i = 0; i < ListEquipamento.size(); i++) {
            Object linha[] = new Object[]{ListEquipamento.get(i).getNome(),
                ListEquipamento.get(i).getQuantidade(),
                ListEquipamento.get(i).getdisponivel()};

            modelo.addRow(linha);

        }
        
        ArrayList array = new ArrayList();
        
        novo2 += "NOME:  "+campoNomeEquipamento.getText().trim()  
        +"QUANTIDADE:  "+campoQuantidadeEquipamento.getText().trim()  
        +"  DISPONIVEL:  "+campoDisponibidadeEquipamento.getText().trim()+"\n";
        
        array.add(novo2);
        tabelaEquipamento.setModel(modelo);//manupulando a tabela para receber a estrurura da tabela

        //setando as larguras para atualiza-las
        tabelaEquipamento.getColumnModel().getColumn(0).setPreferredWidth(200);
        tabelaEquipamento.getColumnModel().getColumn(1).setPreferredWidth(150);
        tabelaEquipamento.getColumnModel().getColumn(2).setPreferredWidth(150);

    }

    public JPrincipal() {
        initComponents();
        Listmedico = new ArrayList();
        ListMedicamento = new ArrayList();
        ListEquipamento = new ArrayList();
        modoEquipamento = "Navegar";
        modoMedico = "Navegar";
        modoMedicamento = "Navegar";
        ManipulaInterfaceEquipamento();
        ManipulaInterfaceMedico();
        ManipulaInterfaceMedicamento();
        setLocationRelativeTo(null);//para a tela projeta ao meio

    }
    JFramePaciente jFP = new JFramePaciente();

    public void ManipulaInterfaceMedico() {
        switch (modoMedico) {
            case "Navegar":
                botaoSalvarMedico.setEnabled(false);//botoes pode ser clicavel
                botaoCancelarMedicos.setEnabled(false);
                campoEspecialidadeMedico.setEnabled(false);
                campoCrmMedico.setEnabled(false);
                campoNomeMedico.setEnabled(false);
                campoDiaPlantaoMedico.setEnabled(false);
                campoMesPlantaoMedico.setEnabled(false);
                campoAnoPlantaoMedico.setEnabled(false);
                campoIdadeMedico.setEnabled(false);
                botaoNovoMedico.setEnabled(true);
                botaoEditarMedico.setEnabled(false);
                botaoExcluirMedico.setEnabled(false);

                break;

            case "Novo":
                campoNomeMedico.setEnabled(true);
                botaoSalvarMedico.setEnabled(true);//botoes pode ser clicavel
                botaoCancelarMedicos.setEnabled(true);
                campoEspecialidadeMedico.setEnabled(true);
                campoCrmMedico.setEnabled(true);
                campoDiaPlantaoMedico.setEnabled(true);
                campoMesPlantaoMedico.setEnabled(true);
                campoAnoPlantaoMedico.setEnabled(true);
                campoIdadeMedico.setEnabled(true);
                botaoNovoMedico.setEnabled(true);
                botaoEditarMedico.setEnabled(false);
                botaoExcluirMedico.setEnabled(false);

                break;

            case "Editar":

                botaoSalvarMedico.setEnabled(true);//botoes pode ser clicavel
                botaoCancelarMedicos.setEnabled(true);
                campoEspecialidadeMedico.setEnabled(true);
                campoCrmMedico.setEnabled(true);
                campoMesPlantaoMedico.setEnabled(true);
                campoAnoPlantaoMedico.setEnabled(true);
                campoIdadeMedico.setEnabled(true);
                botaoNovoMedico.setEnabled(true);
                campoDiaPlantaoMedico.setEnabled(true);
                botaoEditarMedico.setEnabled(false);
                botaoExcluirMedico.setEnabled(false);
                campoNomeMedico.setEnabled(true);

                break;

            case "Excluir":

                botaoSalvarMedico.setEnabled(false);//botoes pode ser clicavel
                botaoCancelarMedicos.setEnabled(false);
                campoEspecialidadeMedico.setEnabled(false);
                campoCrmMedico.setEnabled(false);
                campoDiaPlantaoMedico.setEnabled(false);
                campoMesPlantaoMedico.setEnabled(false);
                campoAnoPlantaoMedico.setEnabled(false);
                campoIdadeMedico.setEnabled(false);
                botaoNovoMedico.setEnabled(true);
                botaoEditarMedico.setEnabled(false);
                botaoExcluirMedico.setEnabled(false);
                campoNomeMedico.setEnabled(false);

                break;

            case "Selecao":

                botaoSalvarMedico.setEnabled(false);//botoes pode ser clicavel
                botaoCancelarMedicos.setEnabled(false);
                campoEspecialidadeMedico.setEnabled(false);
                campoCrmMedico.setEnabled(false);
                campoDiaPlantaoMedico.setEnabled(false);
                campoMesPlantaoMedico.setEnabled(false);
                campoAnoPlantaoMedico.setEnabled(false);
                campoIdadeMedico.setEnabled(false);
                botaoNovoMedico.setEnabled(false);
                botaoEditarMedico.setEnabled(true);
                botaoExcluirMedico.setEnabled(true);
                campoNomeMedico.setEnabled(false);

                break;

            default:
                System.out.println("Modo Ivalido");

        }
    }

    public void ManipulaInterfaceMedicamento() {
        switch (modoMedicamento) {
            case "Navegar":

                botaoSalvarMedicamento.setEnabled(false);//botoes pode ser clicavel
                botaoCancelarMedicamento.setEnabled(false);
                campoQuantidadeMedicamento.setEnabled(false);
                campoNomeMedicamento.setEnabled(false);
                botaoNovoMedicamento.setEnabled(true);
                botaoEditarMedicamento.setEnabled(false);
                botaoExcluirMedicamento.setEnabled(false);

                break;

            case "Novo":

                botaoSalvarMedicamento.setEnabled(true);//botoes pode ser clicavel
                botaoCancelarMedicamento.setEnabled(true);
                campoQuantidadeMedicamento.setEnabled(true);
                campoNomeMedicamento.setEnabled(true);
                botaoNovoMedicamento.setEnabled(true);
                botaoEditarMedicamento.setEnabled(false);
                botaoExcluirMedicamento.setEnabled(false);

                break;

            case "Editar":

                botaoSalvarMedicamento.setEnabled(true);//botoes pode ser clicavel
                botaoCancelarMedicamento.setEnabled(true);
                campoQuantidadeMedicamento.setEnabled(true);
                campoNomeMedicamento.setEnabled(true);
                botaoNovoMedicamento.setEnabled(true);
                botaoEditarMedicamento.setEnabled(false);
                botaoExcluirMedicamento.setEnabled(false);

                break;

            case "Excluir":

                botaoSalvarMedicamento.setEnabled(false);//botoes pode ser clicavel
                botaoCancelarMedicamento.setEnabled(false);
                campoQuantidadeMedicamento.setEnabled(false);
                campoNomeMedicamento.setEnabled(false);
                botaoNovoMedicamento.setEnabled(true);
                botaoEditarMedicamento.setEnabled(false);
                botaoExcluirMedicamento.setEnabled(false);
                break;

            case "Selecao":

                botaoSalvarMedicamento.setEnabled(false);//botoes pode ser clicavel
                botaoCancelarMedicamento.setEnabled(false);
                campoQuantidadeMedicamento.setEnabled(false);
                campoNomeMedicamento.setEnabled(false);
                botaoNovoMedicamento.setEnabled(true);
                botaoEditarMedicamento.setEnabled(true);
                botaoExcluirMedicamento.setEnabled(true);

                break;

            default:
                System.out.println("Modo Ivalido");

        }

    }

    public void ManipulaInterfaceEquipamento() {
        switch (modoEquipamento) {
            case "Navegar":
                botaoSalvarEquipamento.setEnabled(false);//botoes pode ser clicavel
                botaoCancelarEquipamento.setEnabled(false);
                campoNomeEquipamento.setEnabled(false);
                campoQuantidadeEquipamento.setEnabled(false);
                campoDisponibidadeEquipamento.setEnabled(false);
                botaoNovoEquipamento.setEnabled(true);
                botaoEditarEquipamento.setEnabled(false);
                botaoExcluirEquipamento.setEnabled(false);

                break;

            case "Novo":

                botaoSalvarEquipamento.setEnabled(true);//botoes pode ser clicavel
                botaoCancelarEquipamento.setEnabled(true);
                campoNomeEquipamento.setEnabled(true);
                campoQuantidadeEquipamento.setEnabled(true);
                campoDisponibidadeEquipamento.setEnabled(true);
                botaoNovoEquipamento.setEnabled(true);
                botaoEditarEquipamento.setEnabled(false);
                botaoExcluirEquipamento.setEnabled(false);

                break;

            case "Editar":

                botaoSalvarEquipamento.setEnabled(true);//botoes pode ser clicavel
                botaoCancelarEquipamento.setEnabled(true);
                campoNomeEquipamento.setEnabled(true);
                campoQuantidadeEquipamento.setEnabled(true);
                campoDisponibidadeEquipamento.setEnabled(true);
                botaoNovoEquipamento.setEnabled(true);
                botaoEditarEquipamento.setEnabled(false);
                botaoExcluirEquipamento.setEnabled(false);

                break;

            case "Excluir":

                botaoSalvarEquipamento.setEnabled(false);//botoes pode ser clicavel
                botaoCancelarEquipamento.setEnabled(false);
                campoNomeEquipamento.setEnabled(false);
                campoQuantidadeEquipamento.setEnabled(false);
                campoDisponibidadeEquipamento.setEnabled(false);
                botaoNovoEquipamento.setEnabled(true);
                botaoEditarEquipamento.setEnabled(false);
                botaoExcluirEquipamento.setEnabled(false);

                break;

            case "Selecao":

                botaoSalvarEquipamento.setEnabled(false);//botoes pode ser clicavel
                botaoCancelarEquipamento.setEnabled(false);
                campoNomeEquipamento.setEnabled(false);
                campoQuantidadeEquipamento.setEnabled(false);
                campoDisponibidadeEquipamento.setEnabled(false);
                botaoNovoEquipamento.setEnabled(false);
                botaoEditarEquipamento.setEnabled(true);
                botaoExcluirEquipamento.setEnabled(true);

                break;

            default:
                System.out.println("Modo Ivalido");

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jButton2 = new javax.swing.JButton();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        PanelGuiaMedicos = new javax.swing.JTabbedPane();
        PainelGuiaMedicamentos = new javax.swing.JPanel();
        botaoEditarMedicamento = new javax.swing.JButton();
        botaoExcluirMedicamento = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaMedicamento = new javax.swing.JTable();
        botaoNovoMedicamento = new javax.swing.JButton();
        painelAuxiliarMedicamento = new javax.swing.JPanel();
        NomeMedicamento = new javax.swing.JLabel();
        campoNomeMedicamento = new javax.swing.JTextField();
        QuantidadeMedicamento = new javax.swing.JLabel();
        campoQuantidadeMedicamento = new javax.swing.JTextField();
        botaoSalvarMedicamento = new javax.swing.JButton();
        botaoCancelarMedicamento = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        PainelGuiaMedicos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaMedicos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        painelAuxiliarMedicos = new javax.swing.JPanel();
        especialidadeMedico = new javax.swing.JLabel();
        campoEspecialidadeMedico = new javax.swing.JTextField();
        crmMedico = new javax.swing.JLabel();
        campoCrmMedico = new javax.swing.JTextField();
        dataPlantaoMedico = new javax.swing.JLabel();
        campoDiaPlantaoMedico = new javax.swing.JTextField();
        campoMesPlantaoMedico = new javax.swing.JTextField();
        campoAnoPlantaoMedico = new javax.swing.JTextField();
        diaDataPlantaoMedico = new javax.swing.JLabel();
        mesDataPlantaoMedico = new javax.swing.JLabel();
        anoDataPlantaoMedico = new javax.swing.JLabel();
        campoIdadeMedico = new javax.swing.JTextField();
        idadeMedico = new javax.swing.JLabel();
        nomeMedico = new javax.swing.JLabel();
        campoNomeMedico = new javax.swing.JTextField();
        botaoSalvarMedico = new javax.swing.JButton();
        botaoCancelarMedicos = new javax.swing.JButton();
        botaoNovoMedico = new javax.swing.JButton();
        botaoEditarMedico = new javax.swing.JButton();
        botaoExcluirMedico = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        PainelGuiaEquipamentos = new javax.swing.JPanel();
        botaoEditarEquipamento = new javax.swing.JButton();
        botaoExcluirEquipamento = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        painelAuxiliarEquipamento = new javax.swing.JPanel();
        nomeEquipamento = new javax.swing.JLabel();
        campoNomeEquipamento = new javax.swing.JTextField();
        quantidadeEquipamento = new javax.swing.JLabel();
        campoQuantidadeEquipamento = new javax.swing.JTextField();
        botaoSalvarEquipamento = new javax.swing.JButton();
        botaoCancelarEquipamento = new javax.swing.JButton();
        disponibilidadeEquipamento = new javax.swing.JLabel();
        campoDisponibidadeEquipamento = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaEquipamento = new javax.swing.JTable();
        botaoNovoEquipamento = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botaoEditarMedicamento.setText("Editar");
        botaoEditarMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarMedicamentoActionPerformed(evt);
            }
        });

        botaoExcluirMedicamento.setText("Excluir");
        botaoExcluirMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirMedicamentoActionPerformed(evt);
            }
        });

        tabelaMedicamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Quantidade", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaMedicamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMedicamentoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaMedicamento);
        if (tabelaMedicamento.getColumnModel().getColumnCount() > 0) {
            tabelaMedicamento.getColumnModel().getColumn(0).setPreferredWidth(150);
            tabelaMedicamento.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        botaoNovoMedicamento.setText("Novo");
        botaoNovoMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovoMedicamentoActionPerformed(evt);
            }
        });

        painelAuxiliarMedicamento.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Medicamentos")));

        NomeMedicamento.setText("Nome");

        QuantidadeMedicamento.setText("Quantidade");

        campoQuantidadeMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoQuantidadeMedicamentoActionPerformed(evt);
            }
        });

        botaoSalvarMedicamento.setText("Salvar");
        botaoSalvarMedicamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoSalvarMedicamentoMouseClicked(evt);
            }
        });
        botaoSalvarMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarMedicamentoActionPerformed(evt);
            }
        });

        botaoCancelarMedicamento.setText("Cancelar");
        botaoCancelarMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarMedicamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelAuxiliarMedicamentoLayout = new javax.swing.GroupLayout(painelAuxiliarMedicamento);
        painelAuxiliarMedicamento.setLayout(painelAuxiliarMedicamentoLayout);
        painelAuxiliarMedicamentoLayout.setHorizontalGroup(
            painelAuxiliarMedicamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAuxiliarMedicamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelAuxiliarMedicamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelAuxiliarMedicamentoLayout.createSequentialGroup()
                        .addGroup(painelAuxiliarMedicamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NomeMedicamento)
                            .addComponent(QuantidadeMedicamento))
                        .addGap(36, 36, 36)
                        .addGroup(painelAuxiliarMedicamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoNomeMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoQuantidadeMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(painelAuxiliarMedicamentoLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(botaoSalvarMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addComponent(botaoCancelarMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))))
        );
        painelAuxiliarMedicamentoLayout.setVerticalGroup(
            painelAuxiliarMedicamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAuxiliarMedicamentoLayout.createSequentialGroup()
                .addGroup(painelAuxiliarMedicamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomeMedicamento)
                    .addComponent(campoNomeMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(painelAuxiliarMedicamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(QuantidadeMedicamento)
                    .addComponent(campoQuantidadeMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(painelAuxiliarMedicamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvarMedicamento)
                    .addComponent(botaoCancelarMedicamento))
                .addContainerGap(130, Short.MAX_VALUE))
        );

        jButton3.setText("fechar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelGuiaMedicamentosLayout = new javax.swing.GroupLayout(PainelGuiaMedicamentos);
        PainelGuiaMedicamentos.setLayout(PainelGuiaMedicamentosLayout);
        PainelGuiaMedicamentosLayout.setHorizontalGroup(
            PainelGuiaMedicamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelGuiaMedicamentosLayout.createSequentialGroup()
                .addComponent(botaoNovoMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoEditarMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoExcluirMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jButton3)
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
            .addGroup(PainelGuiaMedicamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(painelAuxiliarMedicamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PainelGuiaMedicamentosLayout.setVerticalGroup(
            PainelGuiaMedicamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelGuiaMedicamentosLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelGuiaMedicamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoNovoMedicamento)
                    .addComponent(botaoEditarMedicamento)
                    .addComponent(botaoExcluirMedicamento)
                    .addComponent(jButton3))
                .addContainerGap(328, Short.MAX_VALUE))
            .addGroup(PainelGuiaMedicamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelGuiaMedicamentosLayout.createSequentialGroup()
                    .addGap(0, 203, Short.MAX_VALUE)
                    .addComponent(painelAuxiliarMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        PanelGuiaMedicos.addTab("Medicamentos", PainelGuiaMedicamentos);

        tabelaMedicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Especialidade", "Crm", "DataPlantao", "Nome", "Idade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaMedicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMedicosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaMedicos);
        if (tabelaMedicos.getColumnModel().getColumnCount() > 0) {
            tabelaMedicos.getColumnModel().getColumn(0).setPreferredWidth(150);
            tabelaMedicos.getColumnModel().getColumn(1).setPreferredWidth(300);
            tabelaMedicos.getColumnModel().getColumn(2).setPreferredWidth(200);
            tabelaMedicos.getColumnModel().getColumn(3).setPreferredWidth(200);
            tabelaMedicos.getColumnModel().getColumn(4).setPreferredWidth(150);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Medicos"));

        especialidadeMedico.setText("Especialidade");

        campoEspecialidadeMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoEspecialidadeMedicoActionPerformed(evt);
            }
        });

        crmMedico.setText("Crm");

        campoCrmMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCrmMedicoActionPerformed(evt);
            }
        });

        dataPlantaoMedico.setText("DataPlantao");

        campoDiaPlantaoMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDiaPlantaoMedicoActionPerformed(evt);
            }
        });

        campoMesPlantaoMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoMesPlantaoMedicoActionPerformed(evt);
            }
        });

        campoAnoPlantaoMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoAnoPlantaoMedicoActionPerformed(evt);
            }
        });

        diaDataPlantaoMedico.setText("Dia");

        mesDataPlantaoMedico.setText("Mes");

        anoDataPlantaoMedico.setText("Ano");

        campoIdadeMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoIdadeMedicoActionPerformed(evt);
            }
        });

        idadeMedico.setText("Idade");

        nomeMedico.setText("Nome");

        campoNomeMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeMedicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelAuxiliarMedicosLayout = new javax.swing.GroupLayout(painelAuxiliarMedicos);
        painelAuxiliarMedicos.setLayout(painelAuxiliarMedicosLayout);
        painelAuxiliarMedicosLayout.setHorizontalGroup(
            painelAuxiliarMedicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAuxiliarMedicosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelAuxiliarMedicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelAuxiliarMedicosLayout.createSequentialGroup()
                        .addComponent(dataPlantaoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(diaDataPlantaoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(especialidadeMedico)
                    .addComponent(crmMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idadeMedico)
                    .addComponent(nomeMedico))
                .addGap(3, 3, 3)
                .addGroup(painelAuxiliarMedicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelAuxiliarMedicosLayout.createSequentialGroup()
                        .addComponent(campoDiaPlantaoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(mesDataPlantaoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(campoMesPlantaoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(anoDataPlantaoMedico)
                        .addGap(18, 18, 18)
                        .addComponent(campoAnoPlantaoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(campoCrmMedico)
                    .addComponent(campoIdadeMedico)
                    .addComponent(campoEspecialidadeMedico)
                    .addComponent(campoNomeMedico))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelAuxiliarMedicosLayout.setVerticalGroup(
            painelAuxiliarMedicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAuxiliarMedicosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelAuxiliarMedicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nomeMedico)
                    .addComponent(campoNomeMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelAuxiliarMedicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoEspecialidadeMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(especialidadeMedico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(painelAuxiliarMedicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoCrmMedico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(crmMedico, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelAuxiliarMedicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoIdadeMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idadeMedico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelAuxiliarMedicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataPlantaoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diaDataPlantaoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoDiaPlantaoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesDataPlantaoMedico)
                    .addComponent(campoMesPlantaoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anoDataPlantaoMedico)
                    .addComponent(campoAnoPlantaoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        botaoSalvarMedico.setText("Salvar");
        botaoSalvarMedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoSalvarMedicoMouseClicked(evt);
            }
        });
        botaoSalvarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarMedicoActionPerformed(evt);
            }
        });

        botaoCancelarMedicos.setText("Cancelar");
        botaoCancelarMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarMedicosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelAuxiliarMedicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(botaoSalvarMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(botaoCancelarMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(painelAuxiliarMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvarMedico)
                    .addComponent(botaoCancelarMedicos))
                .addGap(26, 26, 26))
        );

        botaoNovoMedico.setText("Novo");
        botaoNovoMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovoMedicoActionPerformed(evt);
            }
        });

        botaoEditarMedico.setText("Editar");
        botaoEditarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarMedicoActionPerformed(evt);
            }
        });

        botaoExcluirMedico.setText("Excluir");
        botaoExcluirMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirMedicoActionPerformed(evt);
            }
        });

        jButton1.setText("fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelGuiaMedicosLayout = new javax.swing.GroupLayout(PainelGuiaMedicos);
        PainelGuiaMedicos.setLayout(PainelGuiaMedicosLayout);
        PainelGuiaMedicosLayout.setHorizontalGroup(
            PainelGuiaMedicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelGuiaMedicosLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1)
            .addGroup(PainelGuiaMedicosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoNovoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(botaoEditarMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(botaoExcluirMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(31, 31, 31))
        );
        PainelGuiaMedicosLayout.setVerticalGroup(
            PainelGuiaMedicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelGuiaMedicosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PainelGuiaMedicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoNovoMedico)
                    .addGroup(PainelGuiaMedicosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botaoEditarMedico)
                        .addComponent(botaoExcluirMedico)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelGuiaMedicos.addTab("Medicos", PainelGuiaMedicos);

        botaoEditarEquipamento.setText("Editar");
        botaoEditarEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarEquipamentoActionPerformed(evt);
            }
        });

        botaoExcluirEquipamento.setText("Excluir");
        botaoExcluirEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirEquipamentoActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Equipamentos"));

        nomeEquipamento.setText("Nome");

        quantidadeEquipamento.setText("Quantidade");

        campoQuantidadeEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoQuantidadeEquipamentoActionPerformed(evt);
            }
        });

        botaoSalvarEquipamento.setText("Salvar");
        botaoSalvarEquipamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoSalvarEquipamentoMouseClicked(evt);
            }
        });
        botaoSalvarEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarEquipamentoActionPerformed(evt);
            }
        });

        botaoCancelarEquipamento.setText("Cancelar");
        botaoCancelarEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarEquipamentoActionPerformed(evt);
            }
        });

        disponibilidadeEquipamento.setText("Disponibilidade");

        campoDisponibidadeEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDisponibidadeEquipamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelAuxiliarEquipamentoLayout = new javax.swing.GroupLayout(painelAuxiliarEquipamento);
        painelAuxiliarEquipamento.setLayout(painelAuxiliarEquipamentoLayout);
        painelAuxiliarEquipamentoLayout.setHorizontalGroup(
            painelAuxiliarEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAuxiliarEquipamentoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoSalvarEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(botaoCancelarEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
            .addGroup(painelAuxiliarEquipamentoLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(painelAuxiliarEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeEquipamento)
                    .addComponent(quantidadeEquipamento)
                    .addComponent(disponibilidadeEquipamento))
                .addGap(36, 36, 36)
                .addGroup(painelAuxiliarEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoDisponibidadeEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNomeEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoQuantidadeEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelAuxiliarEquipamentoLayout.setVerticalGroup(
            painelAuxiliarEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAuxiliarEquipamentoLayout.createSequentialGroup()
                .addGroup(painelAuxiliarEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeEquipamento)
                    .addComponent(campoNomeEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(painelAuxiliarEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantidadeEquipamento)
                    .addComponent(campoQuantidadeEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelAuxiliarEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(disponibilidadeEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoDisponibidadeEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(painelAuxiliarEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botaoCancelarEquipamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoSalvarEquipamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelAuxiliarEquipamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(painelAuxiliarEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 72, Short.MAX_VALUE))
        );

        tabelaEquipamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Quantidade", "Disponibilidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaEquipamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaEquipamentoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaEquipamento);
        if (tabelaEquipamento.getColumnModel().getColumnCount() > 0) {
            tabelaEquipamento.getColumnModel().getColumn(0).setPreferredWidth(200);
            tabelaEquipamento.getColumnModel().getColumn(1).setPreferredWidth(150);
            tabelaEquipamento.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        botaoNovoEquipamento.setText("Novo");
        botaoNovoEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovoEquipamentoActionPerformed(evt);
            }
        });

        jButton4.setText("VERIFICAR CADASTRO");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelGuiaEquipamentosLayout = new javax.swing.GroupLayout(PainelGuiaEquipamentos);
        PainelGuiaEquipamentos.setLayout(PainelGuiaEquipamentosLayout);
        PainelGuiaEquipamentosLayout.setHorizontalGroup(
            PainelGuiaEquipamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelGuiaEquipamentosLayout.createSequentialGroup()
                .addGroup(PainelGuiaEquipamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(PainelGuiaEquipamentosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botaoNovoEquipamento)
                        .addGap(75, 75, 75)
                        .addComponent(botaoEditarEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botaoExcluirEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PainelGuiaEquipamentosLayout.setVerticalGroup(
            PainelGuiaEquipamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelGuiaEquipamentosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PainelGuiaEquipamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelGuiaEquipamentosLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(PainelGuiaEquipamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoEditarEquipamento)
                            .addComponent(botaoNovoEquipamento)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelGuiaEquipamentosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PainelGuiaEquipamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoExcluirEquipamento)
                            .addComponent(jButton4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        PanelGuiaMedicos.addTab("Equipamentos", PainelGuiaEquipamentos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(PanelGuiaMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelGuiaMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoEditarMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarMedicamentoActionPerformed
        modoMedicamento = "Editar";
        ManipulaInterfaceMedicamento();
    }//GEN-LAST:event_botaoEditarMedicamentoActionPerformed

    private void botaoExcluirMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirMedicamentoActionPerformed
        int index = tabelaMedicamento.getSelectedRow();
        if (index >= 0 && index < ListMedicamento.size()) {
            ListMedicamento.remove(index);

        }
        LoadTableMedicamento();
        modoMedicamento = "Navegar";
        ManipulaInterfaceMedicamento();

        campoNomeMedicamento.setText("");//quando clicar no botao novo,liberando os campos nome
        campoQuantidadeMedicamento.setText("");//quando clicar no botao novo,liberando os campos quantidade

    }//GEN-LAST:event_botaoExcluirMedicamentoActionPerformed

    private void tabelaMedicamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMedicamentoMouseClicked
        //verificando se a linha é validada
        int index = tabelaMedicamento.getSelectedRow();

        if (index >= 0 && index < ListMedicamento.size()) {
            Medicacao me = ListMedicamento.get(index);
            campoNomeMedicamento.setText(me.getNome());//alimentando os campos
            campoQuantidadeMedicamento.setText(String.valueOf(me.getQuantidademedi()));

            modoMedicamento = "Selecao";
            ManipulaInterfaceMedicamento();
        }
    }//GEN-LAST:event_tabelaMedicamentoMouseClicked

    private void botaoNovoMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoMedicamentoActionPerformed
        campoNomeMedicamento.setText("");//quando clicar no botao novo,liberando os campos Nome
        campoQuantidadeMedicamento.setText("");//quando clicar no botao novo,liberando os campos quantidade
        modoMedicamento = "Novo";
        ManipulaInterfaceMedicamento();
    }//GEN-LAST:event_botaoNovoMedicamentoActionPerformed

    private void campoQuantidadeMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoQuantidadeMedicamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoQuantidadeMedicamentoActionPerformed

    private void botaoSalvarMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarMedicamentoActionPerformed
       
        boolean inteiro = false;
        int aux = 0;
        Medicacao me = new Medicacao();
             
        
       if(campoNomeMedicamento.getText().trim().equals("") || campoQuantidadeMedicamento.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "ERRO!", JOptionPane.ERROR_MESSAGE);
         
      } else{
         try {
                 aux = Integer.parseInt(campoQuantidadeMedicamento.getText());
                 inteiro = true;
              } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,"Valor inválido. \nERRO: "+e.getMessage(),"ERRO!",JOptionPane.ERROR_MESSAGE);
                campoQuantidadeMedicamento.setText("");
            }
          
         }   
         //saber se esta editando ou criando um novo
          if (inteiro && modoMedicamento.equals("Novo")) {
           
            me.setQuantidademedi(aux);
            me.setNome(campoNomeMedicamento.getText());
           
            ListMedicamento.add(me);
           aux = Integer.parseInt(campoQuantidadeMedicamento.getText().trim());
          if (modoMedicamento.equals("Editar")) {
            int index = tabelaMedicamento.getSelectedRow();
            ListMedicamento.get(index).setNome(campoNomeMedicamento.getText());
            ListMedicamento.get(index).setQuantidademedi(aux);
            LoadTableMedicamento();
   
        }
       
        LoadTableMedicamento();//recarrecando a tabela
        modoMedicamento = "Navegar";
        ManipulaInterfaceMedicamento();

        campoNomeMedicamento.setText("");//quando clicar no botao novo,liberando os campos nome
        campoQuantidadeMedicamento.setText("");//quando clicar no botao novo,liberando os campos quantidade
        
    
        jFP.setCampoTextoMedicamento(novo1);

       }
    }//GEN-LAST:event_botaoSalvarMedicamentoActionPerformed

    private void botaoCancelarMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarMedicamentoActionPerformed
        campoNomeMedicamento.setText("");//quando clicar no botao novo,liberando os campos Nome
        campoQuantidadeMedicamento.setText("");//quando clicar no botao novo,liberando os campos quantidade
        modoMedicamento = "Navegar";
        ManipulaInterfaceMedicamento();
    }//GEN-LAST:event_botaoCancelarMedicamentoActionPerformed

    private void tabelaMedicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMedicosMouseClicked
        //verificando se a linha é validada
        int index = tabelaMedicos.getSelectedRow();

        if (index >= 0 && index < Listmedico.size()) {
            Medico m = Listmedico.get(index);
            campoCrmMedico.setText(m.getCrm());//alimentando os campos
            campoEspecialidadeMedico.setText(m.getEspecialidade());
            campoIdadeMedico.setText(String.valueOf(m.getIdade()));
            campoNomeMedico.setText(m.getNome());
            campoAnoPlantaoMedico.setText(m.getData());
            campoMesPlantaoMedico.setText(m.getData());
            campoDiaPlantaoMedico.setText(m.getData());

            modoMedico = "Selecao";
            ManipulaInterfaceMedico();
        }
    }//GEN-LAST:event_tabelaMedicosMouseClicked

    private void campoEspecialidadeMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoEspecialidadeMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoEspecialidadeMedicoActionPerformed

    private void campoCrmMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCrmMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCrmMedicoActionPerformed

    private void campoDiaPlantaoMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDiaPlantaoMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDiaPlantaoMedicoActionPerformed

    private void campoMesPlantaoMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoMesPlantaoMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoMesPlantaoMedicoActionPerformed

    private void campoAnoPlantaoMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoAnoPlantaoMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoAnoPlantaoMedicoActionPerformed

    private void campoIdadeMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoIdadeMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoIdadeMedicoActionPerformed

    private void campoNomeMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeMedicoActionPerformed

    private void botaoSalvarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarMedicoActionPerformed
       String[] choices;
        try {
           dia = Integer.parseInt(campoDiaPlantaoMedico.getText());
           mes = Integer.parseInt(campoMesPlantaoMedico.getText());
           ano = Integer.parseInt(campoAnoPlantaoMedico.getText()); 
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,"Formato de data inválido","ALERTA!",JOptionPane.ABORT);
        }
       
        if(dia>29 && mes==2){
               JOptionPane.showMessageDialog(this,"Mês:[2] só pode conter no maximo; 29 dias","ERRO",JOptionPane.INFORMATION_MESSAGE);
           }
            if(dia>30 && mes !=2){
                JOptionPane.showMessageDialog(this,"Campo 'Dia' Exede a quantidade permitida:(30)","ERRO",JOptionPane.ERROR_MESSAGE);
            }
             if(mes>12){
                JOptionPane.showMessageDialog(this,"Campo:'Mês' exede a quantidade permitida:(12)","ERRO!",JOptionPane.ERROR_MESSAGE);
             }
              Calendar cal = Calendar.getInstance();
              int year = cal.get(Calendar.YEAR);
              if(ano<year){
                 
                JOptionPane.showMessageDialog(this,"Ano menor que o atual:"+year,"ERRO!",JOptionPane.ERROR_MESSAGE);
              }
        int aux1 =0;
        boolean idadecerta = false;
        if(campoNomeMedico.getText().trim().equals("") ||
           campoCrmMedico.getText().trim().equals("") ||
           campoIdadeMedico.getText().trim().equals("")||
           campoDiaPlantaoMedico.getText().trim().equals("") ||
           campoMesPlantaoMedico.getText().trim().equals("") ||
           campoAnoPlantaoMedico.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this,"Insira todos os valores!","ERRO",JOptionPane.ERROR_MESSAGE);
           
        }else{
                
            try {
            aux1 = Integer.parseInt(campoIdadeMedico.getText());
            idadecerta = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,"Formoato invalido para idade.\nERRO:"+e.getMessage(),
                "ERRO",JOptionPane.ERROR_MESSAGE);
                campoIdadeMedico.setText("");
            } 
                  
        }
          
        //para quando clicar no editar o programa
        //saber se esta editando ou criando um novo
        if ( idadecerta && modoMedico.equals("Novo")) {
                  
            //criando um medico para adicionar ele na lista
            
         choices = new String[] { "Acupuntur: Tratamento para aliviar dores no corpo", "Diagnóstico e tratamento de doenças alérgicas",
            "Angiologia	 Tratamento de varizes e veias", "Cardiologia	 Trata do coração", "Clínica Geral	 Tratamento médico geral",
            " Coloproctologia	 Trata do intestino grosso/ânus", 
            "Dermatologia	 Trata de doenças da pele","Endocrinologia   Tratra de doenças do sistema endócrino(Diabetes,obesidade,tireoide)",
            "Fisiatria	 Reabilitação física","Fisioterapia	 Tratamento de disfunções por meio de recursos físicos",
            " Fonoaudiologia	 Terapia da fala/voz","Gastroenterologia	 Trata do intestino, estômago",
            "Geriatria	 Assistência e tratamento para terceira idade/idoso","Ginecologia	 Trata de doenças no aparelho reprodutor feminino",
            "Hematologia	 Trata do sangue","Homeopatia	 Medicina natural",
            "Infectologia	 Trata de doenças causadas por infecções/vírus","Nefrologia	 Trata dos rins",
            "Neurologia	 Trata do sistema nervoso"," Nutrição	 Trata da segurança alimentar",
             "Nutrologia	 Trata de problemas provocados pela alimentação inadequada","Odontologia	 Tratamentos dos dentes/região bucal e maxilar",
             "Oftalmologia	 Trata dos olhos","Oncologia	 Tratamento do câncer e tumores malignos",
             "Pediatria	     Assistência e tratamento da criança e do adolescente",
             "Ortopedia e Traumatologia  	 Trata dos ossos, músculos e elementos relacionados ao aparelho locomotor","Otorrinolaringologia	 Trata de doenças do ouvido, nariz, faringe e região do pescoço",
             "Psicologia	 Trata do comportamento e os processos mentais","Psicopedagogia	 Trata do processo de aprendizagem de crianças e adolescentes",
            "Psiquiatria	 Trata de problemas mentais e psíquicos","Reumatologia	 Tratamento dos tecidos conjuntivos e articulações",
            " Urologia   Trata do sistema reprodutor e de problemas urinários"};
 
            String especialidade = (String) JOptionPane.showInputDialog(null, "Escolha a especialidade.",
            "The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
            
            
            Medico m = new Medico();
            aux += (dia+"/"+mes+"/"+ano);
       
            especialidadeMe = especialidade;
            m.setCrm(campoCrmMedico.getText());
            m.setEspecialidade(especialidade);
            m.setNome(campoNomeMedico.getText());
            m.setIdade(aux1);
            m.setData(dia+"/"+mes+"/"+ano);
           
            Listmedico.add(m);
            
            novo += "NOME: "+campoNomeMedico.getText().trim() +"  CRM:  "+campoCrmMedico.getText().trim()+"  IDADE:   "+
            campoIdadeMedico.getText().trim()+"  DATA PLANTAO:  "+aux+"\n";
            novo += "ESPECIALIDADE: "+especialidadeMe;
            jFP.setCampoTextoMedico(novo);
            
            aux = "";
            LoadTableMedico();
            modoMedico = "Navegar";
            ManipulaInterfaceMedico();
           
        }if( idadecerta && modoMedico.equals("Editar")) {
            aux1 = Integer.parseInt(campoIdadeMedico.getText());
            int index = tabelaMedicos.getSelectedRow();
            Listmedico.get(index).setCrm(campoCrmMedico.getText());
            Listmedico.get(index).setData(dia+"/"+mes+"/"+ano);
            Listmedico.get(index).setEspecialidade(campoEspecialidadeMedico.getText());
            Listmedico.get(index).setNome(campoNomeMedico.getText());
            Listmedico.get(index).setIdade(aux1);
          
        
            dia=0;
            mes=0;
            ano=0;
            LoadTableMedico();//recarrecando a tabela

            modoMedico = "Navegar";
            ManipulaInterfaceMedico();

            campoCrmMedico.setText("");//quando clicar no botao novo,liberando os campos CRm
            campoEspecialidadeMedico.setText("");//quando clicar no botao novo,liberando os campos eespecialidade
            campoDiaPlantaoMedico.setText("");//quando clicar no botao novo,liberando os campos eespecialidade
            campoMesPlantaoMedico.setText("");
            campoAnoPlantaoMedico.setText("");
            campoIdadeMedico.setText("");
            campoNomeMedico.setText("");


            //novo += "ESPECIALIDADE: "+especialidadeMe;
            //jFP.setCampoTextoMedico(novo);

            aux = "";

        
    }//GEN-LAST:event_botaoSalvarMedicoActionPerformed
    }
    private void botaoCancelarMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarMedicosActionPerformed
        campoCrmMedico.setText("");//quando clicar no botao novo,liberando os campos CRm
        campoEspecialidadeMedico.setText("");//quando clicar no botao novo,liberando os campos eespecialidade
        campoDiaPlantaoMedico.setText("");//quando clicar no botao novo,liberando os campos eespecialidade
        campoMesPlantaoMedico.setText("");
        campoAnoPlantaoMedico.setText("");
        campoIdadeMedico.setText("");
        campoNomeMedico.setText("");
        modoMedico = "Navegar";
        ManipulaInterfaceMedico();
    }//GEN-LAST:event_botaoCancelarMedicosActionPerformed

    private void botaoNovoMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoMedicoActionPerformed

        campoCrmMedico.setText("");//quando clicar no botao novo,liberando os campos CRM
        campoEspecialidadeMedico.setText("");//quando clicar no botao novo,liberando os campos eespecialidade
        campoDiaPlantaoMedico.setText("");//quando clicar no botao novo,liberando os campos eespecialidade
        campoMesPlantaoMedico.setText("");
        campoAnoPlantaoMedico.setText("");
        campoIdadeMedico.setText("");
        campoNomeMedico.setText("");
        modoMedico = "Novo";
        ManipulaInterfaceMedico();
    }//GEN-LAST:event_botaoNovoMedicoActionPerformed

    private void botaoEditarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarMedicoActionPerformed
        modoMedico = "Editar";
        ManipulaInterfaceMedico();
    }//GEN-LAST:event_botaoEditarMedicoActionPerformed

    private void botaoExcluirMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirMedicoActionPerformed
        int index = tabelaMedicos.getSelectedRow();
        if (index >= 0 && index < Listmedico.size()) {
            Listmedico.remove(index);

        }
        LoadTableMedico();
        modoMedico = "Navegar";
        ManipulaInterfaceMedico();

        campoCrmMedico.setText("");//quando clicar no botao novo,liberando os campos CRm
        campoEspecialidadeMedico.setText("");//quando clicar no botao novo,liberando os campos eespecialidade
        campoDiaPlantaoMedico.setText("");//quando clicar no botao novo,liberando os campos eespecialidade
        campoMesPlantaoMedico.setText("");
        campoAnoPlantaoMedico.setText("");
        campoIdadeMedico.setText("");
        campoNomeMedico.setText("");

    }//GEN-LAST:event_botaoExcluirMedicoActionPerformed

    private void botaoEditarEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarEquipamentoActionPerformed
        modoEquipamento = "Editar";
        ManipulaInterfaceEquipamento();
    }//GEN-LAST:event_botaoEditarEquipamentoActionPerformed

    private void botaoExcluirEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirEquipamentoActionPerformed
        int index = tabelaEquipamento.getSelectedRow();
        if (index >= 0 && index < ListEquipamento.size()) {
            ListEquipamento.remove(index);

        }
        LoadTableMedicamento();
        modoMedicamento = "Navegar";
        ManipulaInterfaceMedicamento();

        campoNomeMedicamento.setText("");//quando clicar no botao novo,liberando os campos nome
        campoQuantidadeMedicamento.setText("");//quando clicar no botao novo,liberando os campos quantidade
        campoDisponibidadeEquipamento.setText("");

    }//GEN-LAST:event_botaoExcluirEquipamentoActionPerformed

    private void campoQuantidadeEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoQuantidadeEquipamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoQuantidadeEquipamentoActionPerformed

    private void botaoSalvarEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarEquipamentoActionPerformed
        int aux = Integer.parseInt(campoQuantidadeEquipamento.getText());
        int aux1 = Integer.parseInt(campoDisponibidadeEquipamento.getText());
        Equipamento e = new Equipamento();
        
        //saber se esta editando ou criando um novo
        if (modoEquipamento.equals("Novo")) {
           
            if(campoNomeEquipamento.getText().equals("")||
              campoQuantidadeEquipamento.getText().equals("")||
              campoDisponibidadeEquipamento.getText().equals("")){
               JOptionPane.showMessageDialog(this, "Preencha todos os campos.","ERRO!",JOptionPane.ERROR_MESSAGE);
           }
        
        if(aux1 > aux){
            JOptionPane.showMessageDialog(null,"Quantidade de equipamentos disponiveis e maior que o estoque\n"+
             "Quantidade:"+aux+" < Disponivel:"+aux1,"ERRO!", JOptionPane.ERROR_MESSAGE);
            e.setDisponivel(aux);
        }else{
            e.setNome(campoNomeEquipamento.getText());
            e.setQuantidade(aux);
            e.setDisponivel(aux1);
            ListEquipamento.add(e);
         if (modoEquipamento.equals("Editar")) {
            int index = tabelaEquipamento.getSelectedRow();
            ListEquipamento.get(index).setNome(campoNomeEquipamento.getText());
            ListEquipamento.get(index).setQuantidade(aux);
            ListEquipamento.get(index).setDisponivel(aux1);
         }
        

        LoadTableEquipamento();//recarrecando a tabela
        modoEquipamento = "Navegar";
        ManipulaInterfaceEquipamento();

        campoNomeEquipamento.setText("");//quando clicar no botao novo,liberando os campos nome
        campoQuantidadeEquipamento.setText("");//quando clicar no botao novo,liberando os campos quantidade
        campoDisponibidadeEquipamento.setText("");
      
        jFP.setCampoTextoEquipamento(novo2);
        jFP.recebeEquipamento(novo2);

    }//GEN-LAST:event_botaoSalvarEquipamentoActionPerformed
   }
  }
    private void botaoCancelarEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarEquipamentoActionPerformed
        campoNomeEquipamento.setText("");//quando clicar no botao novo,liberando os campos Nome
        campoQuantidadeMedicamento.setText("");//quando clicar no botao novo,liberando os campos quantidade
        campoDisponibidadeEquipamento.setText("");
        modoMedicamento = "Navegar";
        ManipulaInterfaceMedicamento();
    }//GEN-LAST:event_botaoCancelarEquipamentoActionPerformed

    private void campoDisponibidadeEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDisponibidadeEquipamentoActionPerformed

    }//GEN-LAST:event_campoDisponibidadeEquipamentoActionPerformed

    private void tabelaEquipamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEquipamentoMouseClicked
        //verificando se a linha é validada
        int index = tabelaEquipamento.getSelectedRow();

        if (index >= 0 && index < ListEquipamento.size()) {
            Equipamento e = ListEquipamento.get(index);
            campoNomeEquipamento.setText(e.getNome());//alimentando os campos
            campoQuantidadeEquipamento.setText(String.valueOf(e.getQuantidade()));
            campoDisponibidadeEquipamento.setText(String.valueOf(e.getdisponivel()));

            modoEquipamento = "Selecao";
            ManipulaInterfaceEquipamento();
        }
    }//GEN-LAST:event_tabelaEquipamentoMouseClicked

    private void botaoNovoEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoEquipamentoActionPerformed
        campoNomeEquipamento.setText("");//quando clicar no botao novo,liberando os campos Nome
        campoQuantidadeEquipamento.setText("");//quando clicar no botao novo,liberando os campos quantidade
        modoEquipamento = "Novo";
        ManipulaInterfaceEquipamento();
    }//GEN-LAST:event_botaoNovoEquipamentoActionPerformed

    private void botaoSalvarMedicamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoSalvarMedicamentoMouseClicked

    }//GEN-LAST:event_botaoSalvarMedicamentoMouseClicked

    private void botaoSalvarEquipamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoSalvarEquipamentoMouseClicked

        //modelador da tabela recebendo um vetor de colunas
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Quantidade", "Nome", "Disponibilidade"}, 0);

        //percorrer lista de medicos para cada item adicionar no modelo
        for (int i = 0; i < ListEquipamento.size(); i++) {
            Object linha[] = new Object[]{ListEquipamento.get(i).getNome(),
                ListEquipamento.get(i).getQuantidade(),
                ListEquipamento.get(i).getdisponivel()};

            modelo.addRow(linha);

        }
        tabelaEquipamento.setModel(modelo);//manupulando a tabela para receber a estrurura da tabela

        //setando as larguras para atualiza-las
        tabelaEquipamento.getColumnModel().getColumn(0).setPreferredWidth(200);
        tabelaEquipamento.getColumnModel().getColumn(1).setPreferredWidth(150);
        tabelaEquipamento.getColumnModel().getColumn(1).setPreferredWidth(150);

    }//GEN-LAST:event_botaoSalvarEquipamentoMouseClicked

    private void botaoSalvarMedicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoSalvarMedicoMouseClicked

        Medico m = new Medico();

        String ajudante = "";
        for (int i = 0; i < Listmedico.size(); i++) {
            ajudante += Listmedico.get(i) + "\n";

        }
        JFramePaciente jfp = new JFramePaciente();
    
    }//GEN-LAST:event_botaoSalvarMedicoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          //  jFP.setVisible(true);
          dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       jFP.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    public JFramePaciente getjFP() {
        return jFP;
    }

    public void setjFP(JFramePaciente jFP) {
        this.jFP = jFP;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NomeMedicamento;
    private javax.swing.JPanel PainelGuiaEquipamentos;
    private javax.swing.JPanel PainelGuiaMedicamentos;
    private javax.swing.JPanel PainelGuiaMedicos;
    private javax.swing.JTabbedPane PanelGuiaMedicos;
    private javax.swing.JLabel QuantidadeMedicamento;
    private javax.swing.JLabel anoDataPlantaoMedico;
    private javax.swing.JButton botaoCancelarEquipamento;
    private javax.swing.JButton botaoCancelarMedicamento;
    private javax.swing.JButton botaoCancelarMedicos;
    private javax.swing.JButton botaoEditarEquipamento;
    private javax.swing.JButton botaoEditarMedicamento;
    private javax.swing.JButton botaoEditarMedico;
    private javax.swing.JButton botaoExcluirEquipamento;
    private javax.swing.JButton botaoExcluirMedicamento;
    private javax.swing.JButton botaoExcluirMedico;
    private javax.swing.JButton botaoNovoEquipamento;
    private javax.swing.JButton botaoNovoMedicamento;
    private javax.swing.JButton botaoNovoMedico;
    private javax.swing.JButton botaoSalvarEquipamento;
    private javax.swing.JButton botaoSalvarMedicamento;
    private javax.swing.JButton botaoSalvarMedico;
    private javax.swing.JTextField campoAnoPlantaoMedico;
    private javax.swing.JTextField campoCrmMedico;
    private javax.swing.JTextField campoDiaPlantaoMedico;
    private javax.swing.JTextField campoDisponibidadeEquipamento;
    private javax.swing.JTextField campoEspecialidadeMedico;
    private javax.swing.JTextField campoIdadeMedico;
    private javax.swing.JTextField campoMesPlantaoMedico;
    private javax.swing.JTextField campoNomeEquipamento;
    private javax.swing.JTextField campoNomeMedicamento;
    private javax.swing.JTextField campoNomeMedico;
    private javax.swing.JTextField campoQuantidadeEquipamento;
    private javax.swing.JTextField campoQuantidadeMedicamento;
    private javax.swing.JLabel crmMedico;
    private javax.swing.JLabel dataPlantaoMedico;
    private javax.swing.JLabel diaDataPlantaoMedico;
    private javax.swing.JLabel disponibilidadeEquipamento;
    private javax.swing.JLabel especialidadeMedico;
    private javax.swing.JLabel idadeMedico;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JLabel mesDataPlantaoMedico;
    private javax.swing.JLabel nomeEquipamento;
    private javax.swing.JLabel nomeMedico;
    private javax.swing.JPanel painelAuxiliarEquipamento;
    private javax.swing.JPanel painelAuxiliarMedicamento;
    private javax.swing.JPanel painelAuxiliarMedicos;
    private javax.swing.JLabel quantidadeEquipamento;
    private javax.swing.JTable tabelaEquipamento;
    private javax.swing.JTable tabelaMedicamento;
    private javax.swing.JTable tabelaMedicos;
    // End of variables declaration//GEN-END:variables
}
