package poo.restaurante.data;

import java.util.Collection;

public class PratoDAO extends GenericDAO<Prato, Long> implements IPratoDAO {
    // Singleton
    private static PratoDAO instance;
    public static PratoDAO getInstance() {
        if (instance==null) instance = new PratoDAO();
        return instance;
    }
    private PratoDAO() {
        super(Prato.class);
    }


    @Override
    public Prato getPrato(Long id) {
        return super.findById(id);
    }

    @Override
    public Collection<Prato> find(String nome) {
        return super.findAllBy("nome", nome);
    }

    @Override
    public Collection<Prato> cardapio() {
        return super.findAll();
    }
}
