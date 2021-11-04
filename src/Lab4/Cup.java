package Lab4;

public class Cup {
    private String material;
    private int roominess;
    private String color;
    private double price;


    Cup(String m,  int r, String c, double p){
        this.material = m;
        this.roominess = r;
        this.color = c;
        this.price = p;
    }

    String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    int getRoominess() {
        return roominess;
    }

    public void setRoominess(int roominess) {
        this.roominess = roominess;
    }

    String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
