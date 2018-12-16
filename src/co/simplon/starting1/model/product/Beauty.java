package co.simplon.starting1.model.product;

public class Beauty extends Product{
    
    private static final long serialVersionUID = 1L;
    private boolean containsParaben;
    
    public Beauty(String name,float sellingPrice, float buyingPrice, boolean containsParaben) {
	super(name,sellingPrice,buyingPrice);
	this.containsParaben = containsParaben;
    }
    
    public boolean isContainsParaben() {
	return containsParaben;
    }

    public void setContainsParaben(boolean containsParaben) {
	this.containsParaben = containsParaben;
    }
}
