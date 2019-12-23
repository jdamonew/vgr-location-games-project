package vgrRepositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ConexaoBanco.ConectaBanco;
import vgr.model.DesenvolvedoraModel;
import vgr.model.UsuarioModel;


public class DesenvolvedoraRepositorio implements iDesenvolvedoraRepositorio {
	
	private static iDesenvolvedoraRepositorio instancia;

	public static java.sql.Statement stms;

	public static java.sql.PreparedStatement pstms;

	private ResultSet rs;

	protected ConectaBanco db;
	
	private void openDatabase() {
				try {

					db = new ConectaBanco();
					db.getClass();

				} catch (Exception e) {

				}
	}
	
	private DesenvolvedoraRepositorio() {
		openDatabase();
	}
	

	public static iDesenvolvedoraRepositorio getInstance() {

		if (instancia == null) {

			return instancia = new DesenvolvedoraRepositorio();

		}

		return instancia;
	}
	
	
	
	

	@Override
	public void cadastrarDesenvolvedora(DesenvolvedoraModel d) {
		try {

			String INsql = "INSERT INTO DESENVOLVEDORA (NOME, CODIGO) VALUES (?,?)";

			pstms = ConectaBanco.obterConexao().prepareStatement(INsql);

			pstms.setString(1, d.getNome());
			pstms.setInt(2, d.getCod());

			pstms.execute();

			if (pstms.getWarnings() == null) {

				JOptionPane.showMessageDialog(null,"Desenvolvedora cadastrada!");

			}
			
			pstms.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterarDesenvolvedora(DesenvolvedoraModel d) {
		try {

			String sql = "UPDATE DESENVOLVEDORA SET NOME = '" + d.getNome() + "' WHERE CODIGO = '" + d.getCod() + "'";
			
			System.out.println(sql);
			stms = ConectaBanco.obterConexao().createStatement();

			int resultado = stms.executeUpdate(sql);

			JOptionPane.showMessageDialog(null, "Atualizado: " + resultado);

		} catch (Exception e) {
			System.out.println("ALGO ERRADO" + e);
		}
		
	}

	@Override
	public ArrayList<DesenvolvedoraModel> consultarDesenvolvedora() {
		ArrayList<DesenvolvedoraModel> listDesenvolvedoraModel = null;

		try {

			listDesenvolvedoraModel = new ArrayList<DesenvolvedoraModel>();

			String sql = "SELECT * FROM DESENVOLVEDORA";
			stms = ConectaBanco.obterConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = stms.executeQuery(sql);

			rs.first();

			do {

				DesenvolvedoraModel desenvolvedora = new DesenvolvedoraModel();
				desenvolvedora.setNome(rs.getString("NOME"));
				desenvolvedora.setCod(rs.getInt("CODIGO"));
				
				
				listDesenvolvedoraModel.add(desenvolvedora);

			} while (rs.next());

		} catch (Exception e) {
			System.out.println("Erro: " + e);

		}

		return listDesenvolvedoraModel;
	}
	
	public DesenvolvedoraModel DesenvolvedoraConsultar(int codigo) {
		
		DesenvolvedoraModel des = new DesenvolvedoraModel();
		
		try {
			String sql = "SELECT * FROM DESENVOLVEDORA WHERE CODIGO = '" + codigo + "'";
			stms = ConectaBanco.obterConexao().createStatement();
			rs = stms.executeQuery(sql);

			rs.first();
			System.out.println(rs.getString("NOME"));

			do {
				des.setNome(rs.getString("NOME"));
				des.setCod(rs.getInt("CODIGO"));
				
			} while (rs.next());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro: " + e);
			System.out.println(e);

		}
		return des;
		
	}

	@Override
	public void deletarDesenvolvedora(int codigo) {
		try {
			String sql = "DELETE FROM DESENVOLVEDORA WHERE CODIGO = ?";
			pstms = ConectaBanco.obterConexao().prepareStatement(sql);
			
			pstms.setInt(1, codigo);
			
			int falha = pstms.executeUpdate();

			if (falha == 0) {
				JOptionPane.showMessageDialog(null, "Desenvolvedora não cadastrada. " + falha);
			} else {
				JOptionPane.showMessageDialog(null, "Desenvolvedora deletada com sucesso! " + falha);
			}

			} catch (SQLException e) {
				e.printStackTrace();
		}


	}	

	
}
