package TravelOffice.tf;

public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static MyDate of(String dateString, String separator) {
        String[] array = dateString.split("-");
        if (array.length != 3) {
            return null;
        }
        return new MyDate(Integer.valueOf(array[0]), Integer.valueOf(array[1]), Integer.valueOf(2));
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}