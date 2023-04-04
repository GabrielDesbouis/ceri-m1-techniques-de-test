package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {

    public static IPokemonFactory getPokemonFactory() {
        return mock(IPokemonFactory.class);
    }

    private Pokemon pokemon;

    @Before
    public void setUp() throws Exception {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000,4, 56);
        when(getPokemonFactory().createPokemon(0,0,0,0,0)).thenReturn(pokemon);
    }

    @Test
    public void testCreatePokemon() {
        assert (getPokemonFactory().createPokemon(0,0,0,0,0) == pokemon);
    }
}
