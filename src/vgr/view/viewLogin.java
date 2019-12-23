package vgr.view;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

import ConexaoBanco.ConectaBanco;
import vgr.controller.UsuarioControl;


public class viewLogin extends JFrame {
	

	private JPanel contentPane;
	private JTextField txtId;
	private JPasswordField txtSenha;
	private JLabel lb_icon2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewLogin frame = new viewLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public viewLogin() {
		
		setTitle("Virtual Games Rental");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		//USUARIO NÃO PODE REDEREZAR A JANELA
		setResizable(false);
		//JANELA CENTRALIZADA
		setLocationRelativeTo(null);
		
		
		JButton btt_login = new JButton("Login");
		btt_login.setBounds(48, 353, 275, 25);
		btt_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String login = txtId.getText();
				String password = txtSenha.getText();
				String id = "admin";
				String senha = "admin";
				
				UsuarioControl uc = new UsuarioControl();
				
				if(login.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Porfavor, insira um login válido.", "Login vazio", JOptionPane.ERROR_MESSAGE);
					
				} else if(password.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Porfavor, insira uma senha válida.", "Senha vazia", JOptionPane.ERROR_MESSAGE);
					
				} else if(login.equals(id) && password.equals(senha)) { // Login para administrador
					
					viewGerencia administrador = new viewGerencia();
					administrador.setVisible(true);
					dispose();
					
				} else if (uc.autenticaUsuario(login, password)) { // Login comum de usuario
					viewCatalogo catalogo = new viewCatalogo(login);
					catalogo.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null,"Porfavor, insira um usuário válido.", "Usuário incorreto", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			}
				
				
		});
		contentPane.setLayout(null);
		btt_login.setFont(new Font("Consolas", Font.BOLD, 16));
		contentPane.add(btt_login);
		
		JButton btt_sairLogin = new JButton("Sair");
		btt_sairLogin.setBounds(625, 455, 97, 25);
		btt_sairLogin.setFont(new Font("Consolas", Font.BOLD, 13));
		btt_sairLogin.setForeground(Color.RED);
		btt_sairLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja fechar?","Virtual Games Rental", JOptionPane.YES_NO_OPTION);
				
				if(resposta == JOptionPane.YES_OPTION){
					System.exit(0);
				}else if(resposta == JOptionPane.NO_OPTION){
					entrar();
				}				
				
			}
		});
		contentPane.add(btt_sairLogin);
		
		txtId = new JTextField();
		txtId.setBounds(48, 218, 275, 34);
		txtId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lb_senha = new JLabel("Senha");
		lb_senha.setBounds(48, 264, 56, 16);
		lb_senha.setFont(new Font("Consolas", Font.BOLD, 16));
		contentPane.add(lb_senha);
		
		JLabel lb_id = new JLabel("Nome de Usu\u00E1rio");
		lb_id.setBounds(48, 190, 275, 16);
		lb_id.setFont(new Font("Consolas", Font.BOLD, 16));
		contentPane.add(lb_id);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(48, 292, 275, 34);
		contentPane.add(txtSenha);
		
		JLabel lb_icon1 = new JLabel("");
		lb_icon1.setBounds(387, 77, 400, 351);
		lb_icon1.setIcon(new ImageIcon("Logos\\VGR.gif"));
		contentPane.add(lb_icon1);
		
		lb_icon2 = new JLabel("");
		lb_icon2.setBounds(6, 35, 350, 104);
		lb_icon2.setIcon(new ImageIcon("Logos\\Logo-VGR.png"));
		contentPane.add(lb_icon2);
		
		JButton bttCadastrar = new JButton("Criar Conta");
		bttCadastrar.setBounds(48, 391, 275, 25);
		bttCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				viewCadastro cadastramento = new viewCadastro();
				cadastramento.setVisible(true);
				dispose();
				
			}
		});
		bttCadastrar.setFont(new Font("Consolas", Font.BOLD, 16));
		contentPane.add(bttCadastrar);
	
	}
	
	public void entrar() {
		ConectaBanco con = new ConectaBanco();
		con.obterConexao();
	}
	
	
	
	
}
