abstract class Fighter {

    boolean isVulnerable() {
        return false;
    }

    abstract int damagePoints(Fighter fighter);

    public String toString() {
        return "Fighter is a " + getClass().getSimpleName();
    }
}

class Warrior extends Fighter {

    @Override
    int damagePoints(Fighter wizard) {
        return wizard.isVulnerable() ? 10 : 6;
    }
}

class Wizard extends Fighter {

    private boolean spellReady = false; 

    @Override
    boolean isVulnerable() {
        return spellReady == false;
    }

    @Override
    int damagePoints(Fighter warrior) {
        return spellReady ? 12 : 3;
    }

    void prepareSpell() {
        spellReady = true;
    }
}
