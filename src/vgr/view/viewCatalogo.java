package vgr.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

public class viewCatalogo extends JFrame {

	private static String id;
	
	public viewCatalogo(String id) {
		this.id = id;
		setTitle("VGR - Menu Inicial");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 650);
		getContentPane().setLayout(null);
		setResizable(false);	
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(12, 90, 808, 501);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblMenuInicial = new JLabel("Menu Inicial");
		lblMenuInicial.setFont(new Font("Consolas", Font.BOLD, 25));
		lblMenuInicial.setBounds(335, 23, 173, 46);
		getContentPane().add(lblMenuInicial);
		
		JLabel CupHeadIcon = new JLabel();
		CupHeadIcon.setToolTipText("Stardew Valley");
		CupHeadIcon.setIcon(new ImageIcon("Catalogo\\StardewValley.jpg"));
		CupHeadIcon.setBounds(40, 13, 300, 145);
		panel.add(CupHeadIcon);
		
		JLabel RustIcon = new JLabel();
		RustIcon.setToolTipText("Rust");
		RustIcon.setIcon(new ImageIcon("Catalogo\\Rust.jpg"));
		RustIcon.setBounds(471, 13, 300, 145);
		panel.add(RustIcon);
		
		JLabel WatchDogIcon = new JLabel();
		WatchDogIcon.setToolTipText("Watch_Dogs 2");
		WatchDogIcon.setIcon(new ImageIcon("Catalogo\\WatchDogs2.jpg"));
		WatchDogIcon.setBounds(40, 255, 300, 145);
		panel.add(WatchDogIcon);
		
		JLabel FarCryIcon = new JLabel();
		FarCryIcon.setToolTipText("Far Cry 5");
		FarCryIcon.setIcon(new ImageIcon("Catalogo\\FarCry.jpg"));
		FarCryIcon.setBounds(471, 255, 300, 145);
		panel.add(FarCryIcon);
		
		JLabel lblCuphead = new JLabel("Stardew Valley");
		lblCuphead.setFont(new Font("Consolas", Font.BOLD, 20));
		lblCuphead.setBounds(40, 171, 154, 16);
		panel.add(lblCuphead);
		
		JLabel lblRust = new JLabel("Rust");
		lblRust.setFont(new Font("Consolas", Font.BOLD, 20));
		lblRust.setBounds(471, 171, 56, 16);
		panel.add(lblRust);
		
		JLabel lblNewLabel_3 = new JLabel("Watch_Dogs 2");
		lblNewLabel_3.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNewLabel_3.setBounds(40, 413, 143, 16);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Far Cry 5");
		lblNewLabel_5.setFont(new Font("Consolas", Font.BOLD, 20));
		lblNewLabel_5.setBounds(471, 413, 114, 16);
		panel.add(lblNewLabel_5);
		
		JLabel Valor01 = new JLabel("R$ 30,00");
		Valor01.setFont(new Font("Consolas", Font.BOLD, 16));
		Valor01.setBounds(471, 200, 72, 16);
		panel.add(Valor01);
		
		JLabel Valor02 = new JLabel("R$ 10,00");
		Valor02.setFont(new Font("Consolas", Font.BOLD, 16));
		Valor02.setBounds(40, 200, 72, 16);
		panel.add(Valor02);
		
		JLabel Valor03 = new JLabel("R$ 60,00");
		Valor03.setFont(new Font("Consolas", Font.BOLD, 16));
		Valor03.setBounds(40, 448, 89, 16);
		panel.add(Valor03);
		
		JLabel Valor04 = new JLabel("R$ 50,00");
		Valor04.setFont(new Font("Consolas", Font.BOLD, 16));
		Valor04.setBounds(471, 448, 72, 16);
		panel.add(Valor04);
		
		JLabel lblDesconto= new JLabel("Economize 50%");
		lblDesconto.setEnabled(false);
		lblDesconto.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblDesconto.setBounds(525, 171, 97, 16);
		panel.add(lblDesconto);
		
		JButton alugue = new JButton("Alugue J\u00E1");
		alugue.setEnabled(false);
		alugue.setToolTipText("Alugue J\u00E1");
		alugue.setBounds(242, 179, 97, 25);
		panel.add(alugue);
		
		JButton alugue1 = new JButton(" Alugue J\u00E1");
		alugue1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				viewGameRust rust = new viewGameRust();
				rust.setVisible(true);
				dispose();
			}
		});
		alugue1.setToolTipText("Alugue J\u00E1");
		alugue1.setBounds(674, 179, 97, 25);
		panel.add(alugue1);
		
		JButton alugue2 = new JButton("Alugue J\u00E1");
		alugue2.setEnabled(false);
		alugue2.setToolTipText("Alugue J\u00E1");
		alugue2.setBounds(242, 423, 97, 25);
		panel.add(alugue2); 
		
		JButton alugue3 = new JButton("Alugue J\u00E1");
		alugue3.setEnabled(false);
		alugue3.setToolTipText("Alugue J\u00E1");
		alugue3.setBounds(674, 423, 97, 25);
		panel.add(alugue3);
		
		JLabel lblUserLog = new JLabel("Bem Vindo(a), "+ id);
		lblUserLog.setFont(new Font("Consolas", Font.BOLD, 16));
		lblUserLog.setBounds(573, 32, 247, 31);
		getContentPane().add(lblUserLog);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja fazer LogOut?","Sair do Sistema", JOptionPane.YES_NO_OPTION);
				
				if(resposta == JOptionPane.YES_OPTION){
					viewLogin sair = new viewLogin();
					sair.setVisible(true);
					dispose();
				}else if(resposta == JOptionPane.NO_OPTION){

				}	
				
				
				
			}
		});
		btnSair.setFont(new Font("Consolas", Font.BOLD, 16));
		btnSair.setBounds(30, 35, 97, 25);
		getContentPane().add(btnSair);
		
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewCatalogo frame = new viewCatalogo(id);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();}}});
	}
}
