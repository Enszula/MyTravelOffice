package TravelOffice.entity;

import java.time.LocalDate;

public abstract class Trip {
    private LocalDate start;
    private LocalDate end;
    private String destination;
    private Double price;

    public Trip(LocalDate start, LocalDate end, String destination) {
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
