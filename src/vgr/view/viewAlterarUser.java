package vgr.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vgr.controller.UsuarioControl;
import vgr.model.UsuarioModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class viewAlterarUser extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeCompleto;
	private JTextField txtNomeUsuario;
	private JPasswordField txtSenha;
	private JTextField txtEmail;
	private JTextField txtData;
	private static String id;
	
	public viewAlterarUser(String id) {
		this.id = id;
		
		setTitle("Alterar Informa\u00E7\u00F5es - Usu\u00E1rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Alterar Informa\u00E7\u00F5es ");
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 25));
		lblNewLabel.setBounds(12, 34, 288, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomeC = new JLabel("Nome Completo");
		lblNomeC.setFont(new Font("Consolas", Font.BOLD, 16));
		lblNomeC.setBounds(12, 110, 130, 16);
		contentPane.add(lblNomeC);
		
		JLabel lblNomeU = new JLabel("Nome de Usu\u00E1rio");
		lblNomeU.setFont(new Font("Consolas", Font.BOLD, 16));
		lblNomeU.setBounds(12, 174, 151, 16);
		contentPane.add(lblNomeU);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Consolas", Font.BOLD, 16));
		lblSenha.setBounds(12, 234, 130, 16);
		contentPane.add(lblSenha);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Consolas", Font.BOLD, 16));
		lblEmail.setBounds(12, 298, 130, 16);
		contentPane.add(lblEmail);
		
		JLabel lblData = new JLabel("Data de Nascimento");
		lblData.setFont(new Font("Consolas", Font.BOLD, 16));
		lblData.setBounds(12, 365, 174, 16);
		contentPane.add(lblData);
		
		txtNomeCompleto = new JTextField();
		txtNomeCompleto.setBounds(12, 139, 288, 22);
		contentPane.add(txtNomeCompleto);
		txtNomeCompleto.setColumns(10);
		
		txtNomeUsuario = new JTextField();
		txtNomeUsuario.setBounds(12, 199, 288, 22);
		contentPane.add(txtNomeUsuario);
		txtNomeUsuario.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(12, 263, 288, 22);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(12, 330, 288, 22);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtData = new JTextField();
		txtData.setBounds(12, 394, 288, 22);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Consolas", Font.BOLD, 16));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				viewTableUsuario tabelaUser = new viewTableUsuario();
				tabelaUser.setVisible(true);
				dispose();
			}
		});
		
		btnVoltar.setBounds(286, 455, 130, 25);
		contentPane.add(btnVoltar);
		
		preencherCampos();
		JButton btnAlterar = new JButton("Confirmar Altera\u00E7\u00F5es");
		btnAlterar.setFont(new Font("Consolas", Font.BOLD, 15));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que alterar as informações?","Alteração de Informações", JOptionPane.YES_NO_OPTION);
				
				if(resposta == JOptionPane.YES_OPTION){
					alterar();
					viewTableUsuario tUser = new viewTableUsuario();
					tUser.setVisible(true);
					dispose();
				}else if(resposta == JOptionPane.NO_OPTION){
					viewTableUsuario tUser = new viewTableUsuario();
					tUser.setVisible(true);
					dispose();
				}		
				
			}
		});
		btnAlterar.setBounds(428, 455, 202, 25);
		contentPane.add(btnAlterar);
	}
	
	private void preencherCampos() {
		
		UsuarioControl uc = new UsuarioControl();
		UsuarioModel usuario = uc.consultarUsuarioPorId(id);
		
		System.out.println(usuario);
		
		txtNomeCompleto.setText(usuario.getNome());;
		txtNomeUsuario.setText(usuario.getId());;
		txtSenha.setText(usuario.getSenha());;
		txtEmail.setText(usuario.getEmail());;
		txtData.setText(usuario.getData_nasc());;
	}
	
	public void alterar() {
		
		UsuarioModel user = new UsuarioModel();
		
		user.setNome(txtNomeCompleto.getText());
		user.setId(txtNomeUsuario.getText());
		user.setSenha(txtSenha.getText());
		user.setEmail(txtEmail.getText());
		user.setData_nasc(txtData.getText());
		
		UsuarioControl.getInstancia().alterarUsuario(user, id);
		
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewAlterarUser frame = new viewAlterarUser(id);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();}}});
	}
}
