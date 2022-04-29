package ac.ucr.b96086.persistence;

import ac.ucr.b96086.persistence.strategy.JsonPersistence;

public class PersistenceContext {
    private String root;
    private PersistenceStrategy strategy;

    private static PersistenceContext instance;

    private PersistenceContext() {
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public void setStrategy(PersistenceStrategy strategy) {
        this.strategy = strategy;
    }

    public static PersistenceContext getInstance() {
        if (instance == null) {
            instance = new PersistenceContext();
        }
        return instance;
    }

    public <E extends PersistenceEntity> Persistence<E> getPersistenceInstance() {
        switch (strategy) {
            case XML:
                throw new RuntimeException("Estrategia no implementada");
            case JSON:
                return new JsonPersistence<>(root);
        }
        return null;
    }
}