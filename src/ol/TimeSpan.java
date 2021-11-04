package ol;


public class TimeSpan {
    private int hours;
    private int minutes;

    TimeSpan(int h, int m){
        this.hours = h;
        this.minutes = m;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void add(int hours, int minutes) {
        this.hours = this.hours + hours;
        minutes = minutes + this.minutes;
        hours = minutes / 60;
        this.minutes = minutes % 60;
        this.hours = this.hours + hours;
    }
}
