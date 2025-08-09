package dev.gabrielbento.CadastroDeNinjas.Ninjas.Model;

import dev.gabrielbento.CadastroDeNinjas.Missoes.Model.MissaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_ninja")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private int idade;

    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissaoModel missoes;

}
