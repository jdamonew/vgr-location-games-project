package vgr.model;

import java.sql.Date;

public class Game {
	
	String titulo;
	String plataforma;
	double preco;
	Date data_lancamento;
	int cod;
	
	public Game(String titulo, String plataforma, float preco, Date data_lancamento, int cod) {
		
		this.titulo = titulo;
		this.plataforma = plataforma;
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
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Date getData_lancamento() {
		return data_lancamento;
	}
	public void setData_lancamento(Date data_lancamento) {
		this.data_lancamento = data_lancamento;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	

}
