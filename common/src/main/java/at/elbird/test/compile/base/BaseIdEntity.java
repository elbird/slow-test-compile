package at.elbird.test.compile.base;

/**
 * Used to mark an entity
 * This interface is package private to disallow direct usage of this interface in entity classes.
 * Entities should implement one of the following interfaces: {@link IntIdEntity}, {@link ObjectIdEntity} or {@link MasterData}
 */
interface BaseIdEntity {
}
