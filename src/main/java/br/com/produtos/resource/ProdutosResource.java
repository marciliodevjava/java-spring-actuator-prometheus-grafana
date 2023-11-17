package br.com.produtos.resource;

import br.com.produtos.dto.ProdutosDto;
import br.com.produtos.dto.ProdutosDtoRequest;
import br.com.produtos.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutosResource {
    @Autowired
    private ProdutosService service;

    @PostMapping
    public ResponseEntity<ProdutosDto> salvar (@RequestBody ProdutosDtoRequest request){
        ProdutosDto response = service.salvar(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ProdutosDto>> buscarTodos(){
        List<ProdutosDto> reponse = service.buscarTodos();
        return ResponseEntity.ok(reponse);
    }
}
