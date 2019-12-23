package vgr.view;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import vgr.controller.UsuarioControl;
import vgr.model.UsuarioModel;
import javax.swing.JCheckBox;

public class viewCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private JTextField txtNomeCompleto;
	private JTextField txtData;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewCadastro frame = new viewCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public viewCadastro() {
		setTitle("Virtual Games Rental - Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb_criaConta = new JLabel("Criar uma conta");
		lb_criaConta.setFont(new Font("Consolas", Font.BOLD, 25));
		lb_criaConta.setBounds(30, 28, 340, 30);
		contentPane.add(lb_criaConta);
		//USUARIO NÃO PODE REDEREZAR A JANELA
		setResizable(false);
		//A JANELA NÃO POSSUA BORDAS QUANDO ""TRUE""
		setUndecorated(false);
		//JANELA CENTRALIZADA
		setLocationRelativeTo(null);
		
		JLabel lblNome = new JLabel("Nome de Usu\u00E1rio");
		lblNome.setFont(new Font("Consolas", Font.BOLD, 16));
		lblNome.setBounds(30, 152, 340, 16);
		contentPane.add(lblNome);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Consolas", Font.BOLD, 16));
		lblEmail.setBounds(30, 211, 340, 16);
		contentPane.add(lblEmail);
		
		txtId = new JTextField();
		txtId.setBounds(30, 180, 340, 22);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setHorizontalAlignment(SwingConstants.LEFT);
		txtEmail.setBounds(30, 239, 340, 22);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Consolas", Font.BOLD, 16));
		lblSenha.setBounds(30, 273, 340, 16);
		contentPane.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setSelectionColor(Color.WHITE);
		txtSenha.setToolTipText("Senha dever\u00E1 ter no m\u00EDnimo 8 digitos.");
		txtSenha.setBounds(30, 301, 340, 22);
		contentPane.add(txtSenha);
		
		JButton btt_criaConta = new JButton("Criar Conta");
		btt_criaConta.setEnabled(false);
		btt_criaConta.setFont(new Font("Consolas", Font.BOLD, 13));
		btt_criaConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				String nome = txtNomeCompleto.getText();
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
				}else if(data.length() < 11) {
						JOptionPane.showMessageDialog(null,"Porfavor, verifique a quantidade de caractéres. No formato dd/mm/aaaa", "Data de Nascimento Inválida!", JOptionPane.ERROR_MESSAGE);
		
				}else {
					cadastrarUsuario();
					viewLogin voltaLogin = new viewLogin();
					voltaLogin.setVisible(true);
					dispose();
					
				}
				
			}
				

			
		});
		btt_criaConta.setBounds(139, 467, 112, 25);
		contentPane.add(btt_criaConta);
		
		JButton btt_Cancelar = new JButton("Cancelar");
		btt_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				viewLogin voltaLogin = new viewLogin();
				voltaLogin.setVisible(true);
				dispose();
			}
		});
		btt_Cancelar.setFont(new Font("Consolas", Font.BOLD, 13));
		btt_Cancelar.setForeground(new Color(255, 0, 0));
		btt_Cancelar.setBounds(389, 467, 112, 25);
		contentPane.add(btt_Cancelar);
		
		JLabel lblDataDeNasciento = new JLabel("Data de Nascimento");
		lblDataDeNasciento.setFont(new Font("Consolas", Font.BOLD, 16));
		lblDataDeNasciento.setBounds(30, 350, 340, 16);
		contentPane.add(lblDataDeNasciento);
		
		JLabel lblSenhaDeverTer = new JLabel("Senha dever\u00E1 ter no m\u00EDnimo 8 digitos.");
		lblSenhaDeverTer.setFont(new Font("Consolas", Font.ITALIC, 12));
		lblSenhaDeverTer.setBounds(30, 322, 340, 22);
		contentPane.add(lblSenhaDeverTer);
		
		txtNomeCompleto = new JTextField();
		txtNomeCompleto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		txtNomeCompleto.setBounds(30, 120, 340, 22);
		contentPane.add(txtNomeCompleto);
		txtNomeCompleto.setColumns(10);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo");
		lblNomeCompleto.setFont(new Font("Consolas", Font.BOLD, 16));
		lblNomeCompleto.setBounds(30, 92, 340, 16);
		contentPane.add(lblNomeCompleto);
		
		JCheckBox ckTermos = new JCheckBox("Aceito os termos e condi\u00E7\u00E3o de uso.");
		ckTermos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(ckTermos.isSelected()==true) {
					btt_criaConta.setEnabled(true);
					
				}else{
					btt_criaConta.setEnabled(false);
				}
									
								
			}
		});
		ckTermos.setFont(new Font("Consolas", ckTermos.getFont().getStyle() | Font.BOLD, 12));
		ckTermos.setBounds(30, 405, 340, 25);
		contentPane.add(ckTermos);
		
		txtData = new JTextField();
		txtData.setActionCommand("");
		txtData.setToolTipText("dd/mm/aaaa");
		txtData.setText("\r\n");
		txtData.setBounds(30, 379, 340, 22);
		contentPane.add(txtData);
	}
	
	private void cadastrarUsuario() {
		
		UsuarioModel usuario = new UsuarioModel();
		
		usuario.setNome(txtNomeCompleto.getText());
		usuario.setId(txtId.getText());
		usuario.setSenha(txtSenha.getText());
		usuario.setEmail(txtEmail.getText());
		usuario.setData_nasc(txtData.getText());	
		
		
		UsuarioControl.getInstancia().cadastrarUsuario(usuario);
		
	}
	
}
