package poo.restaurante.data;

import java.util.Collection;

public interface IPratoDAO {
    Prato getPrato(Long id);
    Collection<Prato> find(String nome);
    Collection<Prato> cardapio();
}
