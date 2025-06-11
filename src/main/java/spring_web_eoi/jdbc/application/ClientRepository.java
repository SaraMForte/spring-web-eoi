package spring_web_eoi.jdbc.application;

import spring_web_eoi.jdbc.application.exception.DataOperationException;
import spring_web_eoi.jdbc.domain.Client;

import java.util.List;

public interface ClientRepository {

    void saveClient(Client client) throws DataOperationException;

    List<Client> findAllClients() throws DataOperationException;

    Client findClientById(int id) throws DataOperationException;

    void updateClient(Client client) throws DataOperationException;

    void deleteClientById(int id) throws DataOperationException;
}
