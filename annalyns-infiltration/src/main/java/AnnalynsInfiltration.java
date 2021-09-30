class AnnalynsInfiltration {
    public static boolean canFastAttack(boolean knightIsAwake) {
        return knightIsAwake ? false : true;
    }

    public static boolean canSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake) {
        return knightIsAwake ? true : (archerIsAwake ? true : prisonerIsAwake);
    }

    public static boolean canSignalPrisoner(boolean archerIsAwake, boolean prisonerIsAwake) {
        boolean archerIsSleeping = !archerIsAwake;
         return prisonerIsAwake ? archerIsSleeping : false;
    }

    public static boolean canFreePrisoner(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake, boolean petDogIsPresent) {
        boolean archerIsSleeping = !archerIsAwake;
        boolean knightIsSleeping = !knightIsAwake;

        return  archerIsSleeping && (petDogIsPresent || (prisonerIsAwake && knightIsSleeping));
    }
}
