package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class IPokedexTest {

    private IPokedex pokedex;

    private PokemonComparators comparator;
    private Pokemon Bulbizare;
    private Pokemon Aquali;

    @Before
    public void setUp() throws Exception {
        PokemonMetadataProvider pokemonMetadataProvider =
                new PokemonMetadataProvider();
        IPokemonFactory pokemonFactory = new PokemonFactory();
        this.pokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);
        Bulbizare = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4,
                56);
        Aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 8,
                100);
        pokedex.addPokemon(Bulbizare);
        pokedex.addPokemon(Aquali);
        comparator = PokemonComparators.NAME;
    }


    /**
     * Should return a pokedex instance
     */
    @Test
    public void testCreatePokedex() {
        Assert.assertNotNull(pokedex);
    }

    /**
     * Should return 0 when compare two same pokemons
     * Should return 1 when compare Bulbizare and Aquali
     * Should return -1 when compare Aquali and Bulbizare
     */
    @Test
    public void testPokemonComparator() {
        Assert.assertEquals(0, comparator.compare(Bulbizare, Bulbizare));
        Assert.assertEquals(1, comparator.compare(Bulbizare, Aquali));
        Assert.assertEquals(-1, comparator.compare(Aquali, Bulbizare));
    }

    /**
     * Should return 2 when get size
     */
    @Test
    public void testSize() {
        Assert.assertEquals(2, pokedex.size());
    }




    /**
     * Should return Bulbizare when getPokemon(0)
     * Should return Aquali when getPokemon(133)
     */
    @Test
    public void testGetPokemon() throws PokedexException {
        Assert.assertEquals(Bulbizare, pokedex.getPokemon(0));
        Assert.assertEquals("Bulbizarre", pokedex.getPokemon(0).getName());
        Assert.assertEquals(0, pokedex.getPokemon(0).getIndex());

        Assert.assertEquals(Aquali, pokedex.getPokemon(133));
        Assert.assertEquals("Aquali", pokedex.getPokemon(133).getName());
        Assert.assertEquals(133, pokedex.getPokemon(133).getIndex());
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> pokemons = pokedex.getPokemons();
        pokemons.add(Bulbizare);
        pokemons.add(Aquali);

        Assert.assertEquals(pokemons, pokedex.getPokemons());

    }

    @Test
    public void testGetPokemonsWithOrder() {
        List<Pokemon> pokemonsOrdered = Arrays.asList(Aquali, Bulbizare);
        Assert.assertEquals(pokemonsOrdered, pokedex.getPokemons(comparator));
    }

    @Test
    public void testGetters() throws PokedexException {
        Assert.assertEquals(0, pokedex.getPokemon(0).getIndex());
        Assert.assertEquals("Bulbizarre", pokedex.getPokemon(0).getName());
        Assert.assertEquals(126, pokedex.getPokemon(0).getAttack());
        Assert.assertEquals(126, pokedex.getPokemon(0).getDefense());
        Assert.assertEquals(90, pokedex.getPokemon(0).getStamina());
        Assert.assertEquals(613, pokedex.getPokemon(0).getCp());
        Assert.assertEquals(64, pokedex.getPokemon(0).getHp());
        Assert.assertEquals(4000, pokedex.getPokemon(0).getDust());
        Assert.assertEquals(4, pokedex.getPokemon(0).getCandy());
        Assert.assertEquals(56, pokedex.getPokemon(0).getIv(), 0.0);
    }

    /**
     * Should throw PokedexException when index is greater than list size
     */
    @Test
    public void exceptionPokedexTestIndexGreater() {
        Assert.assertThrows(PokedexException.class,
                () -> pokedex.getPokemon(500000));
    }

    /**
     * Should throw PokedexException when index is negative
     */
    @Test
    public void exceptionPokedexTestNegativeIndex() {
        Assert.assertThrows(PokedexException.class,
                () -> pokedex.getPokemon(-200));
    }

    /**
     * Should return 0 then 1 when add Bulbizare and Aquali
     */
    @Test
    public void testAddPokemon() {
        int index = pokedex.addPokemon(Bulbizare);
        Assert.assertEquals(index, Bulbizare.getIndex());

        int index2 = pokedex.addPokemon(Bulbizare);
        Assert.assertEquals(index2, Bulbizare.getIndex());
    }
}
