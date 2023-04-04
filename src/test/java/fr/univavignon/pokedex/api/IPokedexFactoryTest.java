package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest {

    private IPokedex pokedex;

    public static IPokedexFactory getPokedexFactory() {
        return mock(IPokedexFactory.class);
    }

    @Before
    public void setUp() throws Exception {
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
        IPokemonMetadataProvider pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        pokedex = mock(IPokedex.class);
        when(getPokedexFactory().createPokedex(pokemonMetadataProvider, pokemonFactory)).thenReturn(pokedex);
    }

    @Test
    public void testCreatePokedex() {
        assertNotNull(pokedex);
    }

}
