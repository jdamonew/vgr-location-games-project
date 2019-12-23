package vgr.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vgr.controller.DesenvolvedoraControl;
import vgr.controller.UsuarioControl;
import vgr.model.DesenvolvedoraModel;
import vgr.model.UsuarioModel;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class viewAlterarDesenvolvedora extends JFrame {

	private JPanel contentPane;
	private JTextField txtCod;
	private JTextField txtNome;
	private static int codigo;
	
	public viewAlterarDesenvolvedora(int codigo) {
		setTitle("Alterar Informa\u00E7\u00F5es - Desenvolvedora");
		this.codigo = codigo;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		
		JLabel lblNewLabel = new JLabel("Alterar Informa\u00E7\u00F5es ");
		lblNewLabel.setBounds(12, 28, 280, 30);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 25));
		contentPane.add(lblNewLabel);
		
		JLabel lblCod = new JLabel("C\u00F3digo");
		lblCod.setBounds(12, 99, 54, 20);
		lblCod.setFont(new Font("Consolas", Font.BOLD, 16));
		contentPane.add(lblCod);
		
		JLabel lblNewLabel_2 = new JLabel("Nome de Desenvolvedora");
		lblNewLabel_2.setBounds(12, 189, 198, 20);
		lblNewLabel_2.setFont(new Font("Consolas", Font.BOLD, 16));
		contentPane.add(lblNewLabel_2);
		
		txtCod = new JTextField();
		txtCod.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtCod.setBounds(12, 133, 116, 22);
		txtCod.setEnabled(false);
		contentPane.add(txtCod);
		txtCod.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(12, 222, 315, 22);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setBounds(293, 320, 113, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				viewTableDesenvolvedora voltar = new viewTableDesenvolvedora();
				voltar.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Consolas", Font.BOLD, 16));
		contentPane.add(btnNewButton);
		
		preencherCampos();
		JButton btnNewButton_1 = new JButton("Confirmar Altera\u00E7\u00F5es");
		btnNewButton_1.setBounds(418, 321, 212, 27);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que alterar as informações?","Alteração de Informações", JOptionPane.YES_NO_OPTION);
					
				if(resposta == JOptionPane.YES_OPTION){
					alterar();
					viewTableDesenvolvedora Tdes = new viewTableDesenvolvedora();
					Tdes.setVisible(true);
					dispose();
				}else if(resposta == JOptionPane.NO_OPTION){
					
				}		
			}
		});
		btnNewButton_1.setFont(new Font("Consolas", Font.BOLD, 15));
		contentPane.add(btnNewButton_1);
	}
	
	public void alterar() {
		
		DesenvolvedoraModel dsv = new DesenvolvedoraModel();
		
		int cod = Integer.parseInt(txtCod.getText());
		
		dsv.setCod(cod);
		dsv.setNome(txtNome.getText());
		
		DesenvolvedoraControl.getInstancia().alterarDesenvolvedora(dsv);
	}
	
	private void preencherCampos() {
		DesenvolvedoraControl dc = new DesenvolvedoraControl();
		DesenvolvedoraModel desenvolvedora = dc.DesenvolvedoraConsultar(codigo);
		
		txtCod.setText(Integer.toString(desenvolvedora.getCod()));
		txtNome.setText(desenvolvedora.getNome());
							
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewAlterarDesenvolvedora frame = new viewAlterarDesenvolvedora(codigo);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}}});
	}
}