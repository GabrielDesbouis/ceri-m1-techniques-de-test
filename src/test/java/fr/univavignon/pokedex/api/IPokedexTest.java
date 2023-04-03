package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexTest {

    private IPokedex pokedex;

    public static IPokedex getPokedex() {
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
        IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(mock(IPokedex.class));
        return pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
    }

    @Before
    public void setUp() throws Exception {
        pokedex = getPokedex();
        when(pokedex.size()).thenReturn(0);
        Pokemon pokemon = mock(Pokemon.class);
        when(pokedex.addPokemon(pokemon)).thenReturn(0).then((Answer<?>) when(pokedex.size()).thenReturn(pokedex.size()+1));


    }

    @BeforeEach
    public void setUpEach() throws Exception {
        pokedex = getPokedex();
    }

    @Test
    public void testSize() {
        assert (pokedex.size() == 0);
    }


    @Test
    public void testAddPokemon() {
        Pokemon pokemon = mock(Pokemon.class);
        int size = pokedex.size();
        pokedex.addPokemon(pokemon);
        assert (pokedex.size() == size + 1);
    }

    @Test
    public void testGetPokemon() {
    }

    @Test
    public void testGetPokemons() {
    }

    @Test
    public void testTestGetPokemons() {
    }
}
