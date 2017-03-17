package NoSQL_Lab_0.transportation;

public class Flight {
    private Ship ship;
    private PortDeparture departure;
    private PortArrival arrival;
    private String departureDate;
    private String arrivalDate;

    public Flight(Ship ship, PortDeparture departure, PortArrival arrival, String departureDate, String arrivalDate) {
        this.ship = ship;
        this.departure = departure;
        this.arrival = arrival;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public PortDeparture getDeparture() {
        return departure;
    }

    public void setDeparture(PortDeparture departure) {
        this.departure = departure;
    }

    public PortArrival getArrival() {
        return arrival;
    }

    public void setArrival(PortArrival arrival) {
        this.arrival = arrival;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
}
