public class ProductMenu extends MainMenu {
    protected float price;

    ProductMenu() {}
    ProductMenu(String name, float price, String explain) {
        setter(name, price, explain);
    }

    public void setter(String name, float price, String explain){

        this.name = name;
        this.price = price;
        this.explain = explain;
    }

    // getter
    public float getPrice() { return price; }

}
