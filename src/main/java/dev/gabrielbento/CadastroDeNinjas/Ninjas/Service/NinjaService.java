package dev.gabrielbento.CadastroDeNinjas.Ninjas.Service;

import dev.gabrielbento.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import dev.gabrielbento.CadastroDeNinjas.Ninjas.Repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Listar todos os ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    public NinjaModel listarPorId(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);

        return ninjaPorId.orElse(null);
    }

    public NinjaModel criarNinja(NinjaModel ninjaModel){
        return ninjaRepository.save(ninjaModel);
    }

}
