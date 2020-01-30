package poo.restaurante.data;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "pratos")
public class Prato implements Serializable {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    private Long id;

    @Column(name="nome")
    private String nome;

    @Column(name="preco")
    private Double preco;

    //@ElementCollection
    //private Collection<String> ingredientes;

    public Prato() {

    }
    public Prato(String nome, Double preco) { //}, Collection<String> ingredientes) {
        this.nome = nome;
        this.preco = preco;
        //this.ingredientes = ingredientes;
    }
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    //public Collection<String> getIngredientes() {
    //    return ingredientes;
    //}

    public void setNome(String nome) {
        this.nome=nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //public void setIngredientes(Collection<String> ingredientes) {
    //    this.ingredientes = ingredientes;
    //}

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
