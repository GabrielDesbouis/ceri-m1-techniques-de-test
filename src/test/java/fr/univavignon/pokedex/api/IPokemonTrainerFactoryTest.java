package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {

    public static IPokemonTrainerFactory getPokemonTrainerFactory() {
        return mock(IPokemonTrainerFactory.class);
    }

    private IPokemonTrainerFactory pokemonTrainerFactory = getPokemonTrainerFactory();
    private PokemonTrainer pokemonTrainer = mock(PokemonTrainer.class);
    private IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);
    private String name = "test";


    @Before
    public void setUp() throws Exception {
        when(pokemonTrainerFactory.createTrainer(name, Team.MYSTIC, pokedexFactory)).thenReturn(pokemonTrainer);
    }

    @Test
    public void testCreateTrainer() {
        assert (pokemonTrainerFactory.createTrainer("test", Team.MYSTIC, pokedexFactory) == pokemonTrainer);
    }
}
