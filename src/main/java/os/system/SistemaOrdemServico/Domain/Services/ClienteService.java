package os.system.SistemaOrdemServico.Domain.Services;

import os.system.SistemaOrdemServico.Domain.Entities.Cliente;
import os.system.SistemaOrdemServico.Domain.Repositories.ClienteRepository;

import java.util.List;

public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente cadastrarCLiente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> todosOsClientes(){
        return clienteRepository.findAll();
    }

    public void deletarCliente(Long id){
        clienteRepository.deleteById(id);
    }

    public Cliente encontrarClientePeloId(Long id){
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encotrado!"));
    }
}
