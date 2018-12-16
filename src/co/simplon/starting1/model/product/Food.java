package co.simplon.starting1.model.product;

public class Food extends Product {

    private static final long serialVersionUID = 1L;
    private boolean containsGluten;

    public Food(String name, float sellingPrice, float buyingPrice, boolean containsGluten) {
	super(name, sellingPrice, buyingPrice);
	this.containsGluten = containsGluten;
    }

    public boolean isContainsGluten() {
	return containsGluten;
    }

    public void setContainsGluten(boolean containsGluten) {
	this.containsGluten = containsGluten;
    }

}
