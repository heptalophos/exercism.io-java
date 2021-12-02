class BirdWatcher {

    private final int[] birdsPerDay;
    private int todays;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
        this.todays = birdsPerDay.length < 1 
                     ? 0 
                     : birdsPerDay[birdsPerDay.length - 1];
    }

    public int[] getLastWeek() {
        return birdsPerDay;
    }

    public int getToday() {
        return todays;
    }

    public void incrementTodaysCount() {
        todays++;
    }

    public boolean hasDayWithoutBirds() {
        for (int birds : birdsPerDay) if (birds == 0) 
            return true;
        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        numberOfDays = numberOfDays > birdsPerDay.length
                       ? birdsPerDay.length
                       : numberOfDays;
        int count = 0;
        for (int i = 0; i < numberOfDays; i++)
            count += birdsPerDay[i];
        return count;
    }

    public int getBusyDays() {
        int busy = 0;
        for (int count: birdsPerDay) if (count >= 5)
            busy++;
        return busy;
    }
}
