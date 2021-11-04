package src;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by User on 31.12.01.
 */
public class Ticket {

    private Date dateSend;
    private String dateSendStr;
    private String placeSend;
    private String placeArrival;
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
    private String text;

    Ticket() {}

    Ticket(Date dateSend, String placeArrival, String placeSend) {
        this.dateSend = dateSend;
        this.placeArrival = placeArrival;
        this.placeSend = placeSend;
        this.dateSendStr = formatter.format(dateSend);

    }

    public String getPlaceSend() {
        return placeSend;
    }

    public void setPlaceSend(String placeSend) {
        this.placeSend = placeSend;
    }

    public String getPlaceArrival() {
        return placeArrival;
    }

    public void setPlaceArrival(String placeArrival) {
        this.placeArrival = placeArrival;
    }

    public String getDateSend() {
        return dateSendStr;
    }

    public void setDateSend(Date dateSend) {
        this.dateSendStr = formatter.format(dateSend);
        this.dateSend = dateSend;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getText(){
        return  text;
    }

}
