package Lab5;

public class Cup extends Utensils {
    private double price;

    Cup(String m,  int r, String c, double p){
        super(m, c, r);
        this.price = p;
    }

    String getAll(){
        String s = super.getAll();
        return s + price +'\n';
    }

    Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
