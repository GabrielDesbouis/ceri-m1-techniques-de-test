package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test interface for IPokedexFactory.
 */
public class IPokedexFactoryTest {

    /**
     * Factory.
     */
    IPokedexFactory pokedexFactory;

    /**
     * Mock of IPokemonMetadataProvider.
     */
    IPokemonMetadataProvider pokemonMetadataProvider;

    /**
     * Mock of IPokemonFactory.
     */
    IPokemonFactory pokemonFactory;

    /**
     * Set up.
     */
    @Before
    public void setUp() {
        pokemonMetadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory();
        pokedexFactory = new PokedexFactory();
    }

    /**
     * Test createPokedex.
     */
    @Test
    public void testCreatePokedex() {
        IPokedex pokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);
        Assert.assertEquals(
                pokedexFactory.createPokedex(pokemonMetadataProvider,
                        pokemonFactory).getClass(), pokedex.getClass());
        Assert.assertEquals(
                pokedexFactory.createPokedex(pokemonMetadataProvider,
                        pokemonFactory).size(), pokedex.size());
        Assert.assertEquals(
                pokedexFactory.createPokedex(pokemonMetadataProvider,
                        pokemonFactory).getPokemons(), pokedex.getPokemons());
    }

}
