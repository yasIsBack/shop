package co.simplon.starting1.model.client;

import java.util.List;

public interface IClientRepository {

    List<Client> getAllClients();

    Client findById(String id);

    void saveClient(Client client);

    void deleteClient(Client client);

}
