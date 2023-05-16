package fr.univavignon.pokedex.api;

public class PokemonMetadataProvider
        implements IPokemonMetadataProvider {
    /**
     * @param index Index of the pokemon to retrieve metadata for.
     * @return Metadata of the pokemon.
     * @throws PokedexException If the given index is not valid.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(final int index)
            throws PokedexException {
        return null;
    }
}
