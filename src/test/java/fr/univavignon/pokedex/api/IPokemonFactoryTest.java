package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test interface for IPokemonFactory.
 */
public class IPokemonFactoryTest {

    /**
     * Pokemon.
     */
    private Pokemon pokemon;

    /**
     * Get Pokemon factory.
     *
     * @return
     */
    public static IPokemonFactory getPokemonFactory() {
        return mock(IPokemonFactory.class);
    }

    /**
     * Set up.
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        Pokemon pokemon =
                new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4,
                        56);
        when(getPokemonFactory().createPokemon(0, 0, 0, 0, 0)).thenReturn(
                pokemon);
    }

    /**
     * Should return a pokemon instance.
     *
     * @throws PokedexException
     */
    @Test
    public void testCreatePokemon() throws PokedexException {
        assert (getPokemonFactory().createPokemon(0, 0, 0, 0, 0) == pokemon);
    }
}
