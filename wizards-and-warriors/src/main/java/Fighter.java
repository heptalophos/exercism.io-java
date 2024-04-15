class Fighter {
    boolean isVulnerable() { return true; }
    int getDamagePoints(Fighter fighter) { return 1; }
    public String toString() {
        return "Fighter is a " + getClass().getSimpleName();
    }
}

class Warrior extends Fighter {
    @Override
    boolean isVulnerable() { return false; }
    int getDamagePoints(Fighter wizard) { 
        return wizard.isVulnerable() ? 10 : 6;
    }
    @Override
    public String toString() { return super.toString(); }
}

class Wizard extends Fighter {
    private boolean spellReady = false; 
    @Override
    boolean isVulnerable() { return spellReady == false; }
    @Override
    int getDamagePoints(Fighter warrior) { return spellReady ? 12 : 3; }
    void prepareSpell() { spellReady = true; }
    @Override
    public String toString() { return super.toString(); }
}
