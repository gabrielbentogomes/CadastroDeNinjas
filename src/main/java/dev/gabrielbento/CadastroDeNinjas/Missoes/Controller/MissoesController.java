package dev.gabrielbento.CadastroDeNinjas.Missoes.Controller;

import dev.gabrielbento.CadastroDeNinjas.Missoes.Model.MissaoModel;
import dev.gabrielbento.CadastroDeNinjas.Missoes.Service.MissaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {
    private MissaoService missaoService;

    public MissoesController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    // GET -- Mandar uma requisao para mostrar as missoes
    @GetMapping("/listar")
    public List<MissaoModel> listarMissao() {
        return missaoService.listarMissoes();
    }

    // Post -- Mandar uma requisao para criar as missoes
    @PostMapping("/criar")
    public MissaoModel criarMissao(@RequestBody MissaoModel missao) {
        return missaoService.criarMissao(missao);
    }

    // PUT -- Mandar uma requisao para alterar as missoes
    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missao alterada com sucesso";
    }

    // Delete -- Mandar uma requisao para deletar as missoes
    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id) {
        missaoService.deletarPorId(id);
    }
}
