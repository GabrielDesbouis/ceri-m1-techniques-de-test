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

    /**
     * Test getTeam.
     */
    @Test
    public void testGetTeam() {
        PokemonTrainer trainer =
                pokemonTrainerFactory.createTrainer(name, Team.MYSTIC, pokedex);
        Assert.assertEquals(trainer.getTeam(), Team.MYSTIC);
    }

    /**
     * Test getPokedex returns a IPokedex instance.
     */
    @Test
    public void testGetPokedex() {
        Assert.assertEquals(pokemonTrainerFactory.createTrainer(name,
                Team.MYSTIC, pokedex).getPokedex().getClass(), Pokedex.class);
    }
}
