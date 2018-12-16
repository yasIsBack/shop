package co.simplon.starting1.tests.persistence;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import co.simplon.starting1.infra.persistence.file.ClientRepository;
import co.simplon.starting1.model.client.Client;
import co.simplon.starting1.model.client.IClientRepository;
import co.simplon.starting1.tests.TestsUtils;

public class TestClientRepository {

    private IClientRepository repo;

    @BeforeEach
    void setUp() throws Exception {

	TestsUtils.deleteClientFile();
	TestsUtils.populateSomeData();
	repo = new ClientRepository();
    }

    @Test
    void testRetourneClientParId() throws IOException {

	String idStef = null;
	for (Client c : repo.getAllClients()) {
	    if (c.getName().equals("Stéphane")) {
		idStef = c.getId();
	    }
	}

	Client stef = repo.findById(idStef);
	assertEquals("Stéphane", stef.getName());
    }

    @Test
    void ajouteDe2ClientsEtVerif() {

	assertEquals(4, repo.getAllClients().size());
    }
}
