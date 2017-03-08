package Lab3;

public class Phone {
    private long number;
    private double tarif;
    private double phoneBill;
    private String type;
    private String os;

    Phone(long n, String t, String os){
        this.type = t;
        this.os = os;
        this.number = n;
        this.tarif = 0.5;
        this.phoneBill = 0.0;
    }


    Phone(String t, String os){
        this.type = t;
        this.os = os;
    }

    Phone(long n, double tarif, int pb, String t, String os){
        this(t, os);
        this.number = n;
        this.tarif = tarif;
        this.phoneBill = pb;
    }




    String getType() {
        return type;
    }

    double getTarif() {
        return tarif;
    }

    void changeTarif(double tarif) {
        this.tarif = tarif;
    }


    String getOs() {
        return os;
    }


    long getNumber() {
        return number;
    }


    double getPhoneBill() {
        return phoneBill;
    }

    private void setPhoneBill(double phoneBill) {
        this.phoneBill = phoneBill;
    }


    void call(int minutes){
        double check = getTarif() * minutes;
        this.phoneBill -= check;
    }

    void upgradeOs(String version) {
        String[] parts = getOs().split(" ");
        String part1 = parts[0];
        this.os = part1 + " " + version;
    }

    void refill(double chost){
        double count = getPhoneBill() + chost;
        this.setPhoneBill(count);
    }

}
