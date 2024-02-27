package store.repository;

import store.model.Produto;

public interface StoreRepository {
    void cadastrar(Produto produto);

    void listarTodas();

    void buscarPorNumero(int numero);

    void adicionarDetalhes(int numero, String detalhes);

    void atualizar(Produto produto);

    void deletar(int numero);
}
