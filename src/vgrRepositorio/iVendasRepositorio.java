package vgrRepositorio;

import java.util.ArrayList;

import vgr.model.VendaModel;

public interface iVendasRepositorio {
	

	public abstract void cadastrarVenda (VendaModel v);

	public abstract void alterarVenda (VendaModel v);

	public abstract ArrayList<VendaModel> consultarVenda();

	public abstract void deletarVenda (int codigo);

}
