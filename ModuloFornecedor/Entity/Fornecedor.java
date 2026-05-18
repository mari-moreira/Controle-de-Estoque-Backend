package ModuloFornecedor.Entity;

import jakarta.persistence.*;

@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cnpj;
    private String telefone;
    private String endereco;
    private String cidade;
    private String produtoFornecidoA;
    private String produtoFornecidoB;

    public Fornecedor() {}

    public Fornecedor(String nome, String cnpj, String telefone, String endereco, String cidade, String produtoFornecidoA, String produtoFornecidoB) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cidade = cidade;
        this.produtoFornecidoA = produtoFornecidoA;
        this.produtoFornecidoB = produtoFornecidoB;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getCnpj() { return cnpj; }
    public String getTelefone() { return telefone; }
    public String getEndereco() { return endereco; }
    public String getCidade() { return cidade; }
    public String getProdutoFornecidoA() { return produtoFornecidoA; }
    public String getProdutoFornecidoB() { return produtoFornecidoB; }

    public void setNome(String nome) { this.nome = nome; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public void setProdutoFornecidoA(String produtoFornecidoA) { this.produtoFornecidoA = produtoFornecidoA; }
    public void setProdutoFornecidoB(String produtoFornecidoB) { this.produtoFornecidoB = produtoFornecidoB; }
}