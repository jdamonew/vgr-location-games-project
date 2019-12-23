package vgr.model;

public class DesenvolvedoraModel {

	String nome;
	int cod;
	
	//CONSTRUTOR VAZIO PARA INSTANCIA
	public DesenvolvedoraModel() {}
	
	public DesenvolvedoraModel(String nome, int cod) {
		
		this.nome = nome;
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}
	
	@Override
	public String toString() {
		return "DesenvolvedoraModel [Nome = " + nome + ", Cod=" + cod + "]";
	}

}
