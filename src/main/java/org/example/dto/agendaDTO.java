package org.example.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class agendaDTO {
    @NotNull(message = "Campo nome obrigatorio")
    private String nome;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dataNas;
    @NotNull(message = "Campo cpf obrigatorio")
    private String cpf;
    @NotNull(message = "Campo telefone obrigatorio")
    private String telefone;

}
