package io.alanrgo.springbootstarter.lanches;

import java.util.ArrayList;
import java.util.List;

public class LancheDB {
	
	public enum Lanches {XBACON, XBURGER, XEGG, XEGGBACON}
	public float inflation = 1f;
	public List<Float> ingValues = new ArrayList<Float>();
	private List<Lanche> cardapio = new ArrayList<Lanche>();
	
	public LancheDB() {
		//Alface, bacon, hamb, ovo e queijo
		cardapio.add(new Lanche(0, 1, 1, 0, 1)); // XBacon
		cardapio.add(new Lanche(0, 0, 1, 0, 1)); // Xburger
		cardapio.add(new Lanche(0, 0, 1, 1, 1)); // Xegg
		cardapio.add(new Lanche(0, 1, 1, 1, 1)); // Xeggbacon
		ingValues.add( new Float(0.4) ); // Alface
		ingValues.add( new Float(2) ); // Bacon
		ingValues.add( new Float(3) ); // Hamb
		ingValues.add( new Float(0.8) ); // Ovo
		ingValues.add( new Float(1.5) ); // Queijo
	}
	
	public List<Lanche> getMenu(){
		return cardapio;
	}
	
	public void setInflation(float value) {
		inflation = value;
	}
}
