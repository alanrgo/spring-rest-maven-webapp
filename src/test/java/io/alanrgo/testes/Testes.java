package io.alanrgo.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import io.alanrgo.springbootstarter.lanches.Lanche;
import io.alanrgo.springbootstarter.lanches.LanchesServices;

public class Testes {
	private LanchesServices lServices = new LanchesServices();
	
	@Test
	public void CT_XBacon() {
		lServices.startDB();
		lServices.updateInflation(1f);
		Float result = lServices.getMenuSandwichPrice("XBACON");
		assertEquals(result, 6.5, 0.001f);
	}
	
	@Test
	public void CT_XBurger() {
		lServices.startDB();
		lServices.updateInflation(1f);
		Float result = lServices.getMenuSandwichPrice("XBURGER");
		assertEquals(result, 4.5, 0.001f);
	}
	
	@Test
	public void CT_XEgg() {
		lServices.startDB();
		lServices.updateInflation(1f);
		Float result = lServices.getMenuSandwichPrice("XEGG");
		assertEquals(result, 5.3, 0.001f);
	}
	
	@Test
	public void CT_XEBacon() {
		lServices.startDB();
		lServices.updateInflation(1f);
		Float result = lServices.getMenuSandwichPrice("XEBACON");
		assertEquals(result, 7.3, 0.001f);
	}
	
	@Test
	public void CT_XBacon_Infl() {
		lServices.startDB();
		lServices.updateInflation(1.2f);
		Float result = lServices.getMenuSandwichPrice("XBACON");
		assertEquals(result, 7.8, 0.001f);
	}
	
	@Test
	public void personalized() {
		lServices.startDB();
		Lanche novo = new Lanche(5,5,5,5,5);
		Float result = lServices.computePrice(novo);
		assertEquals(result, 34, 0.001f);
		
	}

}
