package br.grupo4.sistemarh.controller;

import br.grupo4.sistemarh.dto.DepartamentoDto;
import br.grupo4.sistemarh.service.DepartamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/departamentos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DepartamentoController {
    @Autowired
    private DepartamentoService service;

    @PostMapping
    public ResponseEntity<DepartamentoDto> create(@RequestBody @Valid DepartamentoDto dto, UriComponentsBuilder uri) {
        DepartamentoDto departamentoDto = service.create(dto);
        URI address = uri.path("/departamentos/{id}").buildAndExpand(departamentoDto.id()).toUri();

        return ResponseEntity.created(address).body(departamentoDto);
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoDto>> findAll() {
        List<DepartamentoDto> departamentoDtoList = service.findAll();
        return ResponseEntity.ok(departamentoDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoDto> findById(@PathVariable Long id) {
        DepartamentoDto departamentoDto = service.findById(id);

        return ResponseEntity.ok(departamentoDto);
    }

    @GetMapping("/pesquisar")
    public ResponseEntity<List<DepartamentoDto>> getBySetor(@RequestParam String setor) {
        List<DepartamentoDto> departamentoDtoList = service.getBySetor(setor);

        return ResponseEntity.ok(departamentoDtoList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartamentoDto> update(@PathVariable Long id, @RequestBody @Valid DepartamentoDto dto) {
        DepartamentoDto departamentoDto = service.update(id, dto);

        return ResponseEntity.ok(departamentoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
