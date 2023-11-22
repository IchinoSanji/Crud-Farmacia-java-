package entities;

public class Medicamento {
    private final int id;
    private final String nome;
    private final double valor;
    private final int qtd;
    private final String descricao;


    public Medicamento(int id, String nome, double valor, int qtd, String descricao) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.qtd = qtd;
        this.descricao = descricao;
    }
    public String getNome() {
        return nome;
    }
    public int getId() {
        return id;
    }
    public double getValor() {
        return valor;
    }
    public int getQtd() {
        return qtd;
    }
    public String getDescricao() {
        return descricao;
    }

}
