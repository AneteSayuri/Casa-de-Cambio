package br.com.ada.cambio.service;

import br.com.ada.cambio.model.Cliente;
import br.com.ada.cambio.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClienteService{
    private final ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public Cliente findByCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }

    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }

}
