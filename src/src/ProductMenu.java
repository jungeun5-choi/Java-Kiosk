public class ProductMenu extends MainMenu {

    protected String name;
    protected float price;
    protected String explain;


    public void setter(String name, float price, String explain){

        this.name = name;
        this.price = price;
        this.explain = explain;
    }


    // getter
    public String getName(){
        return name;
    }
    public String getExplain() {
        return explain;
    }
    public float getPrice() {

        return price;
    }

}
