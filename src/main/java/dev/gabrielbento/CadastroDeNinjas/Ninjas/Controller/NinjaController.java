package dev.gabrielbento.CadastroDeNinjas.Ninjas.Controller;

import dev.gabrielbento.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import dev.gabrielbento.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import dev.gabrielbento.CadastroDeNinjas.Ninjas.Service.NinjaService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Criar ninjas", description = "Essa rota permite salvar um ninja no banco de dados")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninjaDTO) {
        ninjaService.criarNinja(ninjaDTO);
        return ResponseEntity.ok("Ninja inserido com sucesso");
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    @Operation(summary = "Listar ninjas", description = "Essa rota permite consultar todos os ninjas salvos no banco de dados")
    public List<NinjaDTO> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    // Mostrar ninja  por id (READ)
    @GetMapping("/listar/{id}")
    @Operation(summary = "Listar ninjas com ID", description = "Essa rota permite consultar um ninja com id no banco de dados")
    public ResponseEntity<?> listarNinjaPorId(@PathVariable Long id) {
         NinjaDTO ninja = ninjaService.listarPorId(id);
         if(ninja!=null)
             return ResponseEntity.ok(ninja);
         else
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja não encontrado");
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Alterar ninjas", description = "Essa rota permite atualizar um ninja salvo no banco de dados atraves do id")
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
    @Operation(summary = "Deletar ninja", description = "Essa rota permite deletar ninja salvo no banco de dados pelo id")
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
