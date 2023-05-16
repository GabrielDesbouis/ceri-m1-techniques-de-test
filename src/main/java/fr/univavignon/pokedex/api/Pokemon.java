package fr.univavignon.pokedex.api;

/**
 * Pokemon POJO.
 *
 * @author fv
 */
public final class Pokemon extends PokemonMetadata {

    /**
     * Combat Point of the pokemon.
     **/
    private final int cp;

    /**
     * HP of the pokemon.
     **/
    private final int hp;

    /**
     * Required dust for upgrading this pokemon.
     **/
    private final int dust;

    /**
     * Required candy for upgrading this pokemon.
     **/
    private final int candy;

    /**
     * IV perfection percentage.
     **/
    private final double iv;

    /**
     * Default constructor.
     *
     * @param index   Pokemon index.
     * @param name    Pokemon name.
     * @param attack  Attack level.
     * @param defense Defense level.
     * @param stamina Stamina level.
     * @param cpP     Pokemon cp.
     * @param hpP     Pokemon hp.
     * @param dustP   Required dust for upgrading this pokemon.
     * @param candyP  Required candy for upgrading this pokemon.
     * @param ivP     IV perfection percentage.
     */
    @SuppressWarnings("checkstyle:ParameterNumber")
    public Pokemon(
            final int index,
            final String name,
            final int attack,
            final int defense,
            final int stamina,
            final int cpP,
            final int hpP,
            final int dustP,
            final int candyP,
            final double ivP) {
        super(index, name, attack, defense, stamina);
        this.cp = cpP;
        this.hp = hpP;
        this.dust = dustP;
        this.candy = candyP;
        this.iv = ivP;
    }

    /**
     * Combat Point getter getter.
     *
     * @return Pokemon cp.
     **/
    public int getCp() {
        return cp;
    }

    /**
     * HP getter.
     *
     * @return Pokemon hp.
     **/
    public int getHp() {
        return hp;
    }

    /**
     * Dust getter.
     *
     * @return Required dust for upgrading this pokemon.
     **/
    public int getDust() {
        return dust;
    }

    /**
     * Candy getter.
     *
     * @return Required candy for upgrading this pokemon.
     **/
    public int getCandy() {
        return candy;
    }

    /**
     * IV getter.
     *
     * @return IV perfection percentage.
     **/
    public double getIv() {
        return iv;
    }

}
