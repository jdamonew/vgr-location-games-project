package vgr.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vgr.controller.DlcControl;
import vgr.controller.GameControl;
import vgr.model.DlcModel;
import vgr.model.GameModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class viewAlterarDlc extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitu;
	private JTextField txtCod;
	private JTextField txtCodGame;
	private JTextField txtPreco;
	private static int codigo;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewAlterarDlc frame = new viewAlterarDlc(codigo);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public viewAlterarDlc(int codigo) {
		this.codigo = codigo;
		
		setTitle("Alterar Informa\u00E7\u00F5es - DLC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Alterar Informa\u00E7\u00F5es");
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 25));
		lblNewLabel.setBounds(12, 43, 293, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblSubTitu = new JLabel("Sub T\u00EDtulo");
		lblSubTitu.setFont(new Font("Consolas", Font.BOLD, 16));
		lblSubTitu.setBounds(12, 126, 99, 16);
		contentPane.add(lblSubTitu);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setFont(new Font("Consolas", Font.BOLD, 16));
		lblCodigo.setBounds(12, 190, 99, 16);
		contentPane.add(lblCodigo);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o");
		lblPreco.setFont(new Font("Consolas", Font.BOLD, 16));
		lblPreco.setBounds(12, 258, 99, 16);
		contentPane.add(lblPreco);
		
		JLabel lblCdigoGame = new JLabel("C\u00F3digo Game");
		lblCdigoGame.setFont(new Font("Consolas", Font.BOLD, 16));
		lblCdigoGame.setBounds(327, 190, 116, 16);
		contentPane.add(lblCdigoGame);
		
		txtTitu = new JTextField();
		txtTitu.setBounds(12, 155, 218, 22);
		contentPane.add(txtTitu);
		txtTitu.setColumns(10);
		
		txtCod = new JTextField();
		txtCod.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtCod.setEnabled(false);
		txtCod.setBounds(12, 223, 218, 22);
		contentPane.add(txtCod);
		txtCod.setColumns(10);
		
		txtCodGame = new JTextField();
		txtCodGame.setBounds(327, 223, 218, 22);
		contentPane.add(txtCodGame);
		txtCodGame.setColumns(10);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(12, 287, 218, 22);
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				viewTableDlc voltarDlc = new viewTableDlc();
				voltarDlc.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Consolas", Font.BOLD, 16));
		btnVoltar.setBounds(281, 393, 124, 25);
		contentPane.add(btnVoltar);
		
		preencherCampos();
		
		JButton btnConfirmar = new JButton("Confirmar Altera\u00E7\u00F5es");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que alterar as informações?","Alteração de Informações", JOptionPane.YES_NO_OPTION);
				
				if(resposta == JOptionPane.YES_OPTION){
					alterar();
					viewTableDlc voltarDlc = new viewTableDlc();
					voltarDlc.setVisible(true);
					dispose();;
				}else if(resposta == JOptionPane.NO_OPTION){
					
				}	
			}
		});
		btnConfirmar.setFont(new Font("Consolas", Font.BOLD, 15));
		btnConfirmar.setBounds(417, 393, 207, 25);
		contentPane.add(btnConfirmar);
	}
	
	public void alterar() {
		
		DlcModel dlc = new DlcModel();
		
		int cod = Integer.parseInt(txtCod.getText());
		int cod_game = Integer.parseInt(txtCodGame.getText());
		int preco = Integer.parseInt(txtPreco.getText());
		
		dlc.setCodd(cod);
		dlc.setCod(cod_game);
		dlc.setSub_titulo(txtTitu.getText());
		dlc.setPrecoDlc(preco);
		
		DlcControl.getInstancia().alterarDlc(dlc);
		
	}
	
	public void preencherCampos() {
		
		DlcControl dc = new DlcControl();
		DlcModel dlc = dc.DlcConsutarCod(codigo);
		
		txtCod.setText(Integer.toString(dlc.getCodd()));
		txtTitu.setText(dlc.getSub_titulo());
		txtPreco.setText(Integer.toString(dlc.getPrecoDlc()));
		txtCodGame.setText(Integer.toString(dlc.getCod()));
	}
}
