package br.grupo4.sistemarh.model;

import br.grupo4.sistemarh.dto.FuncionarioDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tb_funcionarios")
@Getter
@Setter
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cargo;
    @Column(nullable = false)
    private double salario;
    @Column(nullable = false)
    private LocalDate dataAdmissao;

    @ManyToOne
    private Departamento departamento;

    public Funcionario() {
    }

    public Funcionario(FuncionarioDto dto) {
        createOrUpdate(dto);
    }

    public void createOrUpdate(FuncionarioDto dto) {
        this.nome = dto.nome();
        this.cargo = dto.cargo();
        this.salario = dto.salario();
        this.dataAdmissao = dto.dataAdmissao();
        this.departamento = dto.departamento();
    }
}
