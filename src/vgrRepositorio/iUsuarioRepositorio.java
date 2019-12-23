package vgrRepositorio;

import java.util.ArrayList;

import vgr.model.UsuarioModel;

public interface iUsuarioRepositorio {
	

		public abstract void cadastrarUsuario (UsuarioModel u);

		public abstract void alterarUsuario (UsuarioModel u, String id);

		public abstract ArrayList<UsuarioModel> consultarUsuario();

		public abstract void deletarUsuario (String id);

		public abstract UsuarioModel consultarUsuarioPorId(String id);
		
		public abstract UsuarioModel autenticaUsuario(String id);


		
}
