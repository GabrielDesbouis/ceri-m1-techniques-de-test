package fr.univavignon.pokedex.api;

public class PokemonFactory
        implements IPokemonFactory {
    /**
     * @param index Pokemon index.
     * @param cp    Pokemon CP.
     * @param hp    Pokemon HP.
     * @param dust  Required dust for upgrading pokemon.
     * @param candy Required candy for upgrading pokemon.
     * @return Created pokemon instance.
     */
    @SuppressWarnings("checkstyle:MagicNumber")
    @Override
    public Pokemon createPokemon(final int index, final int cp, final int hp,
                                 final int dust,
                                 final int candy) throws PokedexException {

        final int maxIndex = 199;
        final double constant = 100.0;
        if (index < 0 || index >= maxIndex) {
            throw new IllegalArgumentException("Invalid index");
        } else {
            PokemonMetadata pokemonMetadata =
                    new PokemonMetadataProvider().getPokemonMetadata(index);
            return new Pokemon(index, pokemonMetadata.getName(),
                    pokemonMetadata.getAttack(),
                    pokemonMetadata.getDefense(),
                    pokemonMetadata.getStamina(), cp, hp, dust, candy,
                    constant * (cp + hp + dust + candy)
                            / pokemonMetadata.getAttack());
        }

    }
}
