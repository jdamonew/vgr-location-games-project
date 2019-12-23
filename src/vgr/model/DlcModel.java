package vgr.model;


public class DlcModel extends GameModel {
	
	
	public DlcModel(String titulo, String plataforma, float preco, String data_lancamento, int cod) {
		super(titulo, preco, data_lancamento, cod);
	}
	
	int codd;
	String sub_titulo;
	int precoDlc;
	
	//CONSTRUTOR VAZIO PARA INSTANCIA
	public DlcModel() {	}
	
	public DlcModel(int codd, String sub_titulo, int precoDlc) {
		this.codd = codd;
		this.sub_titulo = sub_titulo;
		this.precoDlc = precoDlc;
	}
		
	
	public int getPrecoDlc() {
		return precoDlc;
	}

	public void setPrecoDlc(int precoDlc) {
		this.precoDlc = precoDlc;
	}

	public String getSub_titulo() {
		return sub_titulo;
	}
	public void setSub_titulo(String sub_titulo) {
		this.sub_titulo = sub_titulo;
	}
	
	public int getCodd() {
		return codd;
	}

	public void setCodd(int codd) {
		this.codd = codd;
	}

	@Override
	public String toString() {
		return "DlcModel [codd=" + codd + ", sub_titulo=" + sub_titulo + ", precoDlc=" + precoDlc + ", preco=" + preco + ", cod=" + cod + "]";
	}

	


	

}
