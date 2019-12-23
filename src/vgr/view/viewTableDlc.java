package vgr.view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import vgr.controller.DlcControl;
import vgr.model.DlcModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;


public class viewTableDlc extends JFrame {

	private JPanel contentPane;
	private JTable jtableDlc;
	private JTextField txtCod;
	private JTextField txtCodGame;
	private JTextField txtNome;
	private JTextField txtPreco;
	private ArrayList<DlcModel> listaDlc;


	public void inserirTabela(JTable table, ArrayList<DlcModel> dlc) 
	{
		DefaultTableModel dtmc = new DefaultTableModel();
		jtableDlc.getTableHeader().setReorderingAllowed(false);
				
		
		dtmc.addColumn("Código");
		dtmc.addColumn("Sub Título");
		dtmc.addColumn("Preço");
		dtmc.addColumn("Nome Game");
		dtmc.addColumn("Código Game");
		
		for(int i = 0, len = dlc.size(); i < len; i++) {
			String[] linha = new String[5];
			
			linha[0] = Integer.toString(dlc.get(i).getCodd());
			linha[1] = dlc.get(i).getSub_titulo();
			linha[2] = Integer.toString(dlc.get(i).getPrecoDlc()) + " reais";
			linha[3] = dlc.get(i).getTitulo();
			linha[4] = Integer.toString(dlc.get(i).getCod());
			
			dtmc.addRow( linha );
		}
		
		table.setModel(dtmc);
	}
	
	
	
	public viewTableDlc() {
		setTitle("Desenvolvedora - Vis\u00E3o Geral");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		DlcControl dcc = new DlcControl();
		jtableDlc = new JTable();
		listaDlc = dcc.consultarDlc();
		inserirTabela(jtableDlc, listaDlc);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 232, 799, 249);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(jtableDlc);
		
		JButton bttAlterar = new JButton("Alterar");
		bttAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int codigo = 0;
				for(int i = 0, len = jtableDlc.getSelectedRowCount(); i < len; i++)
					codigo = Integer.parseInt(jtableDlc.getValueAt(jtableDlc.getSelectedRows()[i], 0).toString());

					viewAlterarDlc tdlc = new viewAlterarDlc(codigo);
					tdlc.setVisible(true);
					dispose();
				
			}
		});
		bttAlterar.setBounds(12, 156, 98, 26);
		contentPane.add(bttAlterar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String cod = txtCod.getText();
				String cod_game = txtCodGame.getText();
				String titulo = txtNome.getText();
				String preco = txtPreco.getText();
				
				if(cod.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O Campo está vazio.", "Código Vazio", JOptionPane.WARNING_MESSAGE);
				}else if(cod_game.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O Campo está vazio.", "Código de Game Vazio", JOptionPane.WARNING_MESSAGE);
				}else if(titulo.isEmpty()){
					JOptionPane.showMessageDialog(null, "O Campo está vazio.", "Título Vazio", JOptionPane.WARNING_MESSAGE);
				}else if(preco.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O Campo está vazio.", "Preço Vazio", JOptionPane.WARNING_MESSAGE);
				}else {
					cadastrarDlc();
					listaDlc = dcc.consultarDlc();
					inserirTabela(jtableDlc, listaDlc);
					
				}
				
				
			}
		});
		btnCadastrar.setBounds(12, 78, 98, 26);
		contentPane.add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewGerencia voltaGerencia = new viewGerencia();
				voltaGerencia.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(12, 35, 98, 26);
		contentPane.add(btnVoltar);
		
		JButton bttDeletar = new JButton("Deletar");
		bttDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int codigo = 0;
				for(int i = 0, len = jtableDlc.getSelectedRowCount(); i < len; i++) {
					try {
						codigo = Integer.parseInt(jtableDlc.getValueAt(jtableDlc.getSelectedRows()[i], 0).toString());
						
					}catch (Exception e1) {
						System.out.println("Erro, isso não é um número");
					}

					dcc.deletarDlc(codigo); 
				}
	
				listaDlc = dcc.consultarDlc();
				inserirTabela(jtableDlc, listaDlc);
				
				
				
			}
		});
		bttDeletar.setBounds(12, 117, 98, 26);
		contentPane.add(bttDeletar);
		
		JLabel lblNewLabel = new JLabel("DLCs - Vis\u00E3o Geral");
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNewLabel.setBounds(313, 35, 208, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblCod = new JLabel("C\u00F3digo");
		lblCod.setFont(new Font("Consolas", Font.BOLD, 16));
		lblCod.setBounds(180, 97, 63, 16);
		contentPane.add(lblCod);
		
		JLabel lblCodGame = new JLabel("C\u00F3digo do Game");
		lblCodGame.setFont(new Font("Consolas", Font.BOLD, 16));
		lblCodGame.setBounds(180, 162, 133, 16);
		contentPane.add(lblCodGame);
		
		JLabel lblNome = new JLabel("Sub T\u00EDtulo");
		lblNome.setFont(new Font("Consolas", Font.BOLD, 16));
		lblNome.setBounds(462, 97, 98, 16);
		contentPane.add(lblNome);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o");
		lblPreco.setFont(new Font("Consolas", Font.BOLD, 16));
		lblPreco.setBounds(462, 162, 56, 16);
		contentPane.add(lblPreco);
		
		txtCod = new JTextField();
		txtCod.setBounds(250, 93, 180, 22);
		contentPane.add(txtCod);
		txtCod.setColumns(10);
		
		txtCodGame = new JTextField();
		txtCodGame.setBounds(314, 158, 116, 22);
		contentPane.add(txtCodGame);
		txtCodGame.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(572, 93, 201, 22);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(530, 156, 243, 22);
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);
	
	}
	
	public void cadastrarDlc() {
		
		DlcModel dlc = new DlcModel();
		
		int cod = Integer.parseInt(txtCod.getText());
		int cod_game = Integer.parseInt(txtCodGame.getText());
		int preco = Integer.parseInt(txtPreco.getText());
		
		dlc.setCodd(cod);
		dlc.setCod(cod_game);
		dlc.setSub_titulo(txtNome.getText());
		dlc.setPrecoDlc(preco);
		
		DlcControl.getInstancia().cadastrarDlc(dlc);
				
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewTableUsuario frame = new viewTableUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
