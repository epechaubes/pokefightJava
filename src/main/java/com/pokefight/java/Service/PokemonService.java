package com.pokefight.java.Service;

import com.pokefight.java.Repository.AttaqueRepository;
import com.pokefight.java.Repository.PokemonRepository;
import com.pokefight.java.model.Attaque;
import com.pokefight.java.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;
    @Autowired
    private AttaqueRepository attaqueRepository;

    public Pokemon AjoutAttaque(Long idPokemon, Long idAttaque) throws Exception{
        Pokemon pokemonAModif = pokemonRepository.findOne(idPokemon);
        if (pokemonAModif != null){
            List<Attaque> listAttaque = pokemonAModif.getAttaques();
            Attaque attaqueAjoute = attaqueRepository.findOne(idAttaque);
            if (attaqueAjoute != null){
                for (Attaque attaque : listAttaque){
                    if (attaqueAjoute.getAttaqueId().equals(attaque.getAttaqueId())){
                        throw new Exception("Le pokemon (id : " + idPokemon + ") connaît déjà l'attaque choisie (id : " + idAttaque + ")");
                    }
                }
                listAttaque.add(attaqueAjoute);
                return pokemonRepository.save(pokemonAModif);
            }
            else{
                throw new Exception("L'id de l'attaque est incorrect : " + idAttaque);
            }
        }
        else{
            throw new Exception("L'id du pokemon est incorrect : " + idPokemon);
        }
    }

    public Pokemon SupprimerAttaque(Long idPokemon, Long idAttaque) throws Exception{
        Pokemon pokemonAModif = pokemonRepository.findOne(idPokemon);
        if (pokemonAModif != null){
            List<Attaque> listAttaque = pokemonAModif.getAttaques();
            Attaque attaqueSupprime = attaqueRepository.findOne(idAttaque);
            if (attaqueSupprime != null){
                for (Attaque attaque : listAttaque){
                    if (attaque.getAttaqueId().equals(attaqueSupprime.getAttaqueId())){
                        listAttaque.remove(attaqueSupprime);
                        pokemonRepository.save(pokemonAModif);
                        return pokemonRepository.save(pokemonAModif);
                    }
                }
                throw new Exception("Le pokemon (id : " + idPokemon + ") ne connaît pas l'attaque choisie (id : " + idAttaque + ")");
            }
            else{
                throw new Exception("L'id de l'attaque est incorrect : " + idAttaque);
            }
        }
        else{
            throw new Exception("L'id du pokemon est incorrect : " + idPokemon);
        }
    }

}
