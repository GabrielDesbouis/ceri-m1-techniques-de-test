package fr.univavignon.pokedex.api;

/**
 * Factory interface for class that aims to create PokemonMetadata instance.
 */
public class PokedexFactory
        implements IPokedexFactory {

    /**
     * @param metadataProvider Metadata provider the created pokedex will use.
     * @param pokemonFactory   Pokemon factory the created pokedex will use.
     * @return Created pokedex instance.
     */
    @Override
    public IPokedex createPokedex(
            final IPokemonMetadataProvider metadataProvider,
            final IPokemonFactory pokemonFactory) {
        return new Pokedex(metadataProvider, pokemonFactory);
    }
}
