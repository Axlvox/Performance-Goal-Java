package store.model;

public class DetalheProduto extends Produto {

    private String detalheTipo;
    private String nomeCientifico;

    public DetalheProduto(int codigo, String nome, float preco, String detalheTipo, String nomeCientifico) {
        super(codigo, nome, preco);
        this.detalheTipo = detalheTipo;
        this.nomeCientifico = nomeCientifico;
    }

    public String getDetalheTipo() {
        return detalheTipo;
    }

    public void setDetalheTipo(String detalheTipo) {
        this.detalheTipo = detalheTipo;
    }

    public String getNomeCientifico() {
        return nomeCientifico;
    }

    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }

    @Override
    public void setTipo(String tipo) {
        this.detalheTipo = tipo;
    }
}

\\Teste
