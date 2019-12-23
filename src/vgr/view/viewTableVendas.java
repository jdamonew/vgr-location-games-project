package vgr.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import ConexaoBanco.ConectaBanco;
import vgr.controller.VendaControl;
import vgr.model.VendaModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.sql.ResultSet;


public class viewTableVendas extends JFrame {

	private JPanel contentPane;
	private JTable jtableVenda;
	private ArrayList<VendaModel> listaVenda;
	ConectaBanco con = new ConectaBanco();
	ResultSet rs;
	
	
	
	public void inserirTabela(JTable table, ArrayList<VendaModel> venda) 
	{
		DefaultTableModel dtmc = new DefaultTableModel();
		jtableVenda.getTableHeader().setReorderingAllowed(false);
				
		
		dtmc.addColumn("Número");
		dtmc.addColumn("Data da Compra");
		dtmc.addColumn("Hora da Compra");
		dtmc.addColumn("Descrição");
		
		
		for(int i = 0, len = venda.size(); i < len; i++) {
			String[] linha = new String[4];
			
			linha[0] = Integer.toString(venda.get(i).getNumero());
			linha[1] = venda.get(i).getData();
			linha[2] = venda.get(i).getHora();
			linha[3] = venda.get(i).getDescricao();
			dtmc.addRow( linha );
		}
		
		table.setModel(dtmc);
	}

	public viewTableVendas() {
		setTitle("Vendas - Vis\u00E3o Geral");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		VendaControl vc = new VendaControl();
		jtableVenda = new JTable();
		listaVenda = vc.consultarVenda();
		
		inserirTabela(jtableVenda, listaVenda);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 186, 810, 306);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(jtableVenda);
		
		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewGerencia voltaGerencia = new viewGerencia();
				voltaGerencia.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(12, 34, 98, 26);
		contentPane.add(btnNewButton_2);
		
		JButton bttDeletar = new JButton("Deletar");
		bttDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int codigo = 0;
				for(int i = 0, len = jtableVenda.getSelectedRowCount(); i < len; i++) {
					try {
						codigo = Integer.parseInt(jtableVenda.getValueAt(jtableVenda.getSelectedRows()[i], 0).toString());
						
					}catch (Exception e1) {
						System.out.println("Erro, isso não é um número");
					}

					vc.deletarVenda(codigo); 
				}
	
				listaVenda = vc.consultarVenda();
				inserirTabela(jtableVenda, listaVenda);				
			}
		});
		bttDeletar.setBounds(12, 112, 98, 26);
		contentPane.add(bttDeletar);
		
		JLabel lblNewLabel = new JLabel("Vendas - Vis\u00E3o Geral");
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 16));
		lblNewLabel.setBounds(309, 35, 215, 26);
		contentPane.add(lblNewLabel);
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
