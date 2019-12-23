package vgr.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vgr.controller.GameControl;
import vgr.model.GameModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class viewAlterarGame extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtCod;
	private JTextField txtPreco;
	private JTextField txtData;
	private static int codigo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewAlterarGame frame = new viewAlterarGame(codigo);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public viewAlterarGame(int codigo) {
		this.codigo = codigo;
		setTitle("Alterar Informa\u00E7\u00F5es - Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JLabel lblAlterarInformaes = new JLabel("Alterar Informa\u00E7\u00F5es");
		lblAlterarInformaes.setFont(new Font("Consolas", Font.BOLD, 25));
		lblAlterarInformaes.setBounds(12, 44, 272, 23);
		contentPane.add(lblAlterarInformaes);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo");
		lblTtulo.setFont(new Font("Consolas", Font.BOLD, 16));
		lblTtulo.setBounds(12, 194, 156, 16);
		contentPane.add(lblTtulo);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setFont(new Font("Consolas", Font.BOLD, 16));
		lblCdigo.setBounds(12, 130, 156, 16);
		contentPane.add(lblCdigo);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setFont(new Font("Consolas", Font.BOLD, 16));
		lblPreo.setBounds(12, 258, 156, 16);
		contentPane.add(lblPreo);
		
		JLabel lblDataDeLanamento = new JLabel("Data de Lan\u00E7amento");
		lblDataDeLanamento.setFont(new Font("Consolas", Font.BOLD, 16));
		lblDataDeLanamento.setBounds(12, 322, 187, 16);
		contentPane.add(lblDataDeLanamento);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(12, 223, 214, 22);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtCod = new JTextField();
		txtCod.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtCod.setEnabled(false);
		txtCod.setBounds(12, 159, 214, 22);
		contentPane.add(txtCod);
		txtCod.setColumns(10);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(12, 287, 214, 22);
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);
		
		txtData = new JTextField();
		txtData.setBounds(12, 351, 214, 22);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewTableGame tgame = new viewTableGame();
				tgame.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Consolas", Font.BOLD, 16));
		btnVoltar.setBounds(278, 409, 134, 25);
		contentPane.add(btnVoltar);
		
		preencherCampos();
		
		JButton btnConfirmar = new JButton("Confirmar Altera\u00E7\u00F5es");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que alterar as informações?","Alteração de Informações", JOptionPane.YES_NO_OPTION);
				
				if(resposta == JOptionPane.YES_OPTION){
					alterar();
					viewTableGame voltar = new viewTableGame();
					voltar.setVisible(true);
					dispose();
				}else if(resposta == JOptionPane.NO_OPTION){
					
				}	
				
			}
		});
		btnConfirmar.setFont(new Font("Consolas", Font.BOLD, 15));
		btnConfirmar.setBounds(425, 409, 199, 25);
		contentPane.add(btnConfirmar);
	}
	
	public void alterar() {
		
		GameModel game = new GameModel();
		
		double preco = Double.parseDouble(txtPreco.getText());
		int cod = Integer.parseInt(txtCod.getText());
		
		game.setCod(cod);
		game.setTitulo(txtTitulo.getText());
		game.setPreco(preco);
		game.setData_lancamento(txtData.getText());
		
		GameControl.getInstancia().alterarGame(game);
	}
	
	public void preencherCampos() {
		GameControl gc = new GameControl();
		GameModel game = gc.consultarGameCod(codigo);
		
		txtCod.setText(Integer.toString(game.getCod()));
		txtTitulo.setText(game.getTitulo());
		txtPreco.setText(Double.toString(game.getPreco()));
		txtData.setText(game.getData_lancamento());
	}

}
