package ModuloCliente.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {
   @Id
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   private Long id;
   private String nome;
   private String cpf;
   private String telefone;
   private String endereco;

   public Cliente() {
   }

   public Cliente(String nome, String cpf, String telefone, String endereco) {
      this.nome = nome;
      this.cpf = cpf;
      this.telefone = telefone;
      this.endereco = endereco;
   }

   public Long getId() {
      return this.id;
   }

   public String getNome() {
      return this.nome;
   }

   public String getCpf() {
      return this.cpf;
   }

   public String getTelefone() {
      return this.telefone;
   }

   public String getEndereco() {
      return this.endereco;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public void setCnpj(String cpf) {
      this.cpf = cpf;
   }

   public void setTelefone(String telefone) {
      this.telefone = telefone;
   }

   public void setEndereco(String endereco) {
      this.endereco = endereco;
   }
}