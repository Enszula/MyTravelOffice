package TravelOffice.entity;

import java.time.LocalDate;

public class AbroadTrip extends Trip {
    private Double insurance;

    public AbroadTrip(LocalDate start, LocalDate end, String destination) {
        super(start, end, destination);
    }

    public void setInsurance(Double insurance) {
        this.insurance = insurance;
    }

    @Override
    public Double getPrice() {
        return super.getPrice() + insurance;
    }
}
