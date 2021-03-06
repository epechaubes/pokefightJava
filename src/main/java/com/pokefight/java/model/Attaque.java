package com.pokefight.java.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Attaque")
public class Attaque {

    @ManyToMany(mappedBy = "attaques", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Pokemon> pokemon = new ArrayList<>();

    @Id
    @Column(name = "ID_ATTAQUE")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attaqueId;

    @Column(name = "NOM_ATTAQUE_AT")
    private String nomAttaque;

    @Column(name = "PUISSANCE_AT")
    private Integer puissanceAttaque;

    @Column(name = "PRECISION_AT")
    private Integer precisionAttaque;

    @Column(name = "TYPE_AT")
    private String typePokemon;

    @Column(name = "GENRE_AT")
    private String genreAttaque;

    public Attaque(String nomAttaque, Integer puissanceAttaque, Integer precisionAttaque, String typePokemon, String genreAttaque) {
        this.nomAttaque = nomAttaque;
        this.puissanceAttaque = puissanceAttaque;
        this.precisionAttaque = precisionAttaque;
        this.typePokemon = typePokemon;
        this.genreAttaque = genreAttaque;
    }

    public Attaque() {
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    public Long getAttaqueId() {
        return attaqueId;
    }

    public void setAttaqueId(Long attaqueId) {
        this.attaqueId = attaqueId;
    }

    public String getNomAttaque() {
        return nomAttaque;
    }

    public void setNomAttaque(String nomAttaque) {
        this.nomAttaque = nomAttaque;
    }

    public Integer getPuissanceAttaque() {
        return puissanceAttaque;
    }

    public void setPuissanceAttaque(Integer puissanceAttaque) {
        this.puissanceAttaque = puissanceAttaque;
    }

    public Integer getPrecisionAttaque() {
        return precisionAttaque;
    }

    public void setPrecisionAttaque(Integer precisionAttaque) {
        this.precisionAttaque = precisionAttaque;
    }

    public String getTypePokemon() {
        return typePokemon;
    }

    public void setTypePokemon(String typePokemon) {
        this.typePokemon = typePokemon;
    }

    public String getGenreAttaque() {
        return genreAttaque;
    }

    public void setGenreAttaque(String genreAttaque) {
        this.genreAttaque = genreAttaque;
    }
}
