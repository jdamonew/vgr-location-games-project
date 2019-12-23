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
			JOptionPane.showMessageDialog(null, "Nome de usu�rio inv�lido.");
		}else{
			this.id = id;
		}
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		if(senha==null || 8 < senha.length()) {
			JOptionPane.showMessageDialog(null, "Senha inv�lida.");
		}else{
			this.senha = senha;
		}
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		if(cpf==null || cpf.length()<11) {
			JOptionPane.showMessageDialog(null, "CPF inv�lido.");
		}else {
			this.cpf = cpf;
		}
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email==null) {
			JOptionPane.showMessageDialog(null, "Endere�o de Email inv�lido.");
		}else {
			this.email = email;
		}
		
	}
	
	
	

}
