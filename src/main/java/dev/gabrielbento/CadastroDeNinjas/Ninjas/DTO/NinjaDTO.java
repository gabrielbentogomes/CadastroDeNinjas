package dev.gabrielbento.CadastroDeNinjas.Ninjas.DTO;

import dev.gabrielbento.CadastroDeNinjas.Missoes.Model.MissaoModel;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;

    private String nome;

    private String email;

    private int idade;

    private MissaoModel missoes;

    private String rank;
}
