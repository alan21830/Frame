package model;

public class Utente {
	private String nome,cognome , telefono , data,matricola;

	public void setMatricola(String m) {
		matricola=m;
		
	}
	
	public String getMatricola() {
		
		return matricola;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getNome() {
		// TODO Auto-generated method stub
		return this.nome;
	}

}
