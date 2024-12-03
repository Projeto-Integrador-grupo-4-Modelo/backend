package br.grupo4.sistemarh.service;

import br.grupo4.sistemarh.dto.DepartamentoDto;
import br.grupo4.sistemarh.model.Departamento;
import br.grupo4.sistemarh.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class DepartamentoService {
    @Autowired
    private DepartamentoRepository repository;

    public DepartamentoDto create(DepartamentoDto dto) {
        Departamento departamento = new Departamento(dto);
        repository.save(departamento);
        return new DepartamentoDto(departamento);
    }

    public List<DepartamentoDto> findAll() {
        List<Departamento> departamentoList = repository.findAll();
        return departamentoList.stream().map(DepartamentoDto::new).collect(Collectors.toList());
    }

    public DepartamentoDto findById(Long id) {
        Departamento departamento = repository.findById(id).orElseThrow(NoSuchElementException::new);

        return new DepartamentoDto(departamento);
    }

    public DepartamentoDto update(Long id, DepartamentoDto dto) {
        Departamento reference = repository.getReferenceById(id);
        reference.createOrUpdate(dto);
        repository.save(reference);

        return new DepartamentoDto(reference);
    }

    public void delete(Long id) {
        boolean exists = repository.existsById(id);

        if (!exists) {
            throw new NoSuchElementException();
        }

        repository.deleteById(id);
    }

    public List<DepartamentoDto> getBySetor(String setor) {
        List<Departamento> departamentoList = repository.findAllBySetorContainingIgnoreCase(setor);
        return departamentoList.stream().map(DepartamentoDto::new).collect(Collectors.toList());
    }
}
