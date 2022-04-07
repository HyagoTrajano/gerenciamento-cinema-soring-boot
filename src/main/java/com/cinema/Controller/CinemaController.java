package com.cinema.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cinema.Model.Convidado;
import com.cinema.Model.Filme;
import com.cinema.Repository.ConvidadoRepository;
import com.cinema.Repository.FilmeRepository;

@Controller
public class CinemaController {
    
    @Autowired
    FilmeRepository filmeRepository;

    @Autowired
    ConvidadoRepository convidadoRepository;

    
    @RequestMapping(value = "/cadFilme", method = RequestMethod.GET)
    public String form(){
        return "filme/cadastroFilme";
    }

    
    @RequestMapping(value = "/cadFilme", method = RequestMethod.POST)
    public String form(Filme filme, BindingResult result, RedirectAttributes attributes){

        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem","verifique os campos");
            return "redirect:/cadFilme";
        }

        filmeRepository.save(filme);
        attributes.addFlashAttribute("mensagem", "Filme cadastrado com sucesso!");
        return "redirect:/cadFilme";
    }

    
    @RequestMapping("/filmes")
    public ModelAndView listaFilmes() {
    	ModelAndView mv = new ModelAndView("index");
    	Iterable<Filme> filmes = filmeRepository.findAll();
    	mv.addObject("filmes", filmes);
    	return mv;
    }

    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView detalhesFilme(@PathVariable("id") long id){
        Filme filmes = filmeRepository.getById(id);
        ModelAndView mv = new ModelAndView("filme/detalhesFilme");
        mv.addObject("filmes", filmes);

		Iterable<Convidado> convidados = convidadoRepository.findByFilme(filmes);
		mv.addObject("convidados", convidados);

        return mv;
    }

    
    @RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String detalhesFilmePost(@PathVariable("id") long id, @Valid Convidado convidado,  BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/{id}";
		}
		Filme filme = filmeRepository.getById(id);
		convidado.setFilme(filme);
		convidadoRepository.save(convidado);
		attributes.addFlashAttribute("mensagem", "Convidado adicionado com sucesso!");
		return "redirect:/{id}";
	}
    
    
    @RequestMapping("/deletarFilme")
	public String deletarFilme(long id){
    	Filme filme = filmeRepository.getById(id);
    	filmeRepository.delete(filme);
		return "redirect:/filmes";
	}
    
    
    @RequestMapping("/deletarConvidado")
	public String deletarConvidado(long id_convidado){
		Convidado convidado = convidadoRepository.getById(id_convidado);
		convidadoRepository.delete(convidado);
		Filme filme = convidado.getFilme();
		long codigoLongConvidado = filme.getId();
		String codigoConvidado = "" + codigoLongConvidado;
		return "redirect:/" + codigoConvidado;
	}
}