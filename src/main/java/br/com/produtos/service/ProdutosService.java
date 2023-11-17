package br.com.produtos.service;

import br.com.produtos.domain.Produtos;
import br.com.produtos.dto.ProdutosDto;
import br.com.produtos.dto.ProdutosDtoRequest;
import br.com.produtos.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProdutosService {
    @Autowired
    private ProdutosRepository repository;

    public ProdutosDto salvar(ProdutosDtoRequest request) {
        Produtos produtos = this.mapeiaProdutoSalvar(request);
        produtos = repository.save(produtos);
        ProdutosDto dto = this.mapeiaProdutoDto(produtos);
        return dto;
    }

    private ProdutosDto mapeiaProdutoDto(Produtos produtos) {
        if(Objects.nonNull(produtos)){
            ProdutosDto dto = new ProdutosDto();
            dto.setId(produtos.getId());
            dto.setNome(produtos.getNome());
            dto.setDescricao(produtos.getDescricao());
            return dto;
        }
        return null;
    }

    private Produtos mapeiaProdutoSalvar(ProdutosDtoRequest request) {
        if (Objects.nonNull(request)){
            Produtos produtos = new Produtos();
            produtos.setNome(request.getNome());
            produtos.setDescricao(request.getDescricao());
            return produtos;
        }
        return null;
    }

    public List<ProdutosDto> buscarTodos() {
        List<Produtos> listProdutos = repository.findAll();
        List<ProdutosDto> listDto = this.mapeiaListProdutos(listProdutos);
        return listDto;
    }

    private List<ProdutosDto> mapeiaListProdutos(List<Produtos> listProdutos) {
        if(Objects.nonNull(listProdutos)){
            List<ProdutosDto> list = new ArrayList<>();
            listProdutos.forEach( e -> {
                ProdutosDto dto = new ProdutosDto();
                dto.setId(e.getId());
                dto.setNome(e.getNome());
                dto.setDescricao(e.getDescricao());
                list.add(dto);
            });
            return list;
        }
        return null;
    }
}
