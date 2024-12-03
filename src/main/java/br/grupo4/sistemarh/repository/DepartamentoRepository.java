package br.grupo4.sistemarh.repository;

import br.grupo4.sistemarh.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    List<Departamento> findAllBySetorContainingIgnoreCase(@Param("setor") String setor);
}
