package tf;

public class Trip {
    private MyDate start;
    private MyDate end;
    private String destination;
    private Double price;

    public Trip(MyDate start, MyDate end, String destination) {
        this.start = start;
        this.end = end;
        this.destination = destination;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "start=" + start +
                ", end=" + end +
                ", destination='" + destination + '\'' +
                ", price=" + getPrice() +
                '}';
    }
}
