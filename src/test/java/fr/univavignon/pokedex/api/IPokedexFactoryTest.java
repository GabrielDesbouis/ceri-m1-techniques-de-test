package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class IPokedexFactoryTest {

    public static IPokedexFactory getPokedexFactory() {
        return mock(IPokedexFactory.class);
    }

    @Before
    public void setUp() throws Exception {
        IPokedexFactory pokedexFactory = getPokedexFactory();
    }

    @Test
    public void testTestCreatePokedex() {


    }

}
