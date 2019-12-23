package vgrRepositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ConexaoBanco.ConectaBanco;
import vgr.model.DlcModel;

public class DlcRepositorio implements iDlcRepositorio {
	
	private static iDlcRepositorio instancia;

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
	
	private DlcRepositorio() {
		openDatabase();
	}
	

	public static iDlcRepositorio getInstance() {

		if (instancia == null) {

			return instancia = new DlcRepositorio();

		}

		return instancia;
	}

	@Override
	public void cadastrarDlc(DlcModel l) {
		try {

			String INsql = "INSERT INTO DLC (CODIGO, COD_GAME, SUB_TITULO, PRECO, NOME_GAME ) VALUES (?,?,?,?,?)";

			pstms = ConectaBanco.obterConexao().prepareStatement(INsql);

			pstms.setInt(1, l.getCodd());
			pstms.setInt(2, l.getCod());
			pstms.setString(3, l.getSub_titulo());
			pstms.setInt(4, l.getPrecoDlc());
			pstms.setString(5, l.getTitulo());
			

			pstms.execute();

			if (pstms.getWarnings() == null) {

				JOptionPane.showMessageDialog(null, "DLC Cadastrada com sucesso!");

			}
			
			pstms.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
		
	}

	@Override
	public void alterarDlc(DlcModel l) {
		try {
			
			String sql = "UPDATE DLC SET SUB_TITULO = '" + l.getSub_titulo() + "' WHERE CODIGO = '" + l.getCodd()+ "'";
			String sql2 = "UPDATE DLC SET PRECO = '" + l.getPrecoDlc() + "' WHERE CODIGO = '" + l.getCodd()+ "'";
			String sql3 = "UPDATE DLC SET COD_GAME = '" + l.getCod() + "' WHERE CODIGO = '" + l.getCodd()+ "'";
			String sql4 = "UPDATE DLC SET CODIGO = '" + l.getCodd() + "' WHERE CODIGO = '" + l.getCodd()+ "'";

			stms = ConectaBanco.obterConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			int resultado = stms.executeUpdate(sql);
			resultado = stms.executeUpdate(sql2);
			resultado = stms.executeUpdate(sql3);
			resultado = stms.executeUpdate(sql4);

			JOptionPane.showMessageDialog(null, " Atualizado: " + resultado);

		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public ArrayList<DlcModel> consultarDlc() {
		ArrayList<DlcModel> listDlcModel = null;

		try {

			listDlcModel = new ArrayList<DlcModel>();

			String sql = "SELECT DLC.CODIGO, DLC.SUB_TITULO, DLC.PRECO, GAME.CODIGO, GAME.TITULO FROM DLC, GAME 9WHERE DLC.COD_GAME = GAME.CODIGO";
			stms = ConectaBanco.obterConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = stms.executeQuery(sql);

			rs.first();

			do {

				DlcModel dlc = new DlcModel();
				dlc.setCodd(rs.getInt("DLC.CODIGO"));
				dlc.setSub_titulo(rs.getString("DLC.SUB_TITULO"));
				dlc.setPrecoDlc(rs.getInt("DLC.PRECO"));
				dlc.setCod(rs.getInt("GAME.CODIGO"));
				dlc.setTitulo(rs.getString("GAME.TITULO"));
				
				listDlcModel.add(dlc);

			} while (rs.next());

		} catch (Exception e) {
			System.out.println("Erro: " + e);

		}

		return listDlcModel;
	}
	
	public DlcModel DlcConsutarCod (int codigo) {
			
			DlcModel dlc = new DlcModel();
			
			try {
				String sql = "SELECT * FROM DLC WHERE CODIGO = '" + codigo + "'";
				stms = ConectaBanco.obterConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				rs = stms.executeQuery(sql);
	
				rs.first();
				System.out.println(rs.getString("SUB_TITULO"));
	
				do {
					dlc.setCodd(rs.getInt("CODIGO"));
					dlc.setSub_titulo(rs.getString("SUB_TITULO"));
					dlc.setPrecoDlc(rs.getInt("PRECO"));
					dlc.setCod(rs.getInt("COD_GAME"));
					
					
				} while (rs.next());
			} catch (Exception e) {
				//JOptionPane.showMessageDialog(null,"Erro: " + e);
				System.out.println(e);
	
			}
			return dlc;
			
		}

	@Override
	public void deletarDlc(int codigo) {
		try {
			String sql = "DELETE FROM DLC WHERE CODIGO = ?";
			pstms = ConectaBanco.obterConexao().prepareStatement(sql);
			
			pstms.setInt(1, codigo);
			
			int falha = pstms.executeUpdate();

			if (falha == 0) {
				JOptionPane.showMessageDialog(null, "DLC não cadastrada " + falha);
			} else {
				JOptionPane.showMessageDialog(null, "DLC deletado com sucesso! " + falha);
			}

			} catch (SQLException e) {
				e.printStackTrace();
		}

		
	}

}
