package dev.gabrielbento.CadastroDeNinjas.Ninjas.Repository;

import dev.gabrielbento.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {

}
