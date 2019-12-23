package vgr.model;

public class GameModel {
	
	String titulo;
	double preco;
	String data_lancamento;
	int cod;
	
	//CONSTRUTOR VAZIO PARA INSTANCIA
	public GameModel() {}
	
	public GameModel(String titulo, double preco,String data_lancamento, int cod) {
		
		this.titulo = titulo;
		this.preco = preco;
		this.data_lancamento = data_lancamento;
		this.cod = cod;
		
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getData_lancamento() {
		return data_lancamento;
	}
	public void setData_lancamento(String data_lancamento) {
		this.data_lancamento = data_lancamento;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	
	@Override
	public String toString() {
		return "GameModel [titulo=" + titulo + ", preco=" + preco + ", data_lancamento=" + data_lancamento + ", cod=" + cod + "]";
	}

}
