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
import br.ufba.siges.model.Usuario;
import br.ufba.siges.repository.Usuarios;

@Controller
@RequestMapping("/siges/usuarios")

public class UsuariosController {
	private static final String CADASTRO_VIEW = "/cadastro/CadastroUsuario"; 
	@Autowired
	private Usuarios usuarios;
	
	@RequestMapping("/novo")
	
	public ModelAndView novo()
	{
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Usuario());
		
		//mv.addObject("todosNiveisUsuario", Nivel.values());
		return mv;
	}
	public String salvar(@Validated Usuario usuario, Errors errors, RedirectAttributes attributes)
	{
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		usuarios.save(usuario);
		
		attributes.addFlashAttribute("mensagem", "Setor salvo com sucesso!");	
		return "redirect:/siges/usuarios/novo";
	}
	
	@RequestMapping
	public ModelAndView pesquisar()
	{
		List<Usuario> todosUsuarios= usuarios.findAll();
		ModelAndView mv = new ModelAndView("/pesquisa/PesquisaUsuarios");
	    mv.addObject("usuarios", todosUsuarios);
		return mv;
	}
	
	@RequestMapping("{id_usuario}")
	public ModelAndView edicao(@PathVariable("id_usuario") Usuario usuario)
	{
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject("usuario", usuario);
		mv.addObject(usuario);
		return mv;
	}
	
	@RequestMapping(value="{id_usuario}", method=RequestMethod.DELETE)
	public String excluir(@PathVariable Integer id_usuario, RedirectAttributes attributes)
	{
		usuarios.delete(id_usuario);
		attributes.addFlashAttribute("mensagem", "Usuario excluido com sucesso com sucesso!");	
		return "redirect:/siges/usuarios";
	}
	
	@ModelAttribute("todosNiveisUsuario")
	public List<Nivel> todosNiveisUsuario() {
		return Arrays.asList(Nivel.values());
}
	@ModelAttribute("todosUsuarios")
	public List<Usuario> todosUsuarios()
	{
		List<Usuario> todosUsuarios= usuarios.findAll();
		return todosUsuarios;
}
	
}
