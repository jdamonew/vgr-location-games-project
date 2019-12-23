package vgr.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vgr.controller.VendaControl;
import vgr.model.VendaModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class viewVenda extends JFrame {

	private JPanel contentPane;
	
	

	public viewVenda() {
		setTitle("VGR - Venda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblRust = new JLabel("New label");
		lblRust.setIcon(new ImageIcon("Catalogo\\Rust_logo.png"));
		lblRust.setBounds(12, 53, 360, 98);
		contentPane.add(lblRust);
		
		JLabel lblValorDaCompra = new JLabel("Valor do Aluguel: ");
		lblValorDaCompra.setFont(new Font("Consolas", Font.BOLD, 20));
		lblValorDaCompra.setBounds(388, 230, 204, 24);
		contentPane.add(lblValorDaCompra);
		
		JLabel lblR = new JLabel("R$ 30,00");
		lblR.setFont(new Font("Consolas", Font.BOLD, 22));
		lblR.setBounds(639, 229, 101, 24);
		contentPane.add(lblR);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewGameRust voltaGame = new viewGameRust();
				voltaGame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Consolas", Font.BOLD, 16));
		btnNewButton.setBounds(147, 406, 190, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblCarrinhoDeCompras = new JLabel("Carrinho de Produtos");
		lblCarrinhoDeCompras.setFont(new Font("Consolas", Font.BOLD, 30));
		lblCarrinhoDeCompras.setBounds(432, 53, 347, 57);
		contentPane.add(lblCarrinhoDeCompras);
		
		JButton btnConfirmarCompra = new JButton("Confirmar Aluguel");
		btnConfirmarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resposta = JOptionPane.showConfirmDialog(null, "ATENÇÃO: Após confirmar o aluguel você terá 40 DIAS para utilizar o download. \nDeseja confirmar o aluguel?","Confirmação de Aluguel", JOptionPane.YES_NO_OPTION);
				
				if(resposta == JOptionPane.YES_OPTION){
					vendaItem();
					viewDownload download = new viewDownload();
					download.setVisible(true);
					dispose();
				}else if(resposta == JOptionPane.NO_OPTION){
					
				}	
			}
		});
		btnConfirmarCompra.setFont(new Font("Consolas", Font.BOLD, 16));
		btnConfirmarCompra.setBounds(484, 406, 190, 25);
		contentPane.add(btnConfirmarCompra);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setFont(new Font("Consolas", Font.BOLD, 16));
		lblDescrio.setBounds(12, 220, 101, 16);
		contentPane.add(lblDescrio);
		
		JLabel lblRustTheSurvivel = new JLabel("Rust The Survivel Games");
		lblRustTheSurvivel.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblRustTheSurvivel.setBounds(12, 256, 196, 16);
		contentPane.add(lblRustTheSurvivel);
		
		JLabel lblDias = new JLabel("40 Dias");
		lblDias.setForeground(new Color(255, 51, 0));
		lblDias.setFont(new Font("Consolas", Font.BOLD, 16));
		lblDias.setBounds(649, 266, 83, 16);
		contentPane.add(lblDias);
		
		
	}

	public void vendaItem() {
		
		VendaModel venda = new VendaModel();
		
		Date data = new Date();
		
		SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/y");
		SimpleDateFormat formatarHora = new SimpleDateFormat(" hh:m:s");
		
		String dataform = formatarData.format(data);
		String horaform = formatarHora.format(data);

		venda.setDescricao("Rust The Survivel Game");
		venda.setData(dataform);
		venda.setHora(horaform);
		
		VendaControl.getInstancia().cadastrarVenda(venda);
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewVenda frame = new viewVenda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
