package vgr.controller;

import java.util.ArrayList;
import vgrRepositorio.iGameRepositorio;
import vgrRepositorio.GameRepositorio;
import vgr.model.GameModel;

public class GameControl implements iGameControl{

	private static iGameControl instancia;
	private static iGameRepositorio repositorio;
	
	public GameControl() {
		repositorio = GameRepositorio.getInstance();
	}

	public static iGameControl getInstancia() {

		if (instancia == null) {
			return instancia = new GameControl();
		}

		return instancia;
	
	}
	
	
	@Override
	public void cadastrarGame(GameModel g) {
		System.out.println(g.toString());
		repositorio.cadastrarGame(g);
		
	}

	@Override
	public void alterarGame(GameModel g) {
		repositorio.alterarGame(g);
		
	}

	@Override
	public ArrayList<GameModel> consultarGame() {
		return repositorio.consultarGame();
	}

	public GameModel consultarGameCod(int codigo){
		return repositorio.consultarGameCod(codigo);
	}
	
	@Override
	public void deletarGame(int codigo) {
		repositorio.deletarGame(codigo);
		
	}

}
