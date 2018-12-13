package com.pokefight.java.Repository;

import com.pokefight.java.model.Pokemon;
import org.springframework.data.repository.CrudRepository;

public interface PokemonRepository extends CrudRepository<Pokemon,Long> {
}
