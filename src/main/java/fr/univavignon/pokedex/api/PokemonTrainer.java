package fr.univavignon.pokedex.api;

/**
 * Trainer POJO.
 *
 * @author fv
 */
public class PokemonTrainer {

    /**
     * Trainer name.
     **/
    private final String name;

    /**
     * Trainer team.
     **/
    private final Team team;

    /**
     * Trainer pokedex.
     **/
    private final IPokedex pokedex;

    /**
     * Default constructor.
     *
     * @param nameP    Trainer name.
     * @param teamP    Trainer team.
     * @param pokedexP Trainer pokedex.
     */
    public PokemonTrainer(final String nameP, final Team teamP,
                          final IPokedex pokedexP) {
        this.name = nameP;
        this.team = teamP;
        this.pokedex = pokedexP;
    }

    /**
     * Name getter.
     *
     * @return Trainer name.
     **/
    public String getName() {
        return name;
    }

    /**
     * Team getter.
     *
     * @return Trainer team.
     **/
    public Team getTeam() {
        return team;
    }

    /**
     * Pokedex getter.
     *
     * @return Trainer pokedex.
     **/
    public IPokedex getPokedex() {
        return pokedex;
    }

}
