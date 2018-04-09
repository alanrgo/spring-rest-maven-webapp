package io.alanrgo.springbootstarter.lanches;

import java.util.ArrayList;

public class Lanche {

	public enum Ingrediente {ALFACE, BACON, HAMBURGER, OVO, QUEIJO}
	public ArrayList<Integer> ingredientes = new ArrayList<Integer>();
	
	public Lanche(Integer a, Integer b, Integer h, Integer o, Integer q) {
		ingredientes.add(a);
		ingredientes.add(b);
		ingredientes.add(h);
		ingredientes.add(o);
		ingredientes.add(q);
	}
}
