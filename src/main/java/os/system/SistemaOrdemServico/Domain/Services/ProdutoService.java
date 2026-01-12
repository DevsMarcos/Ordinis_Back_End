package os.system.SistemaOrdemServico.Domain.Services;

import os.system.SistemaOrdemServico.Domain.Entities.Produto;
import os.system.SistemaOrdemServico.Domain.Repositories.ProdutoRepository;

import java.util.List;

public class ProdutoService  {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

  public List<Produto> obterTodosOsProdutos(){
        return produtoRepository.findAll();
  }

  public Produto retornarUmProduto(Long id){
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
  }

  public Produto cadastrarProduto(Produto produto){
        return produtoRepository.save(produto);
  }

  public void deletarProduto(Long id){
      produtoRepository.deleteById(id);
  }
}
