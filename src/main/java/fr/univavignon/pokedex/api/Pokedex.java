package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Pokedex API.
 */
public class Pokedex implements IPokedex {

    /**
     * Metadata provider the created pokedex will use.
     */
    private IPokemonMetadataProvider metadataProvider;

    /**
     * Pokemon factory the created pokedex will use.
     */
    private IPokemonFactory pokemonFactory;

    /**
     * List of pokemons this pokedex contains.
     */
    private List<Pokemon> pokemons;

    /**
     * Default constructor.
     *
     * @param metadataProvider Metadata provider the created pokedex will use.
     * @param pokemonFactory   Pokemon factory the created pokedex will use.
     */
    @SuppressWarnings("checkstyle:HiddenField")
    public Pokedex(final IPokemonMetadataProvider metadataProvider,
                   final IPokemonFactory pokemonFactory) {
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
        this.pokemons = new ArrayList<>();
    }

    /**
     * @return Number of pokemons this pokedex contains.
     */
    @Override
    public int size() {
        return this.pokemons.size();
    }

    /**
     * @param pokemon Pokemon to add to this pokedex.
     * @return Index of this pokemon relative to this pokedex.
     */
    @Override
    public int addPokemon(final Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemon.getIndex();
    }

    /**
     * @param id Unique pokedex relative identifier.
     * @return Pokemon denoted by the given identifier.
     * @throws PokedexException If the given index is not valid.
     */
    @SuppressWarnings("checkstyle:MagicNumber")
    @Override
    public Pokemon getPokemon(final int id) throws PokedexException {
        if (id < 0 || id >= 199) {
            throw new PokedexException("Invalid index");
        } else {
            for (Pokemon pokemon : pokemons) {
                if (pokemon.getIndex() == id) {
                    return pokemon;
                }
            }
        }
        return null;
    }

    /**
     * @return Unmodifiable list of all pokemons.
     */
    @Override
    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    /**
     * @param order Comparator instance used for sorting the created view.
     * @return Sorted unmodifiable list of all pokemons.
     */
    @Override
    public List<Pokemon> getPokemons(final Comparator<Pokemon> order) {
        List<Pokemon> sortedPokemons = new ArrayList<>(pokemons);
        sortedPokemons.sort(order);
        return sortedPokemons;
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
                                 final int candy) throws PokedexException {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    /**
     * @param index Index of the pokemon to retrieve metadata for.
     * @return Pokemon metadata.
     * @throws PokedexException If the given index is not valid.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(final int index)
            throws PokedexException {
        return metadataProvider.getPokemonMetadata(index);
    }
}
