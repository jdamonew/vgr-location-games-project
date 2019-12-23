package vgr.view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class viewDownload extends JFrame {

	private JPanel contentPane;
	URI link;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewDownload frame = new viewDownload();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}}});
	}

	
	public viewDownload() {
		setTitle("Aluguel Realizado - Download");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		setResizable(false);
		
		JLabel lblSeuDownloadEst = new JLabel("Aluguel realizado com sucesso!");
		lblSeuDownloadEst.setFont(new Font("Consolas", Font.BOLD, 25));
		lblSeuDownloadEst.setBounds(203, 31, 428, 30);
		contentPane.add(lblSeuDownloadEst);
		
		JButton btnVoltar = new JButton("Voltar ao Menu");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				viewCatalogo voltarCatalogo = new viewCatalogo("");
				voltarCatalogo.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(186, 304, 125, 25);
		contentPane.add(btnVoltar);
		
		JButton btnDown = new JButton("Fazer Download");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String link = "magnet:?xt=urn:btih:C95AE0681606389E9731CC5CE3C782FE33A3624E&dn="
						+ "Rust%20Experimental%20v2053%20DevBlog%20195%20x64%20#KnightsTable&tr="
						+ "http://share.camoe.cn:8080/announce&tr=udp://tracker.zer0day.to:1337/announce&tr="
						+ "udp://tracker.leechers-paradise.org:6969/announce&tr=udp://coppersurfer.tk:6969/announce";
				
				try {
					Desktop.getDesktop().browse(URI.create(link));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
			
	
		btnDown.setBounds(501, 304, 125, 25);
		contentPane.add(btnDown);
		
		JLabel lblDesejaFazerO = new JLabel("Deseja fazer o download do seu jogo agora?");
		lblDesejaFazerO.setFont(new Font("Consolas", Font.BOLD, 20));
		lblDesejaFazerO.setBounds(182, 231, 469, 16);
		contentPane.add(lblDesejaFazerO);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("Catalogo\\Rust_logo.png"));
		lblNewLabel.setBounds(242, 105, 350, 81);
		contentPane.add(lblNewLabel);
		
		JLabel lblDiasRestantes = new JLabel("Dias restantes: 40");
		lblDiasRestantes.setForeground(new Color(255, 0, 0));
		lblDiasRestantes.setFont(new Font("Consolas", Font.BOLD, 15));
		lblDiasRestantes.setBounds(336, 259, 153, 16);
		contentPane.add(lblDiasRestantes);
	}
}
