package vgr.model;

public class UsuarioModel {
	
	private String nome;
	private String id;
	private String senha;
	private String email;
	private String data_nasc;
	
	//CONSTRUTOR VAZIO PARA INSTANCIA
	public UsuarioModel() {  }
	
	public UsuarioModel(String nome,String id,String senha,String email, String data_nasc ) {
		
		this.nome = nome;
		this.id = id;
		this.senha = senha;
		this.email = email;
		this.data_nasc = data_nasc;
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
		
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
			this.senha = senha;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
		
		
	}
	public String getData_nasc() {
		return data_nasc;
	}
	public void setData_nasc(String data_nasc) {
		this.data_nasc = data_nasc;
	}
	@Override
	public String toString() {
		return "UsuarioModel [nome=" + nome + ", id=" + id + ", senha=" + senha + ", email=" + email + ", data_nasc="
				+ data_nasc + "]";
	}
	
	
	

}
