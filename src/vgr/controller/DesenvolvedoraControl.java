package vgr.controller;

import java.util.ArrayList;

import vgr.model.DesenvolvedoraModel;
import vgrRepositorio.iDesenvolvedoraRepositorio;
import vgrRepositorio.DesenvolvedoraRepositorio;


public class DesenvolvedoraControl implements iDesenvolvedoraControl {
	
	private static iDesenvolvedoraControl instancia;
	private static iDesenvolvedoraRepositorio repositorio;
	
	public DesenvolvedoraControl() {
		repositorio = DesenvolvedoraRepositorio.getInstance();
	}

	public static iDesenvolvedoraControl getInstancia() {

		if (instancia == null) {
			return instancia = new DesenvolvedoraControl();
		}

		return instancia;
	
	}
	

	@Override
	public void cadastrarDesenvolvedora(DesenvolvedoraModel d) {
		System.out.println(d.toString());
		repositorio.cadastrarDesenvolvedora(d);
		
	}

	@Override
	public void alterarDesenvolvedora(DesenvolvedoraModel d) {
		repositorio.alterarDesenvolvedora(d);
	}

	@Override
	public ArrayList<DesenvolvedoraModel> consultarDesenvolvedora() {
		
		return repositorio.consultarDesenvolvedora();
	}

		public DesenvolvedoraModel DesenvolvedoraConsultar(int codigo) {
			return repositorio.DesenvolvedoraConsultar(codigo);
			
		}
	
	@Override
	public void deletarDesenvolvedora(int codigo) {
		repositorio.deletarDesenvolvedora(codigo);
		
	}

}
