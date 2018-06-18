package br.com.casadocodigo.loja.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.daos.ProductDAO;
import br.com.casadocodigo.loja.models.BookType;
import br.com.casadocodigo.loja.models.Product;
import br.com.casadocodigo.loja.validation.ProductValidator;

@Controller
@Transactional
@RequestMapping("/produtos")
public class ProductsController {
	
	@Autowired
	private ProductDAO productDao;
	
	/*@InitBinder
	protected void initProductBinder(WebDataBinder binder) {
		//binder.setValidator(new ProductValidator());
	}*/
	
	@RequestMapping("/form")
	public ModelAndView form(@ModelAttribute("objetoAtual")Product product) {
		ModelAndView modelAndView = new ModelAndView("products/form");
		modelAndView.addObject("types", BookType.values());
		return modelAndView;
	}
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView save( @Valid @ModelAttribute("objetoAtual") Product product,BindingResult result, RedirectAttributes redirectAttributes) {
	
		if(result.hasErrors()) {
			return form(product);
		}
		productDao.save(product);
		System.out.println("Cadastrando produtos");
		redirectAttributes.addFlashAttribute("sucesso","Produto cadastrado com sucesso");
		return new ModelAndView("redirect:produtos");
	}

	@RequestMapping(method= RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("products/list");
		modelAndView.addObject("products", productDao.list());
		return modelAndView;
	}
	
}
