package br.com.lucasitalo.produtos.service;
import br.com.lucasitalo.produtos.exceptions.ConflictException;
import br.com.lucasitalo.produtos.exceptions.NotFoundException;
import br.com.lucasitalo.produtos.dto.ProdutoRequestDTO;
import br.com.lucasitalo.produtos.dto.ProdutoResponseDTO;
import br.com.lucasitalo.produtos.entity.Produto;
import br.com.lucasitalo.produtos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }


    public ProdutoResponseDTO salvar(ProdutoRequestDTO dto) {

        if (repository.existsByNome(dto.getNome())){
            throw new ConflictException("Já existe um produto com esse nome");
        }

        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        produto.setQuantidade(dto.getQuantidade());

        Produto salvo = repository.save(produto);

        return converterParaResponse(salvo);
    }

    public List<ProdutoResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }
        private ProdutoResponseDTO converterParaResponse(Produto produto) {
              ProdutoResponseDTO dto = new ProdutoResponseDTO();
              dto.setId(produto.getId());
              dto.setNome(produto.getNome());
              dto.setDescricao(produto.getDescricao());
              dto.setPreco(produto.getPreco());
              dto.setQuantidade(produto.getQuantidade());
              return dto;

    }

    public ProdutoResponseDTO buscaPorId(Long id){
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto não encontrado"));
        return converterParaResponse(produto);

    }

    public void deletar(Long id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto não encontrado"));
        repository.delete(produto);
    }

    public ProdutoResponseDTO atualizar (Long id, ProdutoRequestDTO dto){
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto não encontrado"));
        if (repository.existsByNome(dto.getNome()) && !produto.getNome().equals(dto.getNome())){
            throw new ConflictException("Já existe um produto com esse nome");
        }

        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        produto.setQuantidade(dto.getQuantidade());

        Produto atualizado = repository.save(produto);
        return converterParaResponse(atualizado);

    }

}
