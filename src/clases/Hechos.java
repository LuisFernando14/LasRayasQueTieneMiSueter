package clases;

import java.util.LinkedList;

public class Hechos {
	
	private LinkedList<Hecho> hechos = new LinkedList<Hecho> ();
	
	public Hechos(Hecho hecho) {
		hechos.add(hecho);
	}
	
	public Hechos() {
		hechos = new LinkedList<Hecho> ();
	}
	
	public Hechos(String ... hecho) {
		Hecho a = new Hecho(hecho);
		hechos.add(a);
	}
	
	public Hechos(LinkedList<Hecho> hechos) {
		this.hechos = hechos;
	}
	
	public boolean define(Hecho hecho) {
		hechos.add(hecho);
		return true; // posiblemente después se me ocurra una idea de implementar mejor esto
	}
	/*
	public boolean define(String ... strings) {
		Hecho a = new Hecho(strings);
		define(a);
		return true; // posiblemente después se me ocurra una idea de implementar mejor esto
	}
	*/
	public LinkedList<Hecho> getHechos() {
		return this.hechos;
	}
	
	public boolean setHechos(LinkedList<Hecho> hechos) {
		if(this.hechos.size() > 0)
			return false;
		this.hechos = hechos;
		return true;
	}
}
