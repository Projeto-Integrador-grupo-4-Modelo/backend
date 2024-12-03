package br.grupo4.sistemarh.dto;

import br.grupo4.sistemarh.model.Departamento;
import br.grupo4.sistemarh.model.Funcionario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DepartamentoDto(
        Long id,
        @NotNull @NotBlank String setor,
        @JsonIgnoreProperties("departamento") List<Funcionario> funcionario
) {
    public DepartamentoDto(Departamento departamento) {
        this(
                departamento.getId(),
                departamento.getSetor(),
                departamento.getFuncionarios()
        );
    }
}
