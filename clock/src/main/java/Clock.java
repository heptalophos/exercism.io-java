public class Clock {

    private int hours;
    private int minutes;

    private void normalize(int minutes) {
        this.hours = (int)((minutes / 60) % 24 + 24) % 24;
        this.minutes = (minutes % 60 + 60) % 60;
    }

    public Clock(int hours, int minutes) {
        normalize(60 * hours + minutes);
    }

    public void add(int minutes) {
        normalize(60 * hours + this.minutes + minutes);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }

    @Override
	public boolean equals(Object o) {
		if (o != null && getClass() == o.getClass()) {
            final Clock c = (Clock) o;
            return  hours == c.hours && minutes == c.minutes;
		}
		return false;
	}
} 
