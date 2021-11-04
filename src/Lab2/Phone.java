package Lab2;

public class Phone {
    private long number;
    private double tarif;
    private double phoneBill;
    private String type;
    private String os;

    public Phone(long n, double tarif, int pb, String t, String os){
        this.number = n;
        this.tarif = tarif;
        this.phoneBill = pb;
        this.type = t;
        this.os = os;
    }

    public String getType() {
        return type;
    }

    public double getTarif() {
        return tarif;
    }

    public void changeTarif(double tarif) {
        this.tarif = tarif;
    }


    public String getOs() {
        return os;
    }


    public long getNumber() {
        return number;
    }


    public double getPhoneBill() {
        return phoneBill;
    }

    public void setPhoneBill(double phoneBill) {
        this.phoneBill = phoneBill;
    }


    public void call(int minutes){
        double check = getTarif() * minutes;
        this.phoneBill -= check;
    }

    public void upgradeOs(String version) {
        String[] parts = getOs().split(" ");
        String part1 = parts[0];
        this.os = part1 + " " + version;
    }

    public void Refill(double Chost){
        double count = getPhoneBill() + Chost;
        this.setPhoneBill(count);
    }

}
