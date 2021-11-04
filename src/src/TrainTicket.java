package src;

import java.util.Date;
import java.util.List;

/**
 * Created by User on 31.12.01.
 */
public class TrainTicket extends Ticket {

    private String trainNumber;
    private int carNumber;
    private int seatNumber;
    private String nameClient;
    private String surnameClient;

    TrainTicket() {}

    TrainTicket(String trainNumber, int carNumber, int seatNumber, int id, String nameClient, String surnameClient, Date dateSend, String placeArrival, String placeSend) {
        super(dateSend, placeArrival, placeSend);
        this.trainNumber = trainNumber;
        this.carNumber = carNumber;
        this.seatNumber = seatNumber;
        System.out.println("It`s OK");
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getSurnameClient() {
        return surnameClient;
    }

    public void setSurnameClient(String surnameClient) {
        this.surnameClient = surnameClient;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setText(String text) {
        super.setText(text + "\n from class TrainTicket \n");
    }

    public String getText() {
        return "Номер потяга: " + trainNumber + "\n"+
                "Номер вагона: " + carNumber + "\n" +
                "Номер місця: " + seatNumber + "\n" +
                "Ім'я: " + nameClient + "\n" +
                "Прізвище: " + surnameClient + "\n" +
                super.getText();
    }

}
