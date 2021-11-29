package at.elbird.test.compile.base;

/**
 * Abstract class to provide default equals() and hashCode()
 * implementations for entities
 * @param <T> the IdEntity type.
 */
public abstract class BaseEntity<T extends BaseIdEntity> {


    private boolean bothNotNullAndEquals(Object o1, Object o2) {
        return o1 != null && o1.equals(o2);
    }

    private boolean bothNot0AndEqual(int id1, int id2) {
        return id1 != 0 && id1 == id2;
    }


    private int hashCodeForIntId(int id) {
        if (id != 0) {
            return id;
        }
        return 42;
    }

    private int hashCodeForObjectId(Object id) {
        if (id != null) {
            return id.hashCode();
        }
        return 42;
    }

    @Override
    public int hashCode() {
        if (this instanceof IntIdEntity) {
            return hashCodeForIntId(((IntIdEntity) this).getId());
        } else if (this instanceof MasterData) {
            return hashCodeForObjectId(((MasterData) this).getKey());
        } else if (this instanceof ObjectIdEntity<?>) {
            return hashCodeForObjectId(((ObjectIdEntity<?>) this).getId());
        }
        throw new IllegalStateException("Unknown BaseIdIdentity subtype: " + this.getClass());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !this.getClass().equals(obj.getClass())) {
            return false;
        }
        if (this instanceof IntIdEntity) {
            return bothNot0AndEqual(((IntIdEntity) this).getId(), ((IntIdEntity) obj).getId());
        } else if (this instanceof MasterData) {
            return bothNotNullAndEquals(((MasterData) this).getKey(), ((MasterData) obj).getKey());
        } else if (this instanceof ObjectIdEntity<?>) {
            return bothNotNullAndEquals(((ObjectIdEntity<?>) this).getId(), ((ObjectIdEntity<?>) obj).getId());
        }
        throw new IllegalStateException("Unknown BaseIdIdentity subtype: " + this.getClass());
    }
}
