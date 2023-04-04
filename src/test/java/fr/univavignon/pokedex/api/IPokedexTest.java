package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexTest {

    private IPokedex pokedex;
    private Pokemon pokemon;
    private Pokemon Bulbizare;
    private Pokemon Aquali;

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
        pokemon = mock(Pokemon.class);

        // A utiliser pour la suite du projet, dans les implémentations.
        Bulbizare = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000,4, 56);
        Aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 8, 100);
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
        int size = pokedex.size();
        when(pokedex.addPokemon(any(Pokemon.class))).thenReturn(size);
        when(pokedex.size()).thenReturn(size+1);
        int index = pokedex.addPokemon(pokemon);
        assert (index == size);
        assert (pokedex.size() == size + 1);
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        int index = pokedex.addPokemon(pokemon);
        when(pokedex.getPokemon(index)).thenReturn(pokemon);
        assert (pokedex.getPokemon(index).equals(pokemon));
    }

    @Test
    public void testGetPokemons() {
        when(pokedex.getPokemons()).thenReturn(Collections.singletonList(pokemon));
        assert (pokedex.getPokemons().equals(Collections.singletonList(pokemon)));
    }

    @Test
    public void testGetPokemonsWithOrder() {
        when(pokedex.getPokemons(any(PokemonComparators.class))).thenReturn(Collections.singletonList(pokemon));
        assert (pokedex.getPokemons(PokemonComparators.NAME).equals(Collections.singletonList(pokemon)));
    }
}
