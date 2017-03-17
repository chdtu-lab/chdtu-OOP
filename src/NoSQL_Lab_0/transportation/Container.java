package NoSQL_Lab_0.transportation;

public class Container {
    private String description_product;
    private String unloading_rules;

    public Container(String description_product, String unloading_rules) {
        this.description_product = description_product;
        this.unloading_rules = unloading_rules;
    }

    public String getDescription_product() {
        return description_product;
    }

    public void setDescription_product(String description_product) {
        this.description_product = description_product;
    }

    public String getUnloading_rules() {
        return unloading_rules;
    }

    public void setUnloading_rules(String unloading_rules) {
        this.unloading_rules = unloading_rules;
    }
}
