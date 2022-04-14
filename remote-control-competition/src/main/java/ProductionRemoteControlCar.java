class ProductionRemoteControlCar implements RemoteControlCar {
    private int distance  = 0;
    private int victories = 0;
    public void drive() {
        distance += 10;
    }
    public int getDistanceTravelled() {
        return distance;
    }
    public int getNumberOfVictories() {
        return victories;
    }
    public void setNumberOfVictories(int numberofVictories) {
        victories = numberofVictories;
    }
}
