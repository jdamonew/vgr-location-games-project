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

import vgr.controller.GameControl;
import vgr.model.GameModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;



public class viewTableGame extends JFrame {

	private JPanel contentPane;
	private JTable jtableGame;
	private JTextField txtCodigo;
	private JTextField txtTitulo;
	private JTextField txtPreco;
	private JTextField txtData;
	private ArrayList<GameModel> listaGame;
	
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

	
	public void inserirTabela(JTable table, ArrayList<GameModel> game) 
	{
		DefaultTableModel dtmc = new DefaultTableModel();
		jtableGame.getTableHeader().setReorderingAllowed(false);
				
		
		dtmc.addColumn("Código");
		dtmc.addColumn("Título");
		dtmc.addColumn("Preço");
		dtmc.addColumn("Data de Lançamento");
		
		for(int i = 0, len = game.size(); i < len; i++) {
			String[] linha = new String[4];
			
			linha[0] = Integer.toString(game.get(i).getCod());
			linha[1] = game.get(i).getTitulo();
			linha[2] = Double.toString(game.get(i).getPreco()) + " reais";
			linha[3] = game.get(i).getData_lancamento();
			
			dtmc.addRow( linha );
		}
		
		table.setModel(dtmc);
	}
	
	
	public viewTableGame() {
		setTitle("Game - Vis\u00E3o Geral");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		GameControl gc = new GameControl();
		jtableGame = new JTable();
		listaGame = gc.consultarGame();
		
		inserirTabela(jtableGame, listaGame);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(132, 244, 690, 249);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(jtableGame);
		
		//USUARIO NÃO PODE REDEREZAR A JANELA
		setResizable(false);
		//JANELA CENTRALIZADA
		setLocationRelativeTo(null);
		
		
		JButton bttAlterar = new JButton("Alterar");
		bttAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int codigo = 0;
				for(int i = 0, len = jtableGame.getSelectedRowCount(); i < len; i++)
					codigo = Integer.parseInt(jtableGame.getValueAt(jtableGame.getSelectedRows()[i], 0).toString());

					viewAlterarGame tgame = new viewAlterarGame(codigo);
					tgame.setVisible(true);
					dispose();
			}
		});
		bttAlterar.setBounds(22, 192, 98, 26);
		contentPane.add(bttAlterar);
		
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String titulo = txtTitulo.getText();
				String preco = txtPreco.getText();
				String data = txtData.getText();
			
				if(titulo.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Porfavor, insira um Titulo válido.", "Título vazio", JOptionPane.WARNING_MESSAGE);
					
				}else if(preco.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Porfavor, insira uma valor válido.", "Preço vazio", JOptionPane.WARNING_MESSAGE);

				}else if(data.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Porfavor, insira uma data válida.", "Data de Nascimento vazia", JOptionPane.WARNING_MESSAGE);
		
				}else {
					cadastrarGame();
					listaGame = gc.consultarGame();
					inserirTabela(jtableGame, listaGame);
				}
				
			}
		});
		btnNewButton_1.setBounds(22, 87, 98, 26);
		contentPane.add(btnNewButton_1);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				viewGerencia voltaGerencia = new viewGerencia();
				voltaGerencia.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(22, 453, 98, 26);
		contentPane.add(btnVoltar);
		
		JButton bttDeletar = new JButton("Deletar");
		bttDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int codigo = 0;
				for(int i = 0, len = jtableGame.getSelectedRowCount(); i < len; i++) {
					try {
						codigo = Integer.parseInt(jtableGame.getValueAt(jtableGame.getSelectedRows()[i], 0).toString());
						
					}catch (Exception e) {
						System.out.println("Erro, isso não é um número");
					}

					gc.deletarGame(codigo); 
				}
	
				listaGame = gc.consultarGame();
				inserirTabela(jtableGame, listaGame);
		
			}
		});
		bttDeletar.setBounds(22, 142, 98, 26);
		contentPane.add(bttDeletar);
		
		JLabel lblNewLabel = new JLabel("Games - Vis\u00E3o Geral");
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNewLabel.setBounds(308, 12, 218, 26);
		contentPane.add(lblNewLabel);
		
		
		JLabel lblNomeCompleto = new JLabel("C\u00F3digo");
		lblNomeCompleto.setFont(new Font("Consolas", Font.BOLD, 16));
		lblNomeCompleto.setBounds(166, 91, 63, 20);
		contentPane.add(lblNomeCompleto);
		
		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.setBounds(241, 90, 183, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblId = new JLabel("T\u00EDtulo");
		lblId.setFont(new Font("Consolas", Font.BOLD, 16));
		lblId.setBounds(166, 148, 63, 16);
		contentPane.add(lblId);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(241, 145, 183, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblSenha = new JLabel("Pre\u00E7o");
		lblSenha.setFont(new Font("Consolas", Font.BOLD, 16));
		lblSenha.setBounds(471, 93, 55, 16);
		contentPane.add(lblSenha);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(538, 90, 183, 20);
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Lan\u00E7amento");
		lblDataDeNascimento.setFont(new Font("Consolas", Font.BOLD, 16));
		lblDataDeNascimento.setBounds(471, 148, 170, 16);
		contentPane.add(lblDataDeNascimento);
		
		txtData = new JTextField();
		txtData.setBounds(653, 145, 159, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
	}

	private void cadastrarGame() {
		
		GameModel game = new GameModel();
		double preco = Double.parseDouble(txtPreco.getText());
				
		game.setTitulo(txtTitulo.getText());
		game.setPreco(preco);
		game.setData_lancamento(txtData.getText());
		
		
		GameControl.getInstancia().cadastrarGame(game);
		
	}
}
