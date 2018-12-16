package co.simplon.starting1.infra.persistence.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.simplon.starting1.infra.utils.ConfigFileReader;
import co.simplon.starting1.model.product.Product;
import co.simplon.starting1.model.shop.IShopRepository;
import co.simplon.starting1.model.shop.Shop;
import co.simplon.starting1.model.shop.Stock;

public class ShopRepository implements IShopRepository {

    private Map<String, Shop> shops = new HashMap<String, Shop>();

    private final String storageDir;

    private final File file;

    public ShopRepository() throws IOException {

	storageDir = new ConfigFileReader().getConfigProperty("storageDirectory");
	file = new File(storageDir + "/shops.dat");

	try {
	    loadFromFile();
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
    }

    private void saveToFile() throws FileNotFoundException, IOException {

	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
	oos.writeObject(shops);
	oos.close();
    }

    @SuppressWarnings("unchecked")
    private void loadFromFile() throws ClassNotFoundException, IOException {

	ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
	shops = (Map<String, Shop>) ois.readObject();
	ois.close();
    }

    @Override
    public void saveShop(Shop shop) {

	try {
	    loadFromFile();
	    shops.put(shop.getId(), shop);
	    saveToFile();
	    loadFromFile();
	} catch (IOException | ClassNotFoundException e) {
	    e.printStackTrace();
	}

    }

    @Override
    public void deleteShop(Shop shop) {

	try {
	    loadFromFile();
	    shops.remove(shop.getId());
	    saveToFile();
	    loadFromFile();
	} catch (IOException | ClassNotFoundException e) {
	    e.printStackTrace();
	}

    }

    @Override
    public List<Shop> getAllShops() {

	try {
	    loadFromFile();
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return new ArrayList<Shop>(shops.values());
    }

    @Override
    public List<Product> getProductsByShop(Shop shop) {
	return null;

    }

    @Override
    public int getProductAvailability(Product product, Shop shop) {

	Collection<Stock> tmpShopStock = shop.getStock();
	for(Stock tmpS : tmpShopStock ) {
	    if ( tmpS.getProduct().equals(product) ) 
		return tmpS.getQuantity();
	}
	return -1; // produit n'est pas en stock

    }

    @Override
    public void addProductsToShop(Product product, Shop shop, int quantity) {
	
	shop.addProductToStock(new Stock(quantity,product));
    }

    @Override
    public List<Stock> getShopStocks(Shop shop) {

	// TODO Auto-generated method stub
	return null;
    }

}
