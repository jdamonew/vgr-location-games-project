package ConexaoBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConectaBanco {

	public static Connection obterConexao() {
		Connection con = null;
		

		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String serverName = "127.0.0.1:1521";
		String meubanco = "XE";
		String url = "jdbc:oracle:thin:@" + serverName + "/" + meubanco;
		String user = "VGR";
		String password = "vgr";

		

			con = DriverManager.getConnection(url, user, password);
			System.out.println("Banco Conectado");

		} catch (SQLException ex) {
			System.out.println("Banco não conectado: " + ex);
			//JOptionPane.showMessageDialog(null, "PorFavor, conecte-se a internet.", "Erro de Conexão", JOptionPane.WARNING_MESSAGE);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public static void main(String[] args) {
		obterConexao();
		System.out.println();
	}

	



}
