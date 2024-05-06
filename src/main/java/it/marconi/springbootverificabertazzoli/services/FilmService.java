package it.marconi.springbootverificabertazzoli.services;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import it.marconi.springbootverificabertazzoli.domains.Film;

@Service
public class FilmService {
    
    
    // Creazione di un database fittizio per gli utenti registrati
    private ArrayList<Film> films = new ArrayList<>();

    // Metodo per ottenere tutti gli utenti
    public ArrayList<Film> getFilm() {
        return films;
    }

    // Metodo per aggiungere un nuovo utente al database
    public void addFilm(Film newFilm) {
        films.add(newFilm);
    }

    // Metodo per ottenere un utente dal database tramite il nome utente
    public Optional<Film> getFilmByTitolo(String titolo) {

        // Scansione della lista degli utenti per trovare quello con il nome utente specificato
        for(Film f : films) {
            if(f.getTitolo().equals(titolo)) {
                return Optional.of(f); // Se trovato, restituisce l'utente all'interno di un Optional
            }
        }
        return Optional.empty(); // Se non trovato, restituisce un Optional vuoto
    }

    public Optional<Film> getFilmByCodice(String codice) {

        // Scansione della lista degli utenti per trovare quello con il nome utente specificato
        for(Film f : films) {
            if(f.getCodice().equals(codice)) {
                return Optional.of(f); // Se trovato, restituisce l'utente all'interno di un Optional
            }
        }
        return Optional.empty(); // Se non trovato, restituisce un Optional vuoto
    }

    // metodo per eliminare tramite ID
    //public void deleteByCodice(UUID codice) {
    //    films.deleteById(codice); 
    //}

    public void svuotaCatalogo() {
        films.clear();
    }
}
