package com.pokefight.java.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Pokemons")
public class Pokemon {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Connaitre",
            joinColumns = @JoinColumn(name = "ID_POKEMON"),
            inverseJoinColumns = @JoinColumn(name = "ID_ATTAQUE"))

    private List<Attaque> attaques;

    @Id
    @Column(name = "ID_POKEMON")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pokemonId;

    @Column(name = "NOM_POKEMON_POK")
    private String nomPokemon;

    @Column(name = "TYPE_POK")
    private String typePokemon;

    public List<Attaque> getAttaques() {
        return attaques;
    }

    public void setAttaques(List<Attaque> attaques) {
        this.attaques = attaques;
    }

    @Column(name = "POINT_DE_VIE_POK")
    private Integer pdvPokemon;

    @Column(name = "ATTAQUE_POK")
    private Integer attaquePokemon;

    @Column(name = "DEFENSE_POK")
    private Integer defensePokemon;

    @Column(name = "ATTAQUE_SPE_POK")
    private Integer attaqueSpePokemon;

    @Column(name = "DEFENSE_SPE_POK")
    private Integer defenseSpePokemon;

    @Column(name = "VITESSE_POK")
    private Integer vitessePokemon;

    public Pokemon(List<Attaque> attaques, Long pokemonId, String nomPokemon, String typePokemon, Integer pdvPokemon, Integer attaquePokemon, Integer defensePokemon, Integer attaqueSpePokemon, Integer defenseSpePokemon, Integer vitessePokemon) {
        this.attaques = attaques;
        this.pokemonId = pokemonId;
        this.nomPokemon = nomPokemon;
        this.typePokemon = typePokemon;
        this.pdvPokemon = pdvPokemon;
        this.attaquePokemon = attaquePokemon;
        this.defensePokemon = defensePokemon;
        this.attaqueSpePokemon = attaqueSpePokemon;
        this.defenseSpePokemon = defenseSpePokemon;
        this.vitessePokemon = vitessePokemon;
    }

    public Long getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(Long pokemonId) {
        this.pokemonId = pokemonId;
    }

    public String getNomPokemon() {
        return nomPokemon;
    }

    public void setNomPokemon(String nomPokemon) {
        this.nomPokemon = nomPokemon;
    }

    public String getTypePokemon() {
        return typePokemon;
    }

    public void setTypePokemon(String typePokemon) {
        this.typePokemon = typePokemon;
    }

    public Integer getPdvPokemon() {
        return pdvPokemon;
    }

    public void setPdvPokemon(Integer pdvPokemon) {
        this.pdvPokemon = pdvPokemon;
    }

    public Integer getAttaquePokemon() {
        return attaquePokemon;
    }

    public void setAttaquePokemon(Integer attaquePokemon) {
        this.attaquePokemon = attaquePokemon;
    }

    public Integer getDefensePokemon() {
        return defensePokemon;
    }

    public void setDefensePokemon(Integer defensePokemon) {
        this.defensePokemon = defensePokemon;
    }

    public Integer getAttaqueSpePokemon() {
        return attaqueSpePokemon;
    }

    public void setAttaqueSpePokemon(Integer attaqueSpePokemon) {
        this.attaqueSpePokemon = attaqueSpePokemon;
    }

    public Integer getDefenseSpePokemon() {
        return defenseSpePokemon;
    }

    public void setDefenseSpePokemon(Integer defenseSpePokemon) {
        this.defenseSpePokemon = defenseSpePokemon;
    }

    public Integer getVitessePokemon() {
        return vitessePokemon;
    }

    public void setVitessePokemon(Integer vitessePokemon) {
        this.vitessePokemon = vitessePokemon;
    }
}
