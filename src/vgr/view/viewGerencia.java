package vgr.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class viewGerencia extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewGerencia frame = new viewGerencia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public viewGerencia() {
		setTitle("Gerenciador de Cadastros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGerenciadorDeCadastro = new JLabel("Gerenciador de Cadastros");
		lblGerenciadorDeCadastro.setFont(new Font("Consolas", Font.BOLD, 30));
		lblGerenciadorDeCadastro.setBounds(199, 13, 423, 55);
		contentPane.add(lblGerenciadorDeCadastro);
		//USUARIO NÃO PODE REDEREZAR A JANELA
				setResizable(false);
				//A JANELA NÃO POSSUA BORDAS QUANDO ""TRUE""
				setUndecorated(false);
				//JANELA CENTRALIZADA
				setLocationRelativeTo(null);
		
		JButton btnUsuario = new JButton("Usu\u00E1rios");
		btnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				viewTableUsuario TableUsuario = new viewTableUsuario();
				TableUsuario.setVisible(true);
				dispose();
			}
		});
		btnUsuario.setFont(new Font("Consolas", Font.BOLD, 16));
		btnUsuario.setBounds(12, 147, 151, 61);
		contentPane.add(btnUsuario);
		
		JButton btnGames = new JButton(" Games");
		btnGames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				viewTableGame TableGame = new viewTableGame();
				TableGame.setVisible(true);
				dispose();
			}
		});
		btnGames.setFont(new Font("Consolas", Font.BOLD, 16));
		btnGames.setBounds(175, 147, 151, 61);
		contentPane.add(btnGames);
		
		JButton btnDesenvolvedora = new JButton("Desenvolvedora");
		btnDesenvolvedora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewTableDesenvolvedora TableDesenvolvedora = new viewTableDesenvolvedora();
				TableDesenvolvedora.setVisible(true);
				dispose();
			}
		});
		btnDesenvolvedora.setFont(new Font("Consolas", Font.BOLD, 15));
		btnDesenvolvedora.setBounds(501, 147, 151, 61);
		contentPane.add(btnDesenvolvedora);
		
		JButton btnDlc = new JButton("DLC");
		btnDlc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewTableDlc TableUsuario = new viewTableDlc();
				TableUsuario.setVisible(true);
				dispose();
			}
		});
		btnDlc.setFont(new Font("Consolas", Font.BOLD, 15));
		btnDlc.setBounds(338, 147, 151, 61);
		contentPane.add(btnDlc);
		
		JButton btnVendas = new JButton("Vendas");
		btnVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				viewTableVendas TableVendas = new viewTableVendas();
				TableVendas.setVisible(true);
				dispose();
			}
		});
		btnVendas.setFont(new Font("Consolas", Font.BOLD, 16));
		btnVendas.setBounds(664, 147, 151, 61);
		contentPane.add(btnVendas);
		
		JLabel lblLoginAdminstrador = new JLabel("Login: Adminstrador");
		lblLoginAdminstrador.setFont(new Font("Consolas", Font.BOLD, 16));
		lblLoginAdminstrador.setBounds(12, 305, 171, 16);
		contentPane.add(lblLoginAdminstrador);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				viewLogin voltaLogin = new viewLogin();
				voltaLogin.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Consolas", Font.BOLD, 15));
		btnVoltar.setBounds(501, 301, 151, 25);
		contentPane.add(btnVoltar);
		
		JButton btnNewButton = new JButton("Sair");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja fechar?","Virtual Games Rental", JOptionPane.YES_NO_OPTION);
				if(resposta == JOptionPane.YES_OPTION){
					System.exit(0);
				}else if(resposta == JOptionPane.NO_OPTION){

				}	
			}
		});
		btnNewButton.setFont(new Font("Consolas", Font.BOLD, 15));
		btnNewButton.setBounds(664, 300, 151, 26);
		contentPane.add(btnNewButton);
		
		JButton bttIrSistema = new JButton("Ir para Sistema");
		bttIrSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				viewCatalogo irCatal = new viewCatalogo("");
				irCatal.setVisible(true);
				dispose();
			}
		});
		bttIrSistema.setBounds(664, 29, 151, 26);
		contentPane.add(bttIrSistema);
		
		
	}
}
