package br.ufba.siges.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufba.siges.model.Nivel;
import br.ufba.siges.model.Sala;
import br.ufba.siges.model.Situacao;
import br.ufba.siges.model.TipoDeSala;
import br.ufba.siges.model.Usuario;
import br.ufba.siges.repository.Salas;


@Controller
@RequestMapping("/siges/salas")

public class SalasController {
	private static final String CADASTRO_VIEW = "/cadastro/CadastroSala"; 
	 
	@Autowired
	private Salas salas;
	
	
	
	public ModelAndView novo()
	{
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		
		return mv;
	}
	
	public ModelAndView salvar(@Validated Sala sala, Errors errors, RedirectAttributes attributes)
	{
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
			
		return mv;
	}
	

	
	@RequestMapping(method= RequestMethod.GET)
	public ModelAndView pesquisar(String busca, String numero, String instituto)
	{
		//List<Usuario> todosUsuarios= usuarios.findAll();
		
		
		if(numero != null) {
			if(busca != null && numero.equals("on"))
			{
				List<Sala> todasSalas= salas.findByNumero(busca);
				ModelAndView mv = new ModelAndView("/pesquisa/PesquisaSalas");
				mv.addObject("salas", todasSalas);
				return mv;
			}
		}
		else if(instituto != null && instituto.equals("on") )
		{
			List<Sala> todasSalas= salas.findByInstitutoContaining(busca);
			ModelAndView mv = new ModelAndView("/pesquisa/PesquisaSalas");
			mv.addObject("salas", todasSalas);
			return mv;
		}
		
		List<Sala> todasSalas= salas.findAll();
		ModelAndView mv = new ModelAndView("/pesquisa/PesquisaSalas");
	    mv.addObject("salas", todasSalas);
		return mv;
		
	}
	
	
	
	public ModelAndView edicao(@PathVariable("id_sala") Sala sala)
	{
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
	
		return mv;
	}
	

	
	
	public String remove(@PathVariable("id_sala") Integer id_sala, RedirectAttributes attributes)
	{
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
	
		return "redirect:/siges/salas";
	}
	
	
	
	@ModelAttribute("todasSituacoes")
	public List<Situacao> todasSituacoes() {
		return Arrays.asList(Situacao.values());
}
	
	@ModelAttribute("todosTiposSalas")
	public List<TipoDeSala> todosTiposSalas() {
		return Arrays.asList(TipoDeSala.values());
}

}