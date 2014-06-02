package br.com.unirio.agauto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.unirio.agauto.Constants;
import br.com.unirio.agauto.controller.dto.CompraDTO;
import br.com.unirio.agauto.facade.CompraFacade;
import br.com.unirio.agauto.facade.FuncionarioFacade;

@Controller
public class IndexController {
	
	@Autowired
	private FuncionarioFacade funcFacade;
	
	@Autowired
	private CompraFacade compraFacade;
	
	@RequestMapping(value={"/", "/home", "/index"})
	public String index(Model model) {
		model.addAttribute(Constants.COMPRAS, compraFacade.getCompras());
		return Constants.INDEX;
	}
	
	@RequestMapping("/addBuy")
	public String addBuy(Model model) {
		CompraDTO compraDTO = new CompraDTO();
		model.addAttribute(Constants.FUNCIONARIOS, funcFacade.getFuncionarios());
		model.addAttribute(Constants.COMPRA, compraDTO);
		
		return Constants.ADD_BUY;
	}
	
	@RequestMapping("/registerBuy")
	public String registerBuy(CompraDTO dto, RedirectAttributes redirectAttributes) {
		try {
			compraFacade.save(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/home";
	}
}
