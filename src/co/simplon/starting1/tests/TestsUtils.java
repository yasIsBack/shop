package co.simplon.starting1.tests;

import java.io.File;
import java.io.IOException;

import co.simplon.starting1.infra.persistence.file.ClientRepository;
import co.simplon.starting1.infra.utils.ConfigFileReader;
import co.simplon.starting1.model.client.Client;
import co.simplon.starting1.model.client.IClientRepository;

public class TestsUtils {

    public static void deleteClientFile() throws IOException {

	String storageDir = new ConfigFileReader().getConfigProperty("storageDirectory");
	File file = new File(storageDir + "/clients.dat");
	file.delete();
    }

    public static void populateSomeData() throws IOException {

	IClientRepository repo = new ClientRepository();

	Client[] desClients = new Client[] { new Client("Stéphane", 4000), new Client("Soufiane", 8000),
		new Client("Guillaume", 2000), new Client("Jérémy", 9000) };

	for (Client c : desClients) {
	    repo.saveClient(c);
	}
    }
    
    public static void main(String[] args) {
	/*try {
	    deleteClientFile();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}*/
	try {
	    populateSomeData();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
    }
}
