package br.grupo4.sistemarh.service;

import br.grupo4.sistemarh.dto.FuncionarioDto;
import br.grupo4.sistemarh.model.Funcionario;
import br.grupo4.sistemarh.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class FuncionariosService {
    @Autowired
    private FuncionarioRepository repository;

    @Transactional
    public FuncionarioDto create(FuncionarioDto dto) {
        Funcionario funcionario = new Funcionario(dto);
        repository.save(funcionario);
        return new FuncionarioDto(funcionario);
    }

    @Transactional(readOnly = true)
    public List<FuncionarioDto> findAll() {
        List<Funcionario> funcionarioList = repository.findAll();
        return funcionarioList.stream().map(FuncionarioDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public FuncionarioDto findById(Long id) {
        Funcionario funcionario = repository.findById(id).orElseThrow(NoSuchElementException::new);

        return new FuncionarioDto(funcionario);
    }

    @Transactional(readOnly = true)
    public List<FuncionarioDto> getByNome(String nome) {
        List<Funcionario> funcionarioList = repository.findAllByNomeContainingIgnoreCase(nome);
        return funcionarioList.stream().map(FuncionarioDto::new).collect(Collectors.toList());
    }

    @Transactional
    public FuncionarioDto update(Long id, FuncionarioDto dto) {
        Funcionario reference = repository.getReferenceById(id);
        reference.createOrUpdate(dto);
        repository.save(reference);

        return new FuncionarioDto(reference);
    }

    @Transactional
    public void delete(Long id) {
        boolean exists = repository.existsById(id);

        if (!exists) {
            throw new NoSuchElementException();
        }

        repository.deleteById(id);
    }

}
