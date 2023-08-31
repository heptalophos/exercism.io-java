class ProductionRemoteControlCar implements RemoteControlCar, 
                                 Comparable<ProductionRemoteControlCar>  
{
    private int distance  = 0;
    private int victories = 0;
    @Override
    public void drive() {
        distance += 10;
    }
    @Override
    public int getDistanceTravelled() {
        return this.distance;
    }

    public int getNumberOfVictories() {
        return this.victories;
    }
    public void setNumberOfVictories(int numberofVictories) {
        this.victories = numberofVictories;
    }
    @Override
    public int compareTo(ProductionRemoteControlCar car) {
        return car.getNumberOfVictories() - this.getNumberOfVictories();
    }
}