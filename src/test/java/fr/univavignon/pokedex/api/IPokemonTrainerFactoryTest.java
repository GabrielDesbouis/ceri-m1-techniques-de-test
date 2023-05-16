package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test interface for IPokemonTrainerFactory.
 */
public class IPokemonTrainerFactoryTest {

    /**
     * PokedexTrainer factory.
     */
    private IPokemonTrainerFactory pokemonTrainerFactory;


    /**
     * Pokedex.
     */
    private IPokedexFactory pokedex;

    /**
     * Trainer name.
     */
    private String name = "test";


    /**
     * Set up.
     */
    @Before
    public void setUp() {
        pokedex = new PokedexFactory();
        pokemonTrainerFactory = new PokemonTrainerFactory();
    }

    /**
     * Test createTrainer.
     */
    @Test
    public void testCreateTrainer() {
        PokemonTrainer trainer =
                pokemonTrainerFactory.createTrainer(name, Team.MYSTIC, pokedex);
        PokemonTrainer trainer1 = new PokemonTrainer(name, Team.MYSTIC,
                pokedex.createPokedex(new PokemonMetadataProvider(),
                        new PokemonFactory()));
        Assert.assertEquals(trainer.getName(), trainer1.getName());
    }
}
