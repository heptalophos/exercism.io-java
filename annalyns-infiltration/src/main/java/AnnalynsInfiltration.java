class AnnalynsInfiltration {
    public static boolean canFastAttack(boolean knightIsAwake) {
        return knightIsAwake ? false : true;
    }

    public static boolean canSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake) {
        return knightIsAwake ? true : (archerIsAwake ? true : prisonerIsAwake);
    }

    public static boolean canSignalPrisoner(boolean archerIsAwake, boolean prisonerIsAwake) {
        boolean archerSleeping = !archerIsAwake;
        return prisonerIsAwake ? archerSleeping : false;
    }

    public static boolean canFreePrisoner(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake, boolean petDogIsPresent) {
        boolean archerSleeping = !archerIsAwake;
        boolean knightSleeping = !knightIsAwake;
        return  archerSleeping ? 
                (petDogIsPresent ? true : (prisonerIsAwake ? knightSleeping : false)) : 
                false;
    }
}
