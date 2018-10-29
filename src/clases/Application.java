package clases;

import java.util.LinkedList;

public class Application {
	public static void main(String [] args) {
		Hechos hechos = new Hechos();
		hechos.define(new Hecho("papa", "antonio", "luis"));
		hechos.define(new Hecho("papa", "antonio", "ana"));
		hechos.define(new Hecho("papa", "antonio", "peque"));
		
		LinkedList<Hecho> hechosL = hechos.getHechos();
		// System.out.println(hechosL.size());
		/*
		for(Hecho h : hechosL ) {
			for(String a : h.getHecho()) {
				System.out.print(a+" ");
			}
			System.out.println();
		}
		*/
		Motor m = new Motor(hechos);
		m.inferir(new Hecho("papa", "antonio", "X"));
	}
}
