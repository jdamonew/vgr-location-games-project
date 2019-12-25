package vgrRepositorio;

import javax.swing.JOptionPane;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConexaoBanco.ConectaBanco;
import vgr.model.VendaModel;

public class VendasRepositorio implements iVendasRepositorio {
	
	private static iVendasRepositorio instancia;

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
	
	private VendasRepositorio() {
		openDatabase();
	}
	

	public static iVendasRepositorio getInstance() {

		if (instancia == null) {

			return instancia = new VendasRepositorio();

		}

		return instancia;
	}
	

	@Override
	public void cadastrarVenda(VendaModel v) {
		try {

			String INsql = "INSERT INTO VENDA (NUMERO, DATA_HORA, DESCRICAO) VALUES ((SELECT MAX(NUMERO) + 1 FROM VENDA),sysdate,?)";

			pstms = ConectaBanco.obterConexao().prepareStatement(INsql);

			pstms.setString(1, v.getDescricao());
			
		

			pstms.execute();

			if (pstms.getWarnings() == null) {

				JOptionPane.showMessageDialog(null, "Aluguel Realizado com Sucesso", "Aluguel Realizado",JOptionPane.INFORMATION_MESSAGE);

			}
			
			pstms.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void alterarVenda(VendaModel v) {
		
		try {

			String sql = "UPDATE VENDA SET DESCRICAO = '" + v.getDescricao() +  "' WHERE NUMERO = '" + v.getNumero() + "'";

			System.out.println(sql);
			stms = ConectaBanco.obterConexao().createStatement();

			int resultado = stms.executeUpdate(sql);

			JOptionPane.showMessageDialog(null, " Atualizado: " + resultado);

		} catch (Exception e) {
	
		}
		
	}

	@Override
	public ArrayList<VendaModel> consultarVenda() {
		
		ArrayList<VendaModel> listVendaModel = null;

		try {

			listVendaModel = new ArrayList<VendaModel>();

			String sql = "SELECT * FROM VENDA ORDER BY NUMERO";
			stms = ConectaBanco.obterConexao().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = stms.executeQuery(sql);

			rs.first();

			do {

				VendaModel venda = new VendaModel();
				
				venda.setNumero(rs.getInt("NUMERO"));
				venda.setData(rs.getString("DATA_HORA"));
				venda.setDescricao(rs.getString("DESCRICAO"));
				
				
				listVendaModel.add(venda);

			} while (rs.next());

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro: " + e);

		}

		return listVendaModel;
	}

	@Override
	public void deletarVenda(int codigo) {
		try {
			String sql = "DELETE FROM VENDA WHERE NUMERO = ?";
			pstms = ConectaBanco.obterConexao().prepareStatement(sql);
			
			pstms.setInt(1, codigo);
			
			int falha = pstms.executeUpdate();

			if (falha == 0) {
				JOptionPane.showMessageDialog(null, "Venda não cadastrada" + falha);
			} else {
				JOptionPane.showMessageDialog(null, "Venda deletada com sucesso! " + falha);
			}

			} catch (SQLException e) {
				e.printStackTrace();
		}

	}	
		

}
