package co.simplon.starting1.infra.persistence.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.simplon.starting1.infra.utils.ConfigFileReader;
import co.simplon.starting1.model.product.IProductRepository;
import co.simplon.starting1.model.product.Product;

public class ProductRepository implements IProductRepository {

    private Map<String, Product> products = new HashMap<String, Product>();

    private final String storageDir;

    private File file;

    public ProductRepository() throws IOException {

	storageDir = new ConfigFileReader().getConfigProperty("storageDirectory");
	file = new File(storageDir + "/products.dat");

	try {
	    loadFromFile();
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
    }

    private void saveToFile() throws FileNotFoundException, IOException {

	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
	oos.writeObject(products);
	oos.close();
    }

    @SuppressWarnings("unchecked")
    private void loadFromFile() throws ClassNotFoundException, IOException {

	ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
	products = (Map<String, Product>) ois.readObject();
	ois.close();
    }

    @Override
    public void saveProduct(Product product) {

	try {
	    loadFromFile();
	    products.put(product.getId(), product);
	    saveToFile();
	    loadFromFile();
	} catch (IOException | ClassNotFoundException e) {
	    e.printStackTrace();
	}

    }

    @Override
    public void deleteProduct(Product product) {

	try {
	    loadFromFile();
	    products.remove(product.getId());
	    saveToFile();
	    loadFromFile();
	} catch (IOException | ClassNotFoundException e) {
	    e.printStackTrace();
	}

    }

    @Override
    public Product findById(String id) {

	try {
	    loadFromFile();
	} catch (ClassNotFoundException | IOException e) {
	    e.printStackTrace();
	}
	return products.get(id);
    }

    @Override
    public List<Product> getAllProducts() {

	try {
	    loadFromFile();
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return new ArrayList<Product>(products.values());
    }

}
