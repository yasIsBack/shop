package co.simplon.starting1.model.product;

public class Clothing extends Product{

    private static final long serialVersionUID = 1L;
    private ClothingSizes clothingSizes;
    public Clothing(String name,float sellingPrice, float buyingPrice, ClothingSizes clothingSizes) {
	super(name,sellingPrice,buyingPrice);
	this.clothingSizes = clothingSizes;
    }

    public ClothingSizes getClothingSizes() {
	return clothingSizes;
    }

    public void setClothingSizes(ClothingSizes clothingSizes) {
	this.clothingSizes = clothingSizes;
    }

}
