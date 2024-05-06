package it.marconi.springbootverificabertazzoli.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Annotazione di Lombok per generare automaticamente i getter, setter, equals, hashCode e toString
@NoArgsConstructor // Annotazione di Lombok per generare automaticamente un costruttore senza argomenti
@AllArgsConstructor 
public class Film {
    private String codice;
    private String titolo;
    private String genere;
    private int anno;
    private int voto; // (un intero tra 1 e 5)
}
