package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class IPokemonMetadataProviderTest {

    private PokemonMetadata bulbizarreMetadata;
    private IPokemonMetadataProvider pokemonMetadataProvider;
    private IPokemonMetadataProvider pokemonMetadataProviderSecond;
    private PokemonMetadata aqualiMetadata;

    private IPokemonFactory pokemonFactory;

    private Pokedex pokedex;

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

    @Test
    public void testGetPokemonMetadataName() throws PokedexException {
        Assert.assertEquals(pokemonMetadataProvider.getPokemonMetadata(0).getName(),"Bulbizare");
        Assert.assertEquals(pokemonMetadataProvider.getPokemonMetadata(133).getName(), "Aquali");
    }

    @Test
    public void testGetPokemonMetadataIndex() throws PokedexException {
        assert (pokemonMetadataProvider.getPokemonMetadata(0).getIndex() == 0);
        assert (pokemonMetadataProvider.getPokemonMetadata(133).getIndex() ==
                133);
    }

    @Test
    public void testGetPokemonMetadataAttack() throws PokedexException {
        assert (pokemonMetadataProvider.getPokemonMetadata(0).getAttack() ==
                126);
        assert (pokemonMetadataProvider.getPokemonMetadata(133).getAttack() ==
                186);
    }

    @Test
    public void testGetPokemonMetadataDefense() throws PokedexException {
        assert (pokemonMetadataProvider.getPokemonMetadata(0).getDefense() ==
                126);
        assert (pokemonMetadataProvider.getPokemonMetadata(133).getDefense() ==
                168);
    }

    @Test
    public void testGetPokemonMetadataStamina() throws PokedexException {
        assert (pokemonMetadataProvider.getPokemonMetadata(0).getStamina() ==
                90);
        assert (pokemonMetadataProvider.getPokemonMetadata(133).getStamina() ==
                260);
    }

    @Test
    public void testGetPokemonMetadataEqualsSame() throws PokedexException {
        assert (pokemonMetadataProvider.getPokemonMetadata(0)
                .equals(pokemonMetadataProvider.getPokemonMetadata(0)));
        assert (pokemonMetadataProvider.getPokemonMetadata(133)
                .equals(pokemonMetadataProvider.getPokemonMetadata(133)));
    }

    @Test
    public void testGetPokemonMetadataEqualsNull() throws PokedexException {
        assert (pokemonMetadataProvider.getPokemonMetadata(0) != null);
        assert (pokemonMetadataProvider.getPokemonMetadata(133) != null);
    }

    @Test
    public void testMetaDataProviderEqualsNull() throws PokedexException {
        assert (pokemonMetadataProvider != null);
        assert (pokemonMetadataProviderSecond != null);
    }

    @Test
    public void testMetaDataInstance() throws PokedexException {
        Assert.assertThrows(PokedexException.class, () -> {
            pokemonMetadataProvider.getPokemonMetadata(151);
        });
    }

}
