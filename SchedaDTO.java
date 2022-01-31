package it.contrader.dto;

public class SchedaDTO {
	private int id_scheda;

	private int user_id;

	private String tipo_esercizio;

	private int num_ripetizioni;

	public SchedaDTO() {

	}

	public SchedaDTO (int user_id, String tipo_esercizio, int num_ripetizioni ) {
		this.user_id = user_id;
		this.tipo_esercizio = tipo_esercizio;
		this.num_ripetizioni = num_ripetizioni;
		}

	public SchedaDTO (int id_scheda, int user_id, String tipo_esercizio, int num_ripetizioni) {
		this.id_scheda = id_scheda;
		this.user_id = user_id;
		this.tipo_esercizio = tipo_esercizio;
		this.num_ripetizioni = num_ripetizioni;
	}

	
	
	public int getId_scheda() {
		return id_scheda;
	}

	public void setId_scheda(int id_scheda) {
		this.id_scheda = id_scheda;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getTipo_esercizio() {
		return tipo_esercizio;
	}

	public void setTipo_esercizio(String tipo_esercizio) {
		this.tipo_esercizio = tipo_esercizio;
	}

	public int getNum_ripetizioni() {
		return num_ripetizioni;
	}

	public void setNum_ripetizioni(int num_ripetizioni) {
		this.num_ripetizioni = num_ripetizioni;
	}

	@Override
	public String toString() {
		return  id_scheda + "\t"  + user_id +"\t\t" +   tipo_esercizio + "\t\t" + num_ripetizioni;
	}
}
