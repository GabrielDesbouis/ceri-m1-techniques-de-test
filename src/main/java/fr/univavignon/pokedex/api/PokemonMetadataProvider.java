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
        final int bulbizareIndex = 0;
        final int bulbizareAttack = 126;
        final int bulbizareDefense = 126;
        final int bulbizareStamina = 90;
        final int aqualiIndex = 133;
        final int aqualiAttack = 186;
        final int aqualiDefense = 168;
        final int aqualiStamina = 260;
        this.pokemonMetadataList = new ArrayList<>();
        pokemonMetadataList.add(
                new PokemonMetadata(bulbizareIndex, "Bulbizare",
                        bulbizareAttack, bulbizareDefense, bulbizareStamina));
        pokemonMetadataList.add(
                new PokemonMetadata(aqualiIndex, "Aquali", aqualiAttack,
                        aqualiDefense, aqualiStamina));

    }

    /**
     * @param index Index of the pokemon to retrieve metadata for.
     * @return Metadata of the pokemon.
     * @throws PokedexException If the given index is not valid.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(final int index)
            throws PokedexException {
        final int maxIndex = 199;
        if (index < 0 || index >= maxIndex) {
            throw new PokedexException("Invalid index");
        } else {
            for (PokemonMetadata pokemonMetadata : pokemonMetadataList) {
                if (pokemonMetadata.getIndex() == index) {
                    return pokemonMetadata;
                }
            }
        }
        throw new PokedexException("Introuvable");
    }

}
