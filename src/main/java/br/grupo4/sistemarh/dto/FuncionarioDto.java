package br.grupo4.sistemarh.dto;

import br.grupo4.sistemarh.model.Departamento;
import br.grupo4.sistemarh.model.Funcionario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record FuncionarioDto(
        Long id,
        @NotNull @NotBlank String nome,
        @NotNull @NotBlank String cargo,
        @NotNull double salario,
        @NotNull LocalDate dataAdmissao,
        @JsonIgnoreProperties("funcionarios") @NotNull Departamento departamento
) {
    public FuncionarioDto(Funcionario funcionario) {
        this(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getCargo(),
                funcionario.getSalario(),
                funcionario.getDataAdmissao(),
                funcionario.getDepartamento()
        );
    }
}
