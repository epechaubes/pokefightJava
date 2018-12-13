package com.pokefight.java.Service;

import com.pokefight.java.Repository.AttaqueRepository;
import com.pokefight.java.Repository.PokemonRepository;
import com.pokefight.java.model.Attaque;
import com.pokefight.java.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;
    private AttaqueRepository attaqueRepository;

    public void AjoutAttaque(Long idPokemon, Long idAttaque) throws Exception{
        Pokemon pokemonAModif = pokemonRepository.findOne(idPokemon);
        if (pokemon){
            List<Attaque> listAttaque = pokemon.getAttaques();
            Attaque attaqueAjoute = attaqueRepository.findOne(idAttaque);
            if (attaque){
                for (Attaque attaque : listAttaque){
                    if (attaqueAjoute == attaque){
                        throw new Exception("Le pokemon connaît déjà l'attaque choisie");
                    }
                    else{

                    }
                }
            }
            else{
                throw new Exception("L'id de l'attaque est incorrect");
            }
        }
        else{
            throw new Exception("L'id du pokemon est incorrect");
        }

    }

}
