package vgr.controller;

import java.util.ArrayList;

import vgr.model.DlcModel;

public interface iDlcControl {

	public abstract void cadastrarDlc(DlcModel l);

	public abstract void alterarDlc(DlcModel l);

	public abstract ArrayList<DlcModel> consultarDlc();
	
	public DlcModel DlcConsutarCod (int codigo);

	public abstract void deletarDlc(int codigo);

}
