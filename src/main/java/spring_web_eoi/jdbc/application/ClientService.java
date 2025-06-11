package spring_web_eoi.jdbc.application;

import spring_web_eoi.jdbc.domain.Client;

import java.util.List;

public class ClientService {

    ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void save(Client client) {
        clientRepository.saveClient(client);
    }

    public List<Client> findAll() {
        return clientRepository.findAllClients();
    }

    public Client findById(int id) {
        return clientRepository.findClientById(id);
    }

    public void update(Client client) {
        System.out.println(client);
        clientRepository.updateClient(client);
    }

    public void deleteById(int id) {
        clientRepository.deleteClientById(id);
    }
}
