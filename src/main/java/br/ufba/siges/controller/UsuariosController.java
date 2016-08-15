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
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@Validated Usuario usuario, Errors errors, RedirectAttributes attributes)
	{
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		if(errors.hasErrors())
		{
			System.out.println("Que porra é que ta acontecendo?");
			return mv;
		}
		usuarios.save(usuario);
		System.out.println("Que porra é que ta acontecendo? 2");
		//attributes.addFlashAttribute("mensagem", "Usuario salvo com sucesso!");	
		mv.addObject("mensagem", "Cadastro de Usuário realizado com sucesso!");
		return mv;
	}
	

	@RequestMapping(method= RequestMethod.GET)
	public ModelAndView pesquisar(String busca, String nome)
	{
		//List<Usuario> todosUsuarios= usuarios.findAll();
		System.out.println(busca);
		
		if(nome != null) {
			if(busca != null && nome.equals("on"))
			{
				List<Usuario> todosUsuarios= usuarios.findByNomeContaining(busca);
				ModelAndView mv = new ModelAndView("/pesquisa/PesquisaUsuarios");
				mv.addObject("usuarios", todosUsuarios);
				return mv;
			}
		}
		List<Usuario> todosUsuarios= usuarios.findAll();
		ModelAndView mv = new ModelAndView("/pesquisa/PesquisaUsuarios");
	    mv.addObject("usuarios", todosUsuarios);
		return mv;
	}
	
	@RequestMapping("{id_usuario}")
	public ModelAndView edicao(@PathVariable("id_usuario") Usuario usuario)
	{
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject("u", usuario);
		mv.addObject(usuario);
		return mv;
	}
	
	@RequestMapping("/remove/{id_usuario}")
	public String remove(@PathVariable("id_usuario") Integer id_usuario, RedirectAttributes attributes)
	{
		//ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		System.out.println(id_usuario);
		usuarios.delete(id_usuario);
		attributes.addFlashAttribute("mensagem", "Sala excluida com sucesso com sucesso!");	
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
