package dev.gabrielbento.CadastroDeNinjas.Ninjas.Service;

import dev.gabrielbento.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import dev.gabrielbento.CadastroDeNinjas.Ninjas.Mapper.NinjaMapper;
import dev.gabrielbento.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import dev.gabrielbento.CadastroDeNinjas.Ninjas.Repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar todos os ninjas
    public List<NinjaDTO> listarNinjas(){
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(NinjaMapper::map)
                .collect(Collectors.toList());
    }

    public NinjaDTO listarPorId(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);

        return ninjaPorId.map(NinjaMapper::map).orElse(null);
    }

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = NinjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return NinjaMapper.map(ninja);
    }

    public void deletarPorId(Long id){
        ninjaRepository.deleteById(id);
    }

    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO) {
        return ninjaRepository.findById(id)
                .map(ninjaExistente -> {
                    ninjaExistente.setNome(ninjaDTO.getNome() != null ? ninjaDTO.getNome() : ninjaExistente.getNome());
                    ninjaExistente.setEmail(ninjaDTO.getEmail() != null ? ninjaDTO.getEmail() : ninjaExistente.getEmail());
                    ninjaExistente.setIdade(ninjaDTO.getIdade() != 0 ? ninjaDTO.getIdade() : ninjaExistente.getIdade());
                    ninjaExistente.setRank(ninjaDTO.getRank() != null ? ninjaDTO.getRank() : ninjaExistente.getRank());

                    NinjaModel ninjaSalvo = ninjaRepository.save(ninjaExistente);
                    return ninjaMapper.map(ninjaSalvo);
                })
                .orElse(null);
    }

}
