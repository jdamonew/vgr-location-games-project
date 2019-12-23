package vgrRepositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ConexaoBanco.ConectaBanco;
import vgr.model.DesenvolvedoraModel;
import vgr.model.GameModel;

public class GameRepositorio implements iGameRepositorio {
	
	private static iGameRepositorio instancia;

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
	
	private GameRepositorio() {
		openDatabase();
	}
	
	public static iGameRepositorio getInstance() {

		if (instancia == null) {
			return instancia = new GameRepositorio();
		}
		return instancia;
	}
	
	

	@Override
	public void cadastrarGame(GameModel g) {
		try {

			String INsql = "INSERT INTO GAME(CODIGO, TITULO, DATA_LANCAMENTO, PRECO ) VALUES (?,?,?,?)";

			pstms = ConectaBanco.obterConexao().prepareStatement(INsql);

			pstms.setInt(1, g.getCod());
			pstms.setString(2, g.getTitulo());
			pstms.setString(3, g.getData_lancamento());
			pstms.setDouble(4, g.getPreco());
			

			pstms.execute();

			if (pstms.getWarnings() == null) {

				JOptionPane.showMessageDialog(null, "Game foi cadastrado com sucesso!");

			}
			
			pstms.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterarGame(GameModel g) {
		try {

			String sql = "UPDATE GAME SET TITULO = '" + g.getTitulo() + " 'WHERE CODIGO = " + g.getCod();
			String sql2 = "UPDATE GAME SET PRECO = '" + g.getPreco() + " 'WHERE CODIGO = " + g.getCod();
			String sql3 = "UPDATE GAME SET DATA_LANCAMENTO = '" + g.getData_lancamento() + " 'WHERE CODIGO = " + g.getCod();
			
			

			stms = ConectaBanco.obterConexao().createStatement();

			int resultado = stms.executeUpdate(sql);
			resultado = stms.executeUpdate(sql2);
			resultado = stms.executeUpdate(sql3);

			JOptionPane.showMessageDialog(null, "Atualizado: " + resultado);

		} catch (Exception e) {
	
		}
		
	}

	@Override
	public ArrayList<GameModel> consultarGame() {
		ArrayList<GameModel> listGameModel = null;

		try {

			listGameModel = new ArrayList<GameModel>();

			String sql = "SELECT * FROM GAME ABT ORDER BY CODIGO";
			stms = ConectaBanco.obterConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = stms.executeQuery(sql);

			rs.first();

			do {

				GameModel game = new GameModel();
				
				game.setCod(rs.getInt("CODIGO"));
				game.setTitulo(rs.getString("TITULO"));
				game.setPreco(rs.getDouble("PRECO"));
				game.setData_lancamento(rs.getString("DATA_LANCAMENTO"));
				
				
				
				listGameModel.add(game);

			} while (rs.next());

		} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"Erro: " + e);

		}

		return listGameModel;
	}

	public GameModel consultarGameCod(int codigo) {
			
			GameModel game = new GameModel();
			
			try {
				String sql = "SELECT * FROM GAME WHERE CODIGO = '" + codigo + "'";
				stms = ConectaBanco.obterConexao().createStatement();
				rs = stms.executeQuery(sql);
	
				rs.first();
				System.out.println(rs.getString("TITULO"));
	
				do {
					game.setTitulo(rs.getString("TITULO"));
					game.setCod(rs.getInt("CODIGO"));
					game.setPreco(rs.getDouble("PRECO"));
					game.setData_lancamento(rs.getString("DATA_LANCAMENTO"));
					
				} while (rs.next());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Erro: " + e);
				System.out.println(e);
	
			}
			return game;
			
	}
	
	
	
	@Override
	public void deletarGame(int codigo) {
		try {
			String sql = "DELETE FROM GAME WHERE CODIGO = ?";
			
			pstms = ConectaBanco.obterConexao().prepareStatement(sql);
			
			pstms.setInt(1, codigo);
			
			int falha = pstms.executeUpdate();

			if (falha == 0) {
				JOptionPane.showMessageDialog(null, "Game não cadastrado " + falha);
			} else {
				JOptionPane.showMessageDialog(null, "Game deletado com sucesso! " + falha);
			}

			} catch (SQLException e) {
				e.printStackTrace();
		}


	}
		

}
