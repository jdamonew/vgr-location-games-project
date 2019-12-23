package vgr.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtEmail;
	private JPasswordField txtSenha;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Cadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_criaConta = new JLabel("Criar uma conta");
		lb_criaConta.setFont(new Font("Consolas", Font.BOLD, 25));
		lb_criaConta.setBounds(30, 28, 230, 30);
		contentPane.add(lb_criaConta);
		
		JLabel lblNome = new JLabel("Nome de Usu\u00E1rio");
		lblNome.setFont(new Font("Consolas", Font.BOLD, 16));
		lblNome.setBounds(30, 95, 135, 16);
		contentPane.add(lblNome);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Consolas", Font.BOLD, 16));
		lblEmail.setBounds(30, 174, 46, 16);
		contentPane.add(lblEmail);
		
		txtId = new JTextField();
		txtId.setBounds(30, 127, 340, 22);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setHorizontalAlignment(SwingConstants.LEFT);
		txtEmail.setBounds(30, 205, 340, 22);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Consolas", Font.BOLD, 16));
		lblSenha.setBounds(30, 251, 56, 16);
		contentPane.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setSelectionColor(Color.WHITE);
		txtSenha.setToolTipText("Senha dever\u00E1 ter no m\u00EDnimo 8 digitos.");
		txtSenha.setBounds(30, 276, 340, 22);
		contentPane.add(txtSenha);
		
		JButton btt_criaConta = new JButton("Criar Conta");
		btt_criaConta.setFont(new Font("Consolas", Font.BOLD, 13));
		btt_criaConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btt_criaConta.setBounds(191, 443, 112, 25);
		contentPane.add(btt_criaConta);
		
		JButton btt_Cancelar = new JButton("Cancelar");
		btt_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				login voltaLogin = new login();
				voltaLogin.setVisible(true);
				dispose();
			}
		});
		btt_Cancelar.setFont(new Font("Consolas", Font.BOLD, 13));
		btt_Cancelar.setForeground(new Color(255, 0, 0));
		btt_Cancelar.setBounds(324, 441, 112, 25);
		contentPane.add(btt_Cancelar);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(30, 373, 340, 30);
		contentPane.add(dateChooser);
		
		JLabel lblDataDeNasciento = new JLabel("Data de Nascimento");
		lblDataDeNasciento.setFont(new Font("Consolas", Font.BOLD, 16));
		lblDataDeNasciento.setBounds(30, 344, 170, 16);
		contentPane.add(lblDataDeNasciento);
		
		JLabel lblSenhaDeverTer = new JLabel("Senha dever\u00E1 ter no m\u00EDnimo 8 digitos.");
		lblSenhaDeverTer.setFont(new Font("Consolas", Font.ITALIC, 12));
		lblSenhaDeverTer.setBounds(30, 301, 273, 16);
		contentPane.add(lblSenhaDeverTer);
	}

}
