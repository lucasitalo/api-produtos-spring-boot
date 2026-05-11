package br.com.lucasitalo.produtos.controller;

import br.com.lucasitalo.produtos.dto.ProdutoRequestDTO;
import br.com.lucasitalo.produtos.dto.ProdutoResponseDTO;
import br.com.lucasitalo.produtos.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Produtos", description = "Gerenciamento de produtos")
@RestController
@RequestMapping("/produtos")

public class ProdutoController {

     private final ProdutoService service;

     public ProdutoController(ProdutoService service){
         this.service = service;
     }

     @GetMapping
     @Operation(summary = "Listar todos os produtos")
     @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public List<ProdutoResponseDTO> listar() {
         return service.listarTodos();

     }

    @PostMapping
    @Operation(summary = "Cadastrar um novo produto")
    @ApiResponse(responseCode = "201", description = "Produto cadastrado com sucesso")
    @ApiResponse(responseCode = "409", description = "Já existe um produto com esse nome")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    public ProdutoResponseDTO salvar(@Valid @RequestBody ProdutoRequestDTO dto){
         return service.salvar(dto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar produto por ID")
    @ApiResponse(responseCode = "200", description = "Produto encontrado")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    public ProdutoResponseDTO buscaPorId(@PathVariable Long id){
         return service.buscaPorId(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir um produto")
    @ApiResponse(responseCode = "204", description = "Produto excluido com sucesso")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um  produto")
    @ApiResponse(responseCode = "201", description = "Produto atualizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    @ApiResponse(responseCode = "409", description = "Já existe um produto com esse nome")
    public ProdutoResponseDTO atualizar(@PathVariable Long id, @Valid
                                        @RequestBody ProdutoRequestDTO dto){
    return service.atualizar(id, dto);
    }

}
