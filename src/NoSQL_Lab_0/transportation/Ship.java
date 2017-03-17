package NoSQL_Lab_0.transportation;

public class Ship {
    private String name;
    private ShipType shipType;

    public Ship(String name, ShipType shipType) {
        this.name = name;
        this.shipType = shipType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }
}
