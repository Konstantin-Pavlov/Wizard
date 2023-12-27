class Spell {
    String name;
    boolean isOffensive;
    int attackPower;
    int mpCost;
    int hpIncrease;
    int mpIncrease;
    int luckIncrease;

    /* Spell constructor parameters
     *
     * name: name of the spell
     * isOffensive: whether or not the spell attacks (e.g. reparo is not offensive)
     * attackPower: strength of spell's attack
     * mpCost: MP cost of casting this spell
     * hpIncrease: how much this spell raises the caster's hp
     * mpIncrease: how much this spell raises the caster's mp
     * luckIncrease: how much this spell rises the caster's luck
     */
    Spell(String name, boolean isOffensive, int attackPower,
          int mpCost, int hpIncrease, int mpIncrease, int luckIncrease) {
        this.name = name;
        this.isOffensive = isOffensive;
        this.attackPower = attackPower;
        this.mpCost = mpCost;
        this.hpIncrease = hpIncrease;
        this.mpIncrease = mpIncrease;
        this.luckIncrease = luckIncrease;
    }
}