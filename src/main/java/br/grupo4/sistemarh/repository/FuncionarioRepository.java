package br.grupo4.sistemarh.repository;

import br.grupo4.sistemarh.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    List<Funcionario> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
}
