package TravelOffice.tf;

public class DomesticTrip extends Trip {
    private Double ownArrivalDiscount;

    public DomesticTrip(MyDate start, MyDate end, String destination) {
        super(start, end, destination);
    }

    public void setOwnArrivalDiscount(Double ownArrivalDiscount) {
        this.ownArrivalDiscount = ownArrivalDiscount;
    }

    @Override
    public Double getPrice() {
        return super.getPrice() - ownArrivalDiscount;
    }
}
