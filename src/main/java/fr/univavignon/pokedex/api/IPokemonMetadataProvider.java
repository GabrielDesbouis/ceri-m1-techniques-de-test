package fr.univavignon.pokedex.api;

/**
 * An IPokemonMetadataProvider aims to provide PokemonMetadata
 * for a given pokemon index.
 *
 * @author fv
 */
public interface IPokemonMetadataProvider {

    /**
     * Retrieves and returns the metadata for the pokemon
     * denoted by the given index.
     *
     * @param index Index of the pokemon to retrieve metadata for.
     * @return Metadata of the pokemon.
     * @throws PokedexException If the given index is not valid.
     */
    PokemonMetadata getPokemonMetadata(int index) throws PokedexException;

}
