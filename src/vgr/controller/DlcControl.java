package vgr.controller;

import java.util.ArrayList;

import vgr.model.DlcModel;
import vgrRepositorio.DlcRepositorio;
import vgrRepositorio.iDlcRepositorio;

public class DlcControl implements iDlcControl {

	private static iDlcControl instancia;
	private static iDlcRepositorio repositorio;
	
	public DlcControl() {
		repositorio = DlcRepositorio.getInstance();
	}

	public static iDlcControl getInstancia() {

		if (instancia == null) {
			return instancia = new DlcControl();
		}

		return instancia;
	
	}
	
	
	@Override
	public void cadastrarDlc(DlcModel l) {
		System.out.println(l.toString());
		repositorio.cadastrarDlc(l);
		
	}

	@Override
	public void alterarDlc(DlcModel l) {
		repositorio.alterarDlc(l);
		
	}

	@Override
	public ArrayList<DlcModel> consultarDlc() {

		return repositorio.consultarDlc();
	}
	@Override
	public DlcModel DlcConsutarCod (int codigo) {
		return repositorio.DlcConsutarCod(codigo);
	}
	
	@Override
	public void deletarDlc(int codigo) {
		repositorio.deletarDlc(codigo);
		
	}

}
