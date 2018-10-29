package clases;

import java.util.LinkedList;

public class Motor {
	
	Hechos hechos;
	
	public Motor(Hechos hechos) {
		System.out.println("Este es el motor de prolog");
		this.hechos = hechos;
	}
	
	public void inferir(Object object) {
		if(object instanceof Hecho) {
			System.out.println("Esto es un hecho");
			inferirHecho((Hecho) object);
		} else {
			// inferir una regla
		}
	}
	
	public Hecho inferirHecho(Hecho hecho) {
		//primero buscamos que royal de asociacion es
		// obtenemos todos los de la misma asociacion
		String asociacion = hecho.getHecho()[0];
		int posicion = 0;
		LinkedList<Hecho> hechos = getByPosition(this.hechos.getHechos(), asociacion, posicion);
		if(hechos.size() == 0)
			return null;
		//Si llegamos aquí, significa que haya algo. Ahora buscamos algo que tenga sentido
		LinkedList<Hecho> resultados = buscarPalabra(hecho, hechos);
		LinkedList<Integer> posiciones = getPosicionesIncognitas(hecho);
		for(Hecho h : resultados) {
			for(int i = 0; i < posiciones.size(); i++) {
				System.out.print(hecho.getHecho()[posiciones.get(i)]+": ");
				System.out.println(h.getHecho()[posiciones.get(i)]);
			}
			System.out.println();
		}
		return null;
	}
	
	public LinkedList<Integer> getPosicionesIncognitas(Hecho hecho) {
		LinkedList<Integer> posicines = new LinkedList<Integer>();
		for(int i = 1; i < hecho.getHecho().length; i++) 
			if(hecho.getHecho()[i].length() == 1)
				posicines.add(i);
		return posicines;
	}
	
	public LinkedList<Hecho> buscarPalabra(Hecho hecho, LinkedList<Hecho> hechos) { //este es para buscar la variable
		String aux = "";
		String [] hechoAux = hecho.getHecho();
		LinkedList<Hecho> nuevaLista = new LinkedList<Hecho> (); 
		for(int i = 1; i < hechoAux.length; i++) {
			aux = hechoAux[i];
			if(aux.length() == 1)
				continue;
			nuevaLista = getByPosition(hechos, aux, i);
			hechos = nuevaLista;
		}
		return nuevaLista;
	}
	
	public LinkedList<Hecho> getByPosition(LinkedList<Hecho> listaDeHechos, String asociacion, int posicion) {
		LinkedList<Hecho> hechosRestantes = new LinkedList<Hecho>();
		for(Hecho h : listaDeHechos) {
			if(h.getHecho()[posicion].equals(asociacion)) { //pertenece a la asociacion
				hechosRestantes.add(h);
			}
		}
		return hechosRestantes;
	}
}
