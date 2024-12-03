package br.grupo4.sistemarh.model;

import br.grupo4.sistemarh.dto.DepartamentoDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_departamentos")
@Getter
@Setter
@NoArgsConstructor
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String setor;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "departamento", cascade = CascadeType.REMOVE)
    private List<Funcionario> funcionarios;

    public Departamento(DepartamentoDto dto) {
        createOrUpdate(dto);
    }

    public void createOrUpdate(DepartamentoDto dto) {
        this.setor = dto.setor();
    }
}
