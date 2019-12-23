package vgrRepositorio;

import java.util.ArrayList;

import vgr.model.GameModel;

public interface iGameRepositorio {

	
	public abstract void cadastrarGame(GameModel g);

	public abstract void alterarGame(GameModel g);

	public abstract ArrayList<GameModel> consultarGame();
	
	public GameModel consultarGameCod(int codigo);

	public abstract void deletarGame(int codigo);
	
}
