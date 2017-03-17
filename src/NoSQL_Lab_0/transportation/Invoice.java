package NoSQL_Lab_0.transportation;

public class Invoice {
    private Container container;
    private Ship ship;
    private Flight flight;
    private Consignee consignee;

    public Invoice(Container container, Ship ship, Flight flight, Consignee consignee) {
        this.container = container;
        this.ship = ship;
        this.flight = flight;
        this.consignee = consignee;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Consignee getConsignee() {
        return consignee;
    }

    public void setConsignee(Consignee consignee) {
        this.consignee = consignee;
    }
}
