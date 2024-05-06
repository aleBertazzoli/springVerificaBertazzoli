package it.marconi.springbootverificabertazzoli.controllers;

import org.springframework.stereotype.Controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import it.marconi.springbootverificabertazzoli.domains.Film;
import it.marconi.springbootverificabertazzoli.services.FilmService;

    
    @Controller
    @RequestMapping("/films") // Mapping principale per questo controller

    public class HomeController {
        @Autowired // Iniezione del servizio UserService
        FilmService filmService;

        @GetMapping // Mapping per la homepage
            public ModelAndView viewHomePage() {
            return new ModelAndView("homepage"); // Ritorna la vista "homepage"
        }

        @GetMapping("/nuovo")
        public ModelAndView newContactForm() {
        return new ModelAndView("nuovo-film").addObject("userForm", new Film()); 
    }


    @PostMapping("/nuovo")
    public ModelAndView handlerNewUser(@ModelAttribute Film userForm) {

        filmService.addFilm(userForm);

        String codice = userForm.getCodice(); 
        return new ModelAndView("redirect:/nuovo/" + codice); // Reindirizza alla pagina di dettaglio film
    }


    @GetMapping("/nuovo/{codice}")
    public  ModelAndView userDetail(@PathVariable("codice") String codice) {

        Optional<Film> film = filmService.getFilmByCodice(codice);
        if (film.isPresent())
            return new ModelAndView("film-detail").addObject("nuovo", film.get());
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utente non trovato!");
    }

        // Gestisce le richieste GET per eliminare un film in base al codice fornito
        // @GetMapping("/delete/{codice}") 
        // public ModelAndView deleteContact(
           //  @PathVariable("codice") UUID codice, 
           //  RedirectAttributes attr 
        // ) {
            // Elimina il contatto utilizzando il servizio
        //     filmService.deleteById(codice); 
    
            // Aggiunge un attributo booleano ("deleted") ai flash attributes del redirect
         //    attr.addFlashAttribute("deleted", true);
            // Reindirizza alla pagina della lista dei film
        //     return new ModelAndView("redirect:/films");
        // }


        // per modificare -- in più
        @PostMapping("/modifica/{codice}")
            public String modificaFilm(@ModelAttribute Film film) {
            // Implementa la logica per la modifica del prodotto
            return "redirect:/films";
        }
        
        @PostMapping("/svuota")
            public String svuotaCatalogo() {
             filmService.svuotaCatalogo();
            return "redirect:/catalogo";
        }
        


}