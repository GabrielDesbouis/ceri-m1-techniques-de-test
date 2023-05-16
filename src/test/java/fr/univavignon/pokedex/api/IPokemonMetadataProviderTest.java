package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class IPokemonMetadataProviderTest {

    /**
     * PokemonMetadata.
     */
    private PokemonMetadata bulbizarreMetadata;

    /**
     * PokemonMetadataProvider.
     */
    private IPokemonMetadataProvider pokemonMetadataProvider;

    /**
     * PokemonMetadataProvider.
     */
    private IPokemonMetadataProvider pokemonMetadataProviderSecond;

    /**
     * PokemonMetadata.
     */
    private PokemonMetadata aqualiMetadata;

    /**
     * PokemonFactory.
     */
    private IPokemonFactory pokemonFactory;

    /**
     * Pokedex.
     */
    private Pokedex pokedex;

    /**
     * Set up.
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        pokemonMetadataProvider = new PokemonMetadataProvider();
        pokemonMetadataProviderSecond = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory();
        pokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);
        bulbizarreMetadata =
                new PokemonMetadata(0, "Bulbizare", 126, 126, 90);
        aqualiMetadata =
                new PokemonMetadata(133, "Aquali", 186, 168, 260);
    }

    /**
     * Should return a PokemonMetadata instance.
     *
     * @throws PokedexException
     */
    @Test
    public void testGetPokemonMetadataName() throws PokedexException {
        Assert.assertEquals(
                pokemonMetadataProvider.getPokemonMetadata(0).getName(),
                "Bulbizare");
        Assert.assertEquals(
                pokemonMetadataProvider.getPokemonMetadata(133).getName(),
                "Aquali");
    }

    /**
     * Should return a PokemonMetadata instance.
     *
     * @throws PokedexException
     */
    @Test
    public void testGetPokemonMetadataIndex() throws PokedexException {
        assert (pokemonMetadataProvider.getPokemonMetadata(0).getIndex() == 0);
        assert (pokemonMetadataProvider.getPokemonMetadata(133).getIndex() ==
                133);
    }

    /**
     * Should return a PokemonMetadata instance.
     *
     * @throws PokedexException
     */
    @Test
    public void testGetPokemonMetadataAttack() throws PokedexException {
        assert (pokemonMetadataProvider.getPokemonMetadata(0).getAttack() ==
                126);
        assert (pokemonMetadataProvider.getPokemonMetadata(133).getAttack() ==
                186);
    }

    /**
     * Should return a PokemonMetadata instance.
     *
     * @throws PokedexException
     */
    @Test
    public void testGetPokemonMetadataDefense() throws PokedexException {
        assert (pokemonMetadataProvider.getPokemonMetadata(0).getDefense() ==
                126);
        assert (pokemonMetadataProvider.getPokemonMetadata(133).getDefense() ==
                168);
    }

    /**
     * Should return a PokemonMetadata instance.
     *
     * @throws PokedexException
     */
    @Test
    public void testGetPokemonMetadataStamina() throws PokedexException {
        assert (pokemonMetadataProvider.getPokemonMetadata(0).getStamina() ==
                90);
        assert (pokemonMetadataProvider.getPokemonMetadata(133).getStamina() ==
                260);
    }

    /**
     * Should return a PokemonMetadata instance.
     *
     * @throws PokedexException
     */
    @Test
    public void testGetPokemonMetadataEqualsSame() throws PokedexException {
        assert (pokemonMetadataProvider.getPokemonMetadata(0)
                .equals(pokemonMetadataProvider.getPokemonMetadata(0)));
        assert (pokemonMetadataProvider.getPokemonMetadata(133)
                .equals(pokemonMetadataProvider.getPokemonMetadata(133)));
    }

    /**
     * Should return a PokemonMetadata instance.
     *
     * @throws PokedexException
     */
    @Test
    public void testGetPokemonMetadataEqualsNull() throws PokedexException {
        assert (pokemonMetadataProvider.getPokemonMetadata(0) != null);
        assert (pokemonMetadataProvider.getPokemonMetadata(133) != null);
    }

    /**
     * Should return a PokemonMetadata instance.
     *
     * @throws PokedexException
     */
    @Test
    public void testMetaDataProviderEqualsNull() throws PokedexException {
        assert (pokemonMetadataProvider != null);
        assert (pokemonMetadataProviderSecond != null);
    }

    /**
     * Should return a PokemonMetadata instance.
     *
     * @throws PokedexException
     */
    @Test
    public void testMetaDataInstance() throws PokedexException {
        Assert.assertThrows(PokedexException.class, () -> {
            pokemonMetadataProvider.getPokemonMetadata(151);
        });
    }

}
