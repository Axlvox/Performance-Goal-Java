package store.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import store.model.DetalheProduto;
import store.model.Produto;

public class StoreController {
    private Collection<Produto> produtos;

    public StoreController() {
        this.produtos = new ArrayList<>();
    }

    public void cadastrar(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto cadastrado: " + produto.getNome());
    }

    public void listarTodas() {
        System.out.println("Listando todos os produtos:");
        for (Produto produto : produtos) {
            System.out.println(produto.getNome() + " - " + produto.getCodigo());
        }
    }

    public Produto buscarPorNumero(int numero) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == numero) {
                return produto;
            }
        }
        System.out.println("Produto não encontrado para o número: " + numero);
        return null;
    }

    public void adicionarDetalhes(int numero, String detalhes) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == numero) {
                if (produto instanceof DetalheProduto) {
                    DetalheProduto detalheProduto = (DetalheProduto) produto;
                    detalheProduto.setDetalheTipo(detalhes);
                    System.out.println("Detalhes adicionados ao produto " + numero + ": " + detalhes);
                    return;
                } else {
                    System.out.println("Este produto não suporta detalhes adicionais.");
                    return;
                }
            }
        }
        System.out.println("Produto não encontrado para o número: " + numero);
    }

    public void atualizar(Produto produto) {
        int codigo = produto.getCodigo();
        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                p.setNome(produto.getNome());
                p.setPreco(produto.getPreco());
                System.out.println("Produto atualizado: " + produto.getNome());
                return;
            }
        }
        System.out.println("Produto não encontrado para o número: " + produto.getCodigo());
    }

    public void deletar(int numero) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == numero) {
                produtos.remove(produto);
                System.out.println("Produto removido: " + produto.getNome());
                return;
            }
        }
        System.out.println("Produto não encontrado para o número: " + numero);
    }
}
