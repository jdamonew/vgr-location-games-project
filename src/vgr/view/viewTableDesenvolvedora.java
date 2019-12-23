package vgr.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ConexaoBanco.ConectaBanco;
import vgr.controller.DesenvolvedoraControl;
import vgr.model.DesenvolvedoraModel;



public class viewTableDesenvolvedora extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTable jtableDes;
	private ArrayList<DesenvolvedoraModel> listaDes;
	
	ConectaBanco con = new ConectaBanco();
	ResultSet rs;
	private JTextField txtCod;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewTableUsuario frame = new viewTableUsuario();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void inserirTabela(JTable table, ArrayList<DesenvolvedoraModel> dsv) 
	{
		DefaultTableModel dtmc = new DefaultTableModel();
		
		dtmc.addColumn("Código");
		dtmc.addColumn("Nome de Desenvolvedora");
		
		for(int i = 0, len = dsv.size(); i < len; i++) {
			String[] linha = new String[2];
			
			linha[0] = Integer.toString(dsv.get(i).getCod());
			linha[1] = dsv.get(i).getNome();
			
			dtmc.addRow( linha );
		}
		
		table.setModel(dtmc);
	}

	public viewTableDesenvolvedora() {
		
		setTitle("Desenvolvedoras - Vis\u00E3o Geral");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DesenvolvedoraControl dc = new DesenvolvedoraControl();
		
		jtableDes = new JTable();
		listaDes = dc.consultarDesenvolvedora();
		
		inserirTabela(jtableDes, listaDes);
		
		JScrollPane scrollPane = new JScrollPane(jtableDes);
		scrollPane.setBounds(132, 244, 690, 249);
		contentPane.add(scrollPane);
		
		//USUARIO NÃO PODE REDEREZAR A JANELA
		setResizable(false);
		//JANELA CENTRALIZADA
		setLocationRelativeTo(null);
		
		
		JButton bttAlterar = new JButton("Alterar");
		bttAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int codigo = 0;
				for(int i = 0, len = jtableDes.getSelectedRowCount(); i < len; i++)
					codigo = Integer.parseInt(jtableDes.getValueAt(jtableDes.getSelectedRows()[i], 0).toString());

					viewAlterarDesenvolvedora tdes = new viewAlterarDesenvolvedora(codigo);
					tdes.setVisible(true);
					dispose();
			}
		});
		bttAlterar.setBounds(22, 192, 98, 26);
		contentPane.add(bttAlterar);
		
		//BOTÃO CADASTRAR
		JButton bttCadastrar = new JButton("Cadastrar");
		bttCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String cod = txtCod.getText();
				String nome = txtNome.getText();
								
				if(nome.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Porfavor, insira um nome válido.", "Nome vazio", JOptionPane.WARNING_MESSAGE);
					
				}else if(cod.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Porfavor, insira um Código válido.", "Código vazio", JOptionPane.WARNING_MESSAGE);
					
				}else {
					cadastrarDesenvolvedora();
					listaDes = dc.consultarDesenvolvedora();
					inserirTabela(jtableDes, listaDes);
				}
				
			}
		});
		bttCadastrar.setBounds(22, 87, 98, 26);
		contentPane.add(bttCadastrar);
		
		JButton bttVoltar = new JButton("Voltar");
		bttVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewGerencia voltaGerencia = new viewGerencia();
				voltaGerencia.setVisible(true);
				dispose();
			}
		});
		
		//BOTÃO VOLTAR
		bttVoltar.setBounds(22, 453, 98, 26);
		contentPane.add(bttVoltar);
		
		//BOTÃO DELETAR
		JButton bttDeletar = new JButton("Deletar");
		bttDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int codigo = 0;
				for(int i = 0, len = jtableDes.getSelectedRowCount(); i < len; i++) {
					try {
						codigo = Integer.parseInt(jtableDes.getValueAt(jtableDes.getSelectedRows()[i], 0).toString());
						
					}catch (Exception e) {
						System.out.println("Erro, isso não é um número");
					}

					dc.deletarDesenvolvedora(codigo); 
				}
	
				listaDes = dc.consultarDesenvolvedora();
				inserirTabela(jtableDes, listaDes);
			}
			
		});
		bttDeletar.setBounds(22, 142, 98, 26);
		contentPane.add(bttDeletar);
		
		JLabel lblNewLabel = new JLabel("Desenvolvedoras - Vis\u00E3o Geral");
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNewLabel.setBounds(259, 12, 332, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomeCompleto = new JLabel("Nome ");
		lblNomeCompleto.setFont(new Font("Consolas", Font.BOLD, 16));
		lblNomeCompleto.setBounds(159, 146, 130, 20);
		contentPane.add(lblNomeCompleto);
		
		txtNome = new JTextField();
		txtNome.setBounds(259, 145, 483, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setFont(new Font("Consolas", Font.BOLD, 16));
		lblCdigo.setBounds(159, 108, 73, 16);
		contentPane.add(lblCdigo);
		
		txtCod = new JTextField();
		txtCod.setEnabled(true);
		txtCod.setBounds(259, 104, 483, 22);
		contentPane.add(txtCod);
		
	}

	public void cadastrarDesenvolvedora() {
		
		DesenvolvedoraModel dsv = new DesenvolvedoraModel();
		
		int cod = Integer.parseInt(txtCod.getText());
		
		dsv.setCod(cod);
		dsv.setNome(txtNome.getText());
		
		DesenvolvedoraControl.getInstancia().cadastrarDesenvolvedora(dsv);
		
	}
	
	
	
}
