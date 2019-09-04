package exemplo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import exemplo.jpa.Livro;
import exemplo.repos.LivroRepository;

@Controller
@RequestMapping("/")
public class LivroController {
       
      private LivroRepository livroRepository;
  
      @Autowired
      public LivroController( LivroRepository livroRepository) {
            this.livroRepository = livroRepository;
      }

      @RequestMapping(method = RequestMethod.GET)
      public String listaLivros(Model model) {
            List<Livro> listaLivros = livroRepository.findAll();
            if (listaLivros != null) {
                  model.addAttribute("livros", listaLivros);
            }
            return "listaLivros";
      }
      
      @RequestMapping(value = "/{autor}", method = RequestMethod.GET)
      public String listaLivros(@PathVariable("autor") String autor, Model model) {
    	    model.addAttribute("autor", autor);
    	    List<Livro> listaLivros = livroRepository.findByAutor(autor);
            if (listaLivros != null) {
                  model.addAttribute("livros", listaLivros);
            }
            return "listaLivros";
      }
  
      @RequestMapping(value = "/{autor}", method = RequestMethod.POST)
      public String adicionaLivroAutor(@PathVariable("autor") String autor, Livro livro) {
            livro.setAutor(autor);
            livroRepository.save(livro);
            return "redirect:/{autor}";
      }
}