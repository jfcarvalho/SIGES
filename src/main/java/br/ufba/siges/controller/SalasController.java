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
	
	@RequestMapping("/novo")
	
	public ModelAndView novo()
	{
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Sala());
		return mv;
	}
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Sala sala, Errors errors, RedirectAttributes attributes)
	{
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		System.out.println(sala.getTipo_sala());
		salas.save(sala);
		
		attributes.addFlashAttribute("mensagem", "Sala salva com sucesso!");	
		return "redirect:/siges/salas/novo";
	}
	
	@RequestMapping
	public ModelAndView pesquisar()
	{
		List<Sala> todasSalas= salas.findAll();
		ModelAndView mv = new ModelAndView("/pesquisa/PesquisaSalas");
	    mv.addObject("salas", todasSalas);
		return mv;
	}
	
	@RequestMapping("{id_sala}")
	public ModelAndView edicao(@PathVariable("id_sala") Sala sala)
	{
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject("s", sala);
		mv.addObject(sala);
		return mv;
	}
	
	@RequestMapping(value="{id_usuario}", method=RequestMethod.DELETE)
	public String excluir(@PathVariable Integer id_sala, RedirectAttributes attributes)
	{
		salas.delete(id_sala);
		attributes.addFlashAttribute("mensagem", "Sala excluida com sucesso com sucesso!");	
		return "redirect:/siges/salas";
	}
	
	@ModelAttribute("todasSalas")
	public List<Sala> todasSalas()
	{
		List<Sala> todasSalas= salas.findAll();
		return todasSalas;
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