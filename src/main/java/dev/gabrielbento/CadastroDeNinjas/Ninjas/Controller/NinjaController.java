package dev.gabrielbento.CadastroDeNinjas.Ninjas.Controller;

import dev.gabrielbento.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import dev.gabrielbento.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import dev.gabrielbento.CadastroDeNinjas.Ninjas.Service.NinjaService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {
    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninjaDTO) {
        ninjaService.criarNinja(ninjaDTO);
        return ResponseEntity.ok("Ninja inserido com sucesso");
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    // Mostrar ninja  por id (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjaPorId(@PathVariable Long id) {
         NinjaDTO ninja = ninjaService.listarPorId(id);
         if(ninja!=null)
             return ResponseEntity.ok(ninja);
         else
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja não encontrado");
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaModel) {
        if(ninjaService.listarPorId(id)!=null) {
            ninjaService.atualizarNinja(id, ninjaModel);
            return ResponseEntity.ok("Ninja atualizado com sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id " + id + " não encontrado");
        }
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
        if(ninjaService.listarPorId(id)!=null){
            ninjaService.deletarPorId(id);
            return ResponseEntity.ok("Ninja com o id" + id + " deletado com sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id " + id + " não encontrado");
        }

    }
}
