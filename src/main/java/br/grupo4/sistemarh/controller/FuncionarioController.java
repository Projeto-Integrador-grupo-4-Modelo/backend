package br.grupo4.sistemarh.controller;

import br.grupo4.sistemarh.dto.FuncionarioDto;
import br.grupo4.sistemarh.service.FuncionariosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FuncionarioController {

    @Autowired
    private FuncionariosService service;

    @PostMapping
    public ResponseEntity<FuncionarioDto> create(@RequestBody @Valid FuncionarioDto dto, UriComponentsBuilder uri) {
        FuncionarioDto funcionarioDto = service.create(dto);
        URI address = uri.path("/funcionarios/{id}").buildAndExpand(funcionarioDto.id()).toUri();

        return ResponseEntity.created(address).body(funcionarioDto);
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioDto>> findAll() {
        List<FuncionarioDto> funcionarioDtoList = service.findAll();
        return ResponseEntity.ok(funcionarioDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDto> findById(@PathVariable Long id) {
        FuncionarioDto departamentoDto = service.findById(id);

        return ResponseEntity.ok(departamentoDto);
    }

    @GetMapping("/pesquisar")
    public ResponseEntity<List<FuncionarioDto>> getByNome(@RequestParam String nome) {
        List<FuncionarioDto> departamentoDtoList = service.getByNome(nome);

        return ResponseEntity.ok(departamentoDtoList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioDto> update(@PathVariable Long id, @RequestBody @Valid FuncionarioDto dto) {
        FuncionarioDto departamentoDto = service.update(id, dto);

        return ResponseEntity.ok(departamentoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
