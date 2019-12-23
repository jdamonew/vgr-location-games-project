package vgr.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class login extends JFrame {


	private JPanel contentPane;
	private JTextField txtId;
	private JPasswordField txtSenha;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btt_login = new JButton("Login");
		btt_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btt_login.setFont(new Font("Consolas", Font.BOLD, 16));
		btt_login.setBounds(48, 353, 255, 25);
		contentPane.add(btt_login);
		
		JButton btt_sair = new JButton("Sair");
		btt_sair.setFont(new Font("Consolas", Font.BOLD, 13));
		btt_sair.setForeground(Color.RED);
		btt_sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
				
			}
		});
		btt_sair.setBounds(625, 455, 97, 25);
		contentPane.add(btt_sair);
		
		txtId = new JTextField();
		txtId.setBounds(48, 218, 255, 22);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lb_senha = new JLabel("Senha");
		lb_senha.setFont(new Font("Consolas", Font.BOLD, 16));
		lb_senha.setBounds(48, 257, 56, 16);
		contentPane.add(lb_senha);
		
		JLabel lb_id = new JLabel("ID");
		lb_id.setFont(new Font("Consolas", Font.BOLD, 16));
		lb_id.setBounds(48, 190, 24, 16);
		contentPane.add(lb_id);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(48, 285, 255, 22);
		contentPane.add(txtSenha);
		
		JCheckBox checkLembrar = new JCheckBox("Lembre de mim");
		checkLembrar.setBounds(48, 316, 181, 25);
		contentPane.add(checkLembrar);
		
		JLabel lb_icon1 = new JLabel("");
		lb_icon1.setIcon(new ImageIcon("C:\\Users\\DamoneW\\Desktop\\Projeto POO - J\u00F3bia Damone\\Anexos\\VGR.gif"));
		lb_icon1.setBounds(389, 76, 400, 351);
		contentPane.add(lb_icon1);
		
		JLabel lb_icon2 = new JLabel("");
		lb_icon2.setIcon(new ImageIcon("C:\\Users\\DamoneW\\Desktop\\Projeto POO - J\u00F3bia Damone\\Anexos\\Logo VGR (6).png"));
		lb_icon2.setBounds(6, 35, 350, 104);
		contentPane.add(lb_icon2);
		
		JButton btt_cadastrar = new JButton("Criar Conta");
		btt_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cadastro cadastramento = new Cadastro();
				cadastramento.setVisible(true);
				dispose();
				
			}
		});
		btt_cadastrar.setFont(new Font("Consolas", Font.BOLD, 16));
		btt_cadastrar.setBounds(48, 391, 255, 25);
		contentPane.add(btt_cadastrar);
	
	}

}
