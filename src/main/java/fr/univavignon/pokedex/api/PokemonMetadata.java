package fr.univavignon.pokedex.api;

/**
 * Pokemon metadata POJO.
 *
 * @author fv
 */
public class PokemonMetadata {

    /**
     * Pokemon index.
     **/
    private final int index;

    /**
     * Pokemon name.
     **/
    private final String name;

    /**
     * Pokemon attack level.
     **/
    private final int attack;

    /**
     * Pokemon defense level.
     **/
    private final int defense;

    /**
     * Pokemon stamina level.
     **/
    private final int stamina;

    /**
     * Default constructor.
     *
     * @param indexP   Pokemon index.
     * @param nameP    Pokemon name.
     * @param attackP  Attack level.
     * @param defenseP Defense level.
     * @param staminaP Stamina level.
     */
    @SuppressWarnings("checkstyle:HiddenField")
    public PokemonMetadata(final int indexP, final String nameP,
                           final int attackP,
                           final int defenseP, final int staminaP) {
        this.index = indexP;
        this.name = nameP;
        this.attack = attackP;
        this.defense = defenseP;
        this.stamina = staminaP;
    }

    /**
     * Index getter.
     *
     * @return Pokemon index.
     **/
    public int getIndex() {
        return index;
    }

    /**
     * Name getter.
     *
     * @return Pokemon name.
     **/
    public String getName() {
        return name;
    }

    /**
     * Attack level getter.
     *
     * @return Attack level.
     **/
    public int getAttack() {
        return attack;
    }

    /**
     * Defense level getter.
     *
     * @return Defense level.
     **/
    public int getDefense() {
        return defense;
    }

    /**
     * Stamina level getter.
     *
     * @return Stamina level.
     **/
    public int getStamina() {
        return stamina;
    }

}
