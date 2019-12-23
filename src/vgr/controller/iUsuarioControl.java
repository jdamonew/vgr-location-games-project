package vgr.controller;

import java.util.ArrayList;

import vgr.model.UsuarioModel;

public interface iUsuarioControl {
	
	public abstract void cadastrarUsuario(UsuarioModel u);
	
	public abstract void alterarUsuario(UsuarioModel u, String id);
	
	public abstract ArrayList<UsuarioModel> consultarUsuario();
	
	public abstract void deletarUsuario(String id);

	UsuarioModel consultarUsuarioPorId(String id);

}
