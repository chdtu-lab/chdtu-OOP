package NoSQL_Lab_0.transportation;

public class Main {
    public static void main(String[] args) {
        ShipType type1 = new ShipType("Контейнеровоз");
        ShipType type2 = new ShipType("Танкер");

        PortArrival portArrival1 = new PortArrival("Амбарли");
        PortArrival portArrival2 = new PortArrival("Гемлик");
        PortArrival portArrival3 = new PortArrival("Измир");

        PortDeparture portDeparture1 = new PortDeparture("Ялтинський");
        PortDeparture portDeparture2 = new PortDeparture("Херсонський");
        PortDeparture portDeparture3 = new PortDeparture("Севастопольский");

        Consignee consignee1 = new Consignee("ВАТ Азот");
        Consignee consignee2 = new Consignee("Епіцентер");
        Consignee consignee3 = new Consignee("Богдан");

        Container container1 = new Container("Какао", "правило 1");
        Container container2 = new Container("Запчастини", "правило 2");
        Container container3 = new Container("добоива", "правило 3");

        Ship ship1 = new Ship("Прилуки", type1);
        Ship ship2 = new Ship("Балта", type2);

        Flight flight1 = new Flight(ship1, portDeparture1, portArrival3, "2016-11-26", "2016-11-29");
        Flight flight2 = new Flight(ship1, portDeparture2, portArrival1, "2016-11-26", "2016-11-29");
        Flight flight3 = new Flight(ship1, portDeparture3, portArrival2, "2016-11-26", "2016-11-29");

        Invoice invoice1 = new Invoice(container1, ship1, flight1, consignee1);
        Invoice invoice2 = new Invoice(container2, ship2, flight2, consignee2);
        Invoice invoice3 = new Invoice(container3, ship1, flight3, consignee3);

        System.out.printf(flight1.getShip().getName() + " " + flight1.getArrival().getName() + " " +
                          flight1.getDeparture().getName() + " " + flight1.getDepartureDate() + "" +
                          flight1.getArrivalDate());

    }
}
