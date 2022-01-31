package it.contrader.model;

public class Scheda {
private int Id_scheda;
private int User_id;
private String Tipo_esercizio;
private int Num_ripetizioni;


public Scheda() {
}


	public Scheda (int User_id, String Tipo_esercizio, int Num_ripetizioni) {
		this.User_id = User_id;
		this.Tipo_esercizio = Tipo_esercizio;
		this.Num_ripetizioni = Num_ripetizioni;
}
	public Scheda (int Id_scheda, int User_id, String Tipo_esercizio, int Num_ripetizioni) {
		this.Id_scheda = Id_scheda;
		this.User_id = User_id;
		this.Tipo_esercizio = Tipo_esercizio;
		this.Num_ripetizioni = Num_ripetizioni;
}
	public int getId_scheda() {
		return Id_scheda;
	}
	public void setId_scheda(int id_scheda) {
		Id_scheda = id_scheda;
	}
	public int getUser_id() {
		return User_id;
	}
	public void setUser_id(int user_id) {
		User_id = user_id;
	}
	public String getTipo_esercizio() {
		return Tipo_esercizio;
	}
	public void setTipo_esercizio(String tipo_esercizio) {
		Tipo_esercizio = tipo_esercizio;
	}
	public int getNum_ripetizioni() {
		return Num_ripetizioni;
	}
	public void setNum_ripetizioni(int num_ripetizioni) {
		Num_ripetizioni = num_ripetizioni;
	}
	@Override
	public String toString() {
		return  Id_scheda + "\t"  + User_id +"\t\t" +   Tipo_esercizio + "\t\t" + Num_ripetizioni;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Scheda other = (Scheda) obj;
		if (Id_scheda != other.Id_scheda)
			return false;
		if (User_id == 0) {
			if (other.User_id == 0)
				return false;
		} 
		if (Tipo_esercizio == null) {
			if (other.Tipo_esercizio != null)
				return false;
		} else if (!Tipo_esercizio.equals(other.Tipo_esercizio))
			return false;
		if (Num_ripetizioni == 0) {
			if (other.Num_ripetizioni == 0)
				return false;
		} 
		return true;
	}
}

