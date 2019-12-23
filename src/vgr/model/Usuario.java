package vgr.model;

import javax.swing.JOptionPane;

public class Usuario {
	
	private String id;
	private String senha;
	private String cpf;
	private String email;
	
	public Usuario(String id, String senha, String cpf, String email) {
		
		this.id = id;
		this.senha = senha;
		this.cpf = cpf;
		this.email = email;
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		if(id==null) {
			JOptionPane.showMessageDialog(null, "Nome de usuário inválido.");
		}else{
			this.id = id;
		}
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		if(senha==null || 8 < senha.length()) {
			JOptionPane.showMessageDialog(null, "Senha inválida.");
		}else{
			this.senha = senha;
		}
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		if(cpf==null || cpf.length()<11) {
			JOptionPane.showMessageDialog(null, "CPF inválido.");
		}else {
			this.cpf = cpf;
		}
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email==null) {
			JOptionPane.showMessageDialog(null, "Endereço de Email inválido.");
		}else {
			this.email = email;
		}
		
	}
	
	
	

}
