package org.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="agenda")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class agenda {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;

    @NotEmpty(message = "Campo nome obrigatorio")
    @Column(name="nome", length = 150)
    private String nome;

    @NotNull(message = "Data Obrigatoria")
    @Column(name="dataNas")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dataNas;

    @NotEmpty(message = "Campo cpf obrigatorio")
    @Column(name="cpf", length = 100)
    private String cpf;

    @Column(name="telefone", length = 100)
    private String telefone;
}
