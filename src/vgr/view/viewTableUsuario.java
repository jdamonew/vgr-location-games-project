package vgr.view;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ConexaoBanco.ConectaBanco;
import vgr.controller.UsuarioControl;
import vgr.model.UsuarioModel;


public class viewTableUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtId;
	private JPasswordField txtSenha;
	private JTextField txtEmail;
	private JTextField txtData;
	private JTable jtableUsuario;
	private ArrayList<UsuarioModel> listaUser;
	
	ConectaBanco con = new ConectaBanco();
	ResultSet rs;
	
	
	
	public void inserirTabela(JTable table, ArrayList<UsuarioModel> user) 
	{
		DefaultTableModel dtmc = new DefaultTableModel();
		jtableUsuario.getTableHeader().setReorderingAllowed(false);
				
		
		dtmc.addColumn("Nome");
		dtmc.addColumn("ID");
		dtmc.addColumn("Senha");
		dtmc.addColumn("Email");
		dtmc.addColumn("Nascimento");
		
		for(int i = 0, len = user.size(); i < len; i++) {
			String[] linha = new String[5];
			
			linha[0] = user.get(i).getNome();
			linha[1] = user.get(i).getId();
			linha[2] = user.get(i).getSenha();
			linha[3] = user.get(i).getEmail();
			linha[4] = user.get(i).getData_nasc();
			
			dtmc.addRow( linha );
		}
		
		table.setModel(dtmc);
	}

	public viewTableUsuario() {
		
		setTitle("Usu\u00E1rio - Vis\u00E3o Geral");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		UsuarioControl uc = new UsuarioControl();
		jtableUsuario = new JTable();
		listaUser = uc.consultarUsuario();
		
		inserirTabela(jtableUsuario, listaUser);
		
		JScrollPane scrollPane = new JScrollPane(jtableUsuario);
		scrollPane.setBounds(149, 221, 690, 249);
		contentPane.add(scrollPane);
		
		//USUARIO NÃO PODE REDEREZAR A JANELA
		setResizable(false);
		//JANELA CENTRALIZADA
		setLocationRelativeTo(null);
		
		
		JButton bttAlterar = new JButton("Alterar");
		bttAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sel = "";
				for(int i = 0, len = jtableUsuario.getSelectedRowCount(); i < len; i++) {
					sel = jtableUsuario.getValueAt(jtableUsuario.getSelectedRows()[i], 1).toString();

					viewAlterarUser alterar = new viewAlterarUser(sel);
					alterar.setVisible(true);
					dispose();
			}
			}
		});
		bttAlterar.setBounds(22, 192, 98, 26);
		contentPane.add(bttAlterar);
		
		//BOTÃO CADASTRAR
		JButton bttCadastrar = new JButton("Cadastrar");
		bttCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nome = txtNome.getText();
				String id = txtId.getText();
				String senha = txtSenha.getText();
				String email = txtEmail.getText();
				String data = txtData.getText();
				
				if(nome.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Porfavor, insira um nome válido.", "Nome vazio", JOptionPane.WARNING_MESSAGE);
					
				}else if(id.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Porfavor, insira um ID válido.", "ID vazio", JOptionPane.WARNING_MESSAGE);
					
				}else if(senha.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Porfavor, insira uma senha válida.", "Senha vazia", JOptionPane.WARNING_MESSAGE);
					
				}else if(senha.length() < 8) {
					JOptionPane.showMessageDialog(null,"Porfavor, digite uma senha com no minimo 8 digitos.", "Senha Inválida!", JOptionPane.ERROR_MESSAGE);
					
				}else if(email.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Porfavor, insira um email válido.", "Email vazio", JOptionPane.WARNING_MESSAGE);
					
				}else if(data.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Porfavor, insira uma data válida.", "Data de Nascimento vazia", JOptionPane.WARNING_MESSAGE);
				
				}else if(data.length() > 11) {
					JOptionPane.showMessageDialog(null,"Porfavor, verifique a quantidade de caractéres. No formato dd/mm/aaaa", "Data de Nascimento Inválida!", JOptionPane.ERROR_MESSAGE);
		
				}else {
					cadastrarUsuario();
					listaUser = uc.consultarUsuario();
					inserirTabela(jtableUsuario, listaUser);
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
				String sel = "";
				for(int i = 0, len = jtableUsuario.getSelectedRowCount(); i < len; i++) {
					sel = (String) jtableUsuario.getValueAt(jtableUsuario.getSelectedRows()[i], 1);

					uc.deletarUsuario(sel);
				}
				listaUser = uc.consultarUsuario();
				inserirTabela(jtableUsuario, listaUser);
			}
			
		});
		bttDeletar.setBounds(22, 142, 98, 26);
		contentPane.add(bttDeletar);
		
		JLabel lblNewLabel = new JLabel("Usuarios - Vis\u00E3o Geral");
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNewLabel.setBounds(269, 13, 293, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo");
		lblNomeCompleto.setFont(new Font("Consolas", Font.BOLD, 16));
		lblNomeCompleto.setBounds(166, 91, 130, 20);
		contentPane.add(lblNomeCompleto);
		
		txtNome = new JTextField();
		txtNome.setBounds(291, 90, 194, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblId = new JLabel("Nome de Usu\u00E1rio");
		lblId.setFont(new Font("Consolas", Font.BOLD, 16));
		lblId.setBounds(166, 133, 142, 16);
		contentPane.add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(315, 130, 170, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Consolas", Font.BOLD, 16));
		lblSenha.setBounds(166, 170, 55, 16);
		contentPane.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(291, 167, 194, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Consolas", Font.BOLD, 16));
		lblEmail.setBounds(503, 93, 55, 16);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(578, 90, 261, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setFont(new Font("Consolas", Font.BOLD, 16));
		lblDataDeNascimento.setBounds(503, 133, 170, 16);
		contentPane.add(lblDataDeNascimento);
		
		txtData = new JTextField();
		txtData.setBounds(691, 130, 148, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
	}

	private void cadastrarUsuario() {
		
		UsuarioModel usuario = new UsuarioModel();
		
		usuario.setNome(txtNome.getText());
		usuario.setId(txtId.getText());
		usuario.setSenha(txtSenha.getText());
		usuario.setEmail(txtEmail.getText());
		usuario.setData_nasc(txtData.getText());	
		
		
		UsuarioControl.getInstancia().cadastrarUsuario(usuario);
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewTableUsuario frame = new viewTableUsuario();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}}});
	}
}
