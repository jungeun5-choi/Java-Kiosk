public class ProductMenu extends MainMenu {
    protected float price;

    public void setter(String name, float price, String explain){

        this.name = name;
        this.price = price;
        this.explain = explain;
    }

    // getter
    public float getPrice() { return price; }

}
