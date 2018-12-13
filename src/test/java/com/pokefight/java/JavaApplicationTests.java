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
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaApplicationTests {

	@Autowired
	private PokemonRepository pokemonRepository;

	@Test
	public void testConnexionBdd() {
	    //Given

        //When
        Pokemon p = pokemonRepository.findOne(3L);
        List<Attaque> listAttaque = p.getAttaques();
        for (Attaque attaque : listAttaque){
            System.out.println(attaque.getAttaqueId());
        }

        //Then

	}

}

