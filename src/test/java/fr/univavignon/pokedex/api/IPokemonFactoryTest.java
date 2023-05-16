package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test interface for IPokemonFactory.
 */
public class IPokemonFactoryTest {

    /**
     * Pokemon.
     */
    private Pokemon pokemon;

    /**
     * PokemonFactory.
     */
    private IPokemonFactory pokemonFactory;

    /**
     * Set up.
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        pokemon = new Pokemon(0, "Bulbizare", 126, 126, 90, 613, 64, 4000, 4,
                0.56);
        pokemonFactory = new PokemonFactory();
    }

    /**
     * Should return a pokemon instance.
     *
     * @throws PokedexException
     */
    @Test
    public void testCreatePokemon() throws PokedexException {
        Pokemon pokemonTest = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        Assert.assertEquals(pokemonTest.getIndex(), pokemon.getIndex());
        Assert.assertEquals(pokemonTest.getCp(), pokemon.getCp());
        Assert.assertEquals(pokemonTest.getHp(), pokemon.getHp());
        Assert.assertEquals(pokemonTest.getDust(), pokemon.getDust());
        Assert.assertEquals(pokemonTest.getCandy(), pokemon.getCandy());
    }

    /**
     * Should throw an exception.
     *
     * @throws PokedexException
     */
    @Test
    public void testCreatePokemonException() throws PokedexException {
        try {
            pokemonFactory.createPokemon(-1, 613, 64, 4000, 4);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Invalid index", e.getMessage());
        }
    }

    /**
     * Should throw an exception.
     *
     * @throws PokedexException
     */
    @Test
    public void testCreatePokemonException2() throws PokedexException {
        try {
            pokemonFactory.createPokemon(200, 613, 64, 4000, 4);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Invalid index", e.getMessage());
        }
    }


}
