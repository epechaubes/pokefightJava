package com.pokefight.java.model;

import com.pokefight.java.Service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @RequestMapping("/AjoutAttaquePokemon")
    public Pokemon AjoutAttaquePokemon(@RequestParam(value = "idAttaque") Long idAttaque,
                                       @RequestParam(value = "idPokemon") Long idPokemon) throws Exception {
        return pokemonService.AjoutAttaque(idPokemon, idAttaque);
    }

    @RequestMapping("/SupprimerAttaquePokemon")
    public Pokemon SupprimerAttaquePokemon(@RequestParam(value = "idAttaque") Long idAttaque,
                                           @RequestParam(value = "idPokemon") Long idPokemon) throws Exception {
        return pokemonService.SupprimerAttaque(idPokemon, idAttaque);
    }
}