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
import co.simplon.starting1.model.order.IOrderRepository;
import co.simplon.starting1.model.order.Order;

public class OrderRepository implements IOrderRepository {

    private Map<String, Order> order = new HashMap<String, Order>();

    private final String storageDir;

    private final File file;

    public OrderRepository() throws IOException {

	storageDir = new ConfigFileReader().getConfigProperty("storageDirectory");
	file = new File(storageDir + "/order.dat");

	try {
	    loadFromFile();
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
    }

    private void saveToFile() throws FileNotFoundException, IOException {

	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
	oos.writeObject(order);
	oos.close();
    }

    @SuppressWarnings("unchecked")
    private void loadFromFile() throws ClassNotFoundException, IOException {

	ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
	order = (Map<String, Order>) ois.readObject();
	ois.close();
    }

    @Override
    public void saveOrder(Order cmd) {

	try {
	    loadFromFile();
	    order.put(cmd.getId(), cmd);
	    saveToFile();
	    loadFromFile();
	} catch (IOException | ClassNotFoundException e) {
	    e.printStackTrace();
	}

    }

    @Override
    public Order findById(String id) {
	try {
		loadFromFile();
	} catch (ClassNotFoundException | IOException e) {
		e.printStackTrace();
	}
	return order.get(id);
    }

    @Override
    public void deleteOrder(Order cmd) {

	try {
	    loadFromFile();
	    order.remove(cmd.getId());
	    saveToFile();
	    loadFromFile();
	} catch (IOException | ClassNotFoundException e) {
	    e.printStackTrace();
	}

    }

    @Override
    public List<Order> listAllOrder() {

	try {
	    loadFromFile();
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return new ArrayList<Order>(order.values());
    }

}
