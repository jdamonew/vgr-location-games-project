package vgr.controller;

import java.util.ArrayList;

import vgr.model.UsuarioModel;
import vgrRepositorio.iUsuarioRepositorio;
import vgrRepositorio.UsuarioRepositorio;

public class UsuarioControl implements iUsuarioControl {

	
	private static iUsuarioControl instancia;
	private static iUsuarioRepositorio repositorio;
	
	public UsuarioControl() {
		repositorio = UsuarioRepositorio.getInstance();
	}

	public static iUsuarioControl getInstancia() {

		if (instancia == null) {
			return instancia = new UsuarioControl();
		}

		return instancia;
	
	}
	
	@Override
	public void cadastrarUsuario(UsuarioModel u) {
		repositorio.cadastrarUsuario(u);
		
	}

	@Override
	public void alterarUsuario(UsuarioModel u, String id) {
		repositorio.alterarUsuario(u, id);
		
	}

	@Override
	public ArrayList<UsuarioModel> consultarUsuario() {
		// TODO Auto-generated method stub
		return repositorio.consultarUsuario();
	}
	@Override
	public UsuarioModel consultarUsuarioPorId(String id) {
		return repositorio.consultarUsuarioPorId(id);
	}
	

	@Override
	public void deletarUsuario(String id) {
		repositorio.deletarUsuario(id);	
	}
	
	public boolean autenticaUsuario(String id, String senha) {
		UsuarioModel u = repositorio.autenticaUsuario(id);
		
		if (u.getId() == null) {
			return false;
		} 
		
		if (u.getSenha().equals(senha)) {
			return true;
		}
		
		return false;
	}

}
