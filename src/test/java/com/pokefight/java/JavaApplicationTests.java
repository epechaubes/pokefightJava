package com.pokefight.java;

import com.pokefight.java.Repository.PokemonRepository;
import com.pokefight.java.model.Attaque;
import com.pokefight.java.model.Pokemon;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaApplicationTests {

	@Autowired
	private PokemonRepository pokemonRepository;


	@Test
	public void testConnexionBdd() {
	    // Test de la connexion à la base de donnée

        //Given

        //When
        Long nbPokemon = pokemonRepository.count();

        //Then
        Assert.assertTrue(nbPokemon > 0);
    }

    @Test
    public void testRelation() {
	    // Test de la relation Many to Many entre pokemon et attaque

	    //Given
        Pokemon p = pokemonRepository.findOne(3L);

        //When
        List<Attaque> listAttaque = p.getAttaques();

        //Then
        for (Attaque attaque : listAttaque){
            System.out.println(attaque.getAttaqueId());
        }
	}






}

