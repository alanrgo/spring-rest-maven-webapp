package io.alanrgo.springbootstarter.lanches;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LanchesServices {
	
	LancheDB db;
	
	public List<Lanche> getMenu() {
		db = new LancheDB();
		return db.getMenu();
	}
	
	public void startDB() {
		db = new LancheDB();
	}
	
	public Float computePrice(Lanche lanche) {
		if( db == null ) {
			db = new LancheDB();
		}
		Float total = 0f;
		
		/* compute price without special offers */
		for ( int i = 0; i < lanche.ingredientes.size(); i ++ ) {
			total = total + lanche.ingredientes.get(i) * db.ingValues.get(i);
		}
		System.out.println(total.toString());
		
		/* check special offers */
		
		/* promo 1 */
		if ( lanche.ingredientes.get(0) > 0 && lanche.ingredientes.get(1) == 0 ) {
			total = total * 0.9f;
		}
		
		/* promo 2 */
		int n_hamb = lanche.ingredientes.get(2)/3;
		total = total - n_hamb * db.ingValues.get(2);
		
		/* promo 3 */
		int n_cheese = lanche.ingredientes.get(4)/3;
		total = total - n_cheese * db.ingValues.get(4);
		
		/* inflation */
		total = db.inflation * total ;
		
		return total;
	}
	
	public Float getMenuSandwichPrice(String sand) {
		Float total = 0f;
		if( db == null ) {
			db = new LancheDB();
		}
		if( sand.equals("XBACON")) {
			total = computePrice(db.getMenu().get(0));
		}
		if( sand.equals("XBURGER")) {
			total = computePrice(db.getMenu().get(1));
		}
		if( sand.equals("XEGG")) {
			total = computePrice(db.getMenu().get(2));
		}
		if( sand.equals("XEBACON")) {
			total = computePrice(db.getMenu().get(3));
		}
		
		return total;
	}
	
	public void updateInflation(float value) {
		db.setInflation(value);
	}
	
}
