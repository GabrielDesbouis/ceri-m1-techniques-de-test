package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProvider
        implements IPokemonMetadataProvider {

    /**
     * List of all known pokemons metadata.
     */
    private List<PokemonMetadata> pokemonMetadataList;


    /**
     * Default constructor.
     */
    @SuppressWarnings("checkstyle:MagicNumber")
    public PokemonMetadataProvider() {
        this.pokemonMetadataList = new ArrayList<>();
        pokemonMetadataList.add(
                new PokemonMetadata(0, "Bulbizare", 126, 126, 90));
        pokemonMetadataList.add(
                new PokemonMetadata(133, "Aquali", 186, 168, 260));

    }

    /**
     * @param index Index of the pokemon to retrieve metadata for.
     * @return Metadata of the pokemon.
     * @throws PokedexException If the given index is not valid.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(final int index)
            throws PokedexException {
        if (index < 0 || index >= 199) {
            throw new PokedexException("Invalid index");
        } else {
            for (PokemonMetadata pokemonMetadata : pokemonMetadataList) {
                if (pokemonMetadata.getIndex() == index) {
                    return pokemonMetadata;
                }
            }
        }
        return null;
    }

}
