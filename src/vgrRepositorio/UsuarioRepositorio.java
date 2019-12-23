package vgrRepositorio;

import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConexaoBanco.ConectaBanco;
import vgr.model.UsuarioModel;

public class UsuarioRepositorio implements iUsuarioRepositorio {

	private static iUsuarioRepositorio instancia;

	public static java.sql.Statement stms;

	public static java.sql.PreparedStatement pstms;

	private ResultSet rs;

	protected ConectaBanco db;

	private void openDatabase() {
		// TODO Auto-generated method stub
		try {

			db = new ConectaBanco();
			db.getClass();

		} catch (Exception e) {
			// TODO: handle exception

		}
	}

	private UsuarioRepositorio() {
		openDatabase();
	}

	public static iUsuarioRepositorio getInstance() {

		if (instancia == null) {

			return instancia = new UsuarioRepositorio();

		}

		return instancia;
	}

	@Override
	public void cadastrarUsuario(UsuarioModel u) {
		try {

			String INsql = "INSERT INTO  USUARIO (NOME, ID, SENHA, EMAIL, DATA_NASC) VALUES " + "(?,?,?,?,?)";

			pstms = ConectaBanco.obterConexao().prepareStatement(INsql);

			pstms.setString(1, u.getNome());
			pstms.setString(2, u.getId());
			pstms.setString(3, u.getSenha());
			pstms.setString(4, u.getEmail());
			pstms.setString(5, u.getData_nasc());

			pstms.execute();

			if (pstms.getWarnings() == null) {

				JOptionPane.showMessageDialog(null, "Sua conta foi criada!");

			}

			pstms.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void alterarUsuario(UsuarioModel u, String id) {
		try {

			String sql = "UPDATE USUARIO SET NOME = '" + u.getNome() + "' WHERE ID = '" + id + "'";
			String sql2 = "UPDATE USUARIO SET SENHA = '" + u.getSenha() + "' WHERE ID = '" + id + "'";
			String sql3 = "UPDATE USUARIO SET EMAIL = '" + u.getEmail() + "' WHERE ID = '" + id + "'";
			String sql4 = "UPDATE USUARIO SET DATA_NASC = '" + u.getData_nasc() + "' WHERE ID = '" + id + "'";
			String sql5 = "UPDATE USUARIO SET ID = '" + u.getId() + "' WHERE ID = '" + id + "'";

			System.out.println(sql);
			stms = ConectaBanco.obterConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			int resultado = stms.executeUpdate(sql);
			resultado = stms.executeUpdate(sql2);
			resultado = stms.executeUpdate(sql3);
			resultado = stms.executeUpdate(sql4);
			resultado = stms.executeUpdate(sql5);

			JOptionPane.showMessageDialog(null, " Atualizado: " + resultado);

		} catch (Exception e) {
		}

	}

	@Override
	public ArrayList<UsuarioModel> consultarUsuario() {
		ArrayList<UsuarioModel> listUsuarioModel = null;

		try {

			listUsuarioModel = new ArrayList<UsuarioModel>();

			String sql = "SELECT * FROM USUARIO ORDER BY NOME";
			stms = ConectaBanco.obterConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = stms.executeQuery(sql);

			rs.first();

			/*
			 * Statement stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,
			 * ResultSet.CONCUR_UPDATABLE); ResultSet rs =
			 * stmt.executeQuery("SELECT a, b FROM TABLE2");
			 * 
			 */

			do {

				UsuarioModel usuario = new UsuarioModel();

				usuario.setNome(rs.getString("NOME"));
				usuario.setId(rs.getString("ID"));
				usuario.setSenha(rs.getString("SENHA"));
				usuario.setEmail(rs.getString("EMAIL"));
				usuario.setData_nasc(rs.getString("DATA_NASC"));

				listUsuarioModel.add(usuario);

			} while (rs.next());

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e);

		}

		return listUsuarioModel;
	}

	public UsuarioModel consultarUsuarioPorId(String id) {
		UsuarioModel usuario = new UsuarioModel();

		try {
			String sql = "SELECT * FROM USUARIO WHERE ID = '" + id + "'";
			stms = ConectaBanco.obterConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = stms.executeQuery(sql);

			rs.first();
			System.out.println(rs.getString("NOME"));

			do {
				usuario.setNome(rs.getString("NOME"));
				usuario.setId(rs.getString("ID"));
				usuario.setSenha(rs.getString("SENHA"));
				usuario.setEmail(rs.getString("EMAIL"));
				usuario.setData_nasc(rs.getString("DATA_NASC"));
			} while (rs.next());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e);
			System.out.println(e);

		}
		return usuario;
	}

	@Override
	public void deletarUsuario(String id) {

		try {
			String sql = "DELETE FROM USUARIO WHERE ID = ?";
			pstms = ConectaBanco.obterConexao().prepareStatement(sql);

			pstms.setString(1, id);

			int falha = pstms.executeUpdate();

			if (falha == 0) {
				JOptionPane.showMessageDialog(null, "Usuário não cadastrado " + falha);
			} else {
				JOptionPane.showMessageDialog(null, "Usuario deletado com sucesso! " + falha);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public UsuarioModel autenticaUsuario(String id) {
		UsuarioModel usuario = null;

		try {
			usuario = new UsuarioModel();

			String sql = "SELECT * FROM USUARIO WHERE ID = '" + id + "'";
			stms = ConectaBanco.obterConexao().createStatement();
			rs = stms.executeQuery(sql);

			while (rs.next()) {
				usuario.setNome(rs.getString("NOME"));
				usuario.setId(rs.getString("ID"));
				usuario.setSenha(rs.getString("SENHA"));
				usuario.setEmail(rs.getString("EMAIL"));
				usuario.setData_nasc(rs.getString("DATA_NASC"));
			}

			return usuario;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e);
			System.out.println(e);

		}
		return usuario;
	}

}
