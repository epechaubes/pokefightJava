package com.pokefight.java;

import com.pokefight.java.Repository.AttaqueRepository;
import com.pokefight.java.Repository.PokemonRepository;
import com.pokefight.java.Service.PokemonService;
import com.pokefight.java.model.Attaque;
import com.pokefight.java.model.Pokemon;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PokemonServiceTest {

    @Autowired
    private PokemonRepository pokemonRepository;
    @Autowired
    private PokemonService pokemonService;
    @Autowired
    private AttaqueRepository attaqueRepository;

    private Pokemon pokemonTest;
    private Attaque attaqueTest;
    private Attaque attaqueTest2;

    @Before
    public void setUp(){
        //Liste Pokemon
        /*List<Pokemon> listPokemon = new ArrayList<Pokemon>();
        listPokemon.add(pokemonRepository.findOne(42L));
        List<Pokemon> listPokemon2 = new ArrayList<Pokemon>();*/

        //Attaques
        attaqueTest = new Attaque( "griffe", 60, 50, "normal", "physique");
        attaqueTest2 = new Attaque( "surf", 80, 70, "eau", "special");
        attaqueTest = attaqueRepository.save(attaqueTest);
        attaqueTest2 = attaqueRepository.save(attaqueTest2);

        //Liste Attaque
        List<Attaque> listAttaque = new ArrayList<Attaque>();
        listAttaque.add(attaqueTest);

        //Pokemon
        pokemonTest = new Pokemon(listAttaque, "rattata", "normal", 100, 100, 100, 100, 100, 100);

        //Ajout attaque et pokemon au repository
        pokemonTest = pokemonRepository.save(pokemonTest);

    }

    @After
    public void tearDown(){
        //supprime Attaque
        pokemonTest.setAttaques(new ArrayList<>());
        pokemonTest = pokemonRepository.save(pokemonTest);

        attaqueRepository.delete(attaqueTest);
        attaqueRepository.delete(attaqueTest2);

        //supprime Pokemon
        pokemonRepository.delete(pokemonTest);
    }

    @Test
    public void testPokemonServiceAjoutOk() throws Exception {
        //Given
        Long idPokemon = pokemonTest.getPokemonId();
        Long idAttaque = attaqueTest2.getAttaqueId();

        //When
        Pokemon p = pokemonService.AjoutAttaque(idPokemon, idAttaque);

        //Then
        //Pokemon non nul
        Assert.assertTrue(p != null);
        // Avoir l'attaque
        Assert.assertTrue(p.getAttaques().contains(attaqueTest2));
    }

    @Test
    public void testPokemonServiceAjoutAttaqueExisteDeja() throws Exception {
        //Given
        Long idPokemon = pokemonTest.getPokemonId();
        Long idAttaque = attaqueTest.getAttaqueId();

        //When
        try {
            Pokemon p = pokemonService.AjoutAttaque(idPokemon, idAttaque);
            Assert.fail();
        }
        catch (Exception e){
            Assert.assertEquals(e.getMessage(), "Le pokemon (id : " + idPokemon + ") connaît déjà l'attaque choisie (id : " + idAttaque + ")");
        }

        //Then
    }

    @Test
    public void testPokemonAjoutAttaqueIncorrect() throws Exception {
        //Given
        Long idPokemon = pokemonTest.getPokemonId();
        Long idAttaque = 768L;

        //When
        try {
            Pokemon p = pokemonService.AjoutAttaque(idPokemon, idAttaque);
            Assert.fail();
        }
        catch (Exception e){
            Assert.assertEquals(e.getMessage(), "L'id de l'attaque est incorrect : " + idAttaque);
        }

        //Then
    }

    @Test
    public void testPokemonAjoutPokemonIncorrect() throws Exception {
        //Given
        Long idPokemon = 678L;
        Long idAttaque = attaqueTest.getAttaqueId();

        //When
        try {
            Pokemon p = pokemonService.AjoutAttaque(idPokemon, idAttaque);
            Assert.fail();
        }
        catch (Exception e){
            Assert.assertEquals(e.getMessage(), "L'id du pokemon est incorrect : " + idPokemon);
        }

        //Then
    }
}
