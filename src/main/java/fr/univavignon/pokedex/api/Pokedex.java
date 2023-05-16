package fr.univavignon.pokedex.api;

import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {
    /**
     * @return Number of pokemons this pokedex contains.
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * @param pokemon Pokemon to add to this pokedex.
     * @return Index of this pokemon relative to this pokedex.
     */
    @Override
    public int addPokemon(final Pokemon pokemon) {
        return 0;
    }

    /**
     * @param id Unique pokedex relative identifier.
     * @return Pokemon denoted by the given identifier.
     * @throws PokedexException If the given index is not valid.
     */
    @Override
    public Pokemon getPokemon(final int id) throws PokedexException {
        return null;
    }

    /**
     * @return Unmodifiable list of all pokemons.
     */
    @Override
    public List<Pokemon> getPokemons() {
        return null;
    }

    /**
     * @param order Comparator instance used for sorting the created view.
     * @return Sorted unmodifiable list of all pokemons.
     */
    @Override
    public List<Pokemon> getPokemons(final Comparator<Pokemon> order) {
        return null;
    }

    /**
     * @param index Pokemon index.
     * @param cp    Pokemon CP.
     * @param hp    Pokemon HP.
     * @param dust  Required dust for upgrading pokemon.
     * @param candy Required candy for upgrading pokemon.
     * @return Created pokemon instance.
     */
    @Override
    public Pokemon createPokemon(final int index, final int cp, final int hp,
                                 final int dust,
                                 final int candy) {
        return null;
    }

    /**
     * @param index Index of the pokemon to retrieve metadata for.
     * @return Pokemon metadata.
     * @throws PokedexException If the given <tt>index</tt> is not valid.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(final int index)
            throws PokedexException {
        return null;
    }
}
