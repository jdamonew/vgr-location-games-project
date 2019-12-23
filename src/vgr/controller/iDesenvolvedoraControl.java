package vgr.controller;

import java.util.ArrayList;

import vgr.model.DesenvolvedoraModel;

public interface iDesenvolvedoraControl {
	
	public abstract void cadastrarDesenvolvedora (DesenvolvedoraModel d);

	public abstract void alterarDesenvolvedora (DesenvolvedoraModel d);

	public abstract ArrayList<DesenvolvedoraModel> consultarDesenvolvedora();
	
	public DesenvolvedoraModel DesenvolvedoraConsultar(int codigo);

	public abstract void deletarDesenvolvedora (int codigo);

	

}
