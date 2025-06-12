package spring_web_eoi.jdbc.application;

import spring_web_eoi.jdbc.application.exception.DataDeleteException;
import spring_web_eoi.jdbc.domain.Client;

import java.util.List;
import java.util.Optional;

public class ClientService {

    private final ClientRepository clientRepository;
    private final OrderRepository orderRepository;
    private final ClientDeleteUseCase clientDeleteUseCase;

    public ClientService(ClientRepository clientRepository, OrderRepository orderRepository) {
        this.clientRepository = clientRepository;
        this.orderRepository = orderRepository;
        this.clientDeleteUseCase = new ClientDeleteUseCase(clientRepository, orderRepository);
    }

    public void save(Client client) {
        clientRepository.saveClient(client);
    }

    public List<Client> findAll() {
        return clientRepository.findAllClients();
    }

    public Optional<Client> findById(int id) {
        return clientRepository.findClientById(id);
    }

    public void update(Client client) {
        System.out.println(client);
        clientRepository.updateClient(client);
    }

    public void deleteById(int id) throws DataDeleteException {
        clientDeleteUseCase.deleteClient(id);
    }
}
