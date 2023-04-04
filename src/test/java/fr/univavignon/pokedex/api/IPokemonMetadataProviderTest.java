package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import java.util.Objects;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {

    private PokemonMetadata bulbizarreMetadata;

    public static IPokemonMetadataProvider getPokemonMetadataProvider() {
        return mock(IPokemonMetadataProvider.class);
    }

    @Before
    public void setUp() throws Exception {
        bulbizarreMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        IPokemonMetadataProvider pokemonMetadataProvider = getPokemonMetadataProvider();
        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(bulbizarreMetadata);
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        IPokemonMetadataProvider pokemonMetadataProvider = getPokemonMetadataProvider();
        assert (bulbizarreMetadata != null);
    }
}
