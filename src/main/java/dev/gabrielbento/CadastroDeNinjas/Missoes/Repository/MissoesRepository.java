package dev.gabrielbento.CadastroDeNinjas.Missoes.Repository;

import dev.gabrielbento.CadastroDeNinjas.Missoes.Model.MissaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissoesRepository extends JpaRepository<MissaoModel, Long> {

}
