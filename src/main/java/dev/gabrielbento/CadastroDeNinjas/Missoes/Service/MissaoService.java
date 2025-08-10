package dev.gabrielbento.CadastroDeNinjas.Missoes.Service;

import dev.gabrielbento.CadastroDeNinjas.Missoes.Model.MissaoModel;
import dev.gabrielbento.CadastroDeNinjas.Missoes.Repository.MissoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissaoService {
    private MissoesRepository missoesRepository;

    public MissaoService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public List<MissaoModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    public MissaoModel criarMissao(MissaoModel missao){
        return missoesRepository.save(missao);
    }
}
