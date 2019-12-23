package vgr.model;

public class VendaModel {

	private int numero;
	private String data;
	private String hora;
	private String descricao;
	
	//CONSTRUTOR VAZIO PARA INSTANCIA
	public VendaModel() {}
	
	public VendaModel(int numero, String data, String hora, String descricao) {
		
		this.numero = numero;
		this.data = data;
		this.hora = hora;
		this.descricao = descricao;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return "VendaModel [data=" + data + ", hora=" + hora + "descricao=" + descricao + "]";
	}
	
	

}
