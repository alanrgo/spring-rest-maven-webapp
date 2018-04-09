package io.alanrgo.springbootstarter.lanches;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanchesController {

	@Autowired
	private LanchesServices lServices;
	
	@RequestMapping("/")
    String index(){
		System.out.println("testando index");
        return "index.html";
    }

	
	@RequestMapping("/lanche")
	public String sayLanche() {
		return "lanche";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/preco")
	public String computePrice(@RequestBody LancheJSON lanche) {
		Lanche novo = new Lanche(
				lanche.getAlface(),
				lanche.getBacon(),
				lanche.getHamb(),
				lanche.getOvo(),
				lanche.getQueijo()
				);
		NumberFormat nf = new DecimalFormat("##.##");
		return nf.format(lServices.computePrice(novo));
	}
	
	@RequestMapping("/cardapio")
	public List<Lanche> Menu() {
		
		return lServices.getMenu();
	}
	
	@RequestMapping("/cardapio/{lancheId}")
	public String getSandwich(@PathVariable String lancheId) {
		return lServices.getMenuSandwichPrice(lancheId).toString();
	}
	
	
}
