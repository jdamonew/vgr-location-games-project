package vgr.controller;

import java.util.ArrayList;

import vgr.model.VendaModel;
import vgrRepositorio.VendasRepositorio;
import vgrRepositorio.iVendasRepositorio;

public class VendaControl implements iVendaControl {

	
	private static iVendaControl instancia;
	private static iVendasRepositorio repositorio;
	
	public VendaControl() {
		repositorio = VendasRepositorio.getInstance();
	}

	public static iVendaControl getInstancia() {

		if (instancia == null) {
			return instancia = new VendaControl();
		}

		return instancia;
	
	}
	
	@Override
	public void cadastrarVenda(VendaModel v) {
		System.out.println(v.toString());
		repositorio.cadastrarVenda(v);
	}

	@Override
	public void alterarVenda(VendaModel v) {
		repositorio.alterarVenda(v);
		
	}

	@Override
	public ArrayList<VendaModel> consultarVenda() {
		
		return repositorio.consultarVenda();
	}

	@Override
	public void deletarVenda(int codigo) {
		repositorio.deletarVenda(codigo);
		
	}

}
