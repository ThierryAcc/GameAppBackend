# What did we do?

- Was ist eine relationale DB?
- Was ist NoSQL?
- Was ist Relation?
- Was ein Schema?
- Was ist DNS?
- Was ist JDBC?
- Was ist eine API?
- Was ist ein Primary Key?
- Was ist ein Foreign Key? - Referentielle Integrity
- Was ist eine Query?
- Basic SQL:
    - Insert
    - Update
    - Delete
    - Select
    - Inner Join (explicit/implicit)
    - Left Join
    - Select, From, Where, Order, Limit
    - Table Alias 
    - create Database
    - create table
    - truncate <table>
    - drop table
    - select count(*) 
    - LIKE '%Halo%' in WHERE
    - Großer/Kleine etc sind möglich bei Zahlenspalten
- Was ist ACID?
- Was ist eine Transaction?
    - setAutoCommit(false|true)
    - start transaction;
    - rollback();
    - commit()
- ResultSet
    - getString(1)
    - getInt
    - getBoolean
    - next() -> gibt true zurück!! while(resultSet.next())
- Was ist die 3te Normalform? Was ist normalisiert, was denormalisiert?    
- Was ist ein Model?
- Was ist eine JDBC Connection?
- Was ist ein Prepared Statement? Wird am Server kompiliert, optimale ausführungsgeschwindigkeit, sicherer vor SQL Injections
- SQLException (checked Exception)
- Connection immer im finally block closen!!!!!111!!elf!!111!!!!
- Was ist Datenmapping?
- Separation of Concerns, Class/Method responsibility

- Was ist Hibernate? Was ist JPA?
- Was ist ein Mapping?
- Was macht @Table
- Was macht @Entity
- Was ist OneToMany, ManyToOne, OneToOne, ManyToMany
- Lazy Loading
- Hibernate kann Tabellen erzeugen
- Was macht der EntityManager?
- Was ist @Id

## Marcels Annotation List

- @Entity
    -> Eine Klasse mit dieser Annontation ist eine Klasse die Hibernate verwenden kann. 
    Es handelt sich jetzt offziell um eine Model-Klasse die im "Persistence Context" existieren.
- @Table
    -> Mapped eine Klasse zu einer Tabelle
    Optional when Tabellen-Name = Klassenname     
- @Column
    -> Mapped ein Objekt-Property (Feld, Member, Variable etc) zu einer Tabellen-Spalte. 
    Optional wenn Spaltennamen = Objekt-Feldname
- @Id
    -> Markiert ein Feld als "Primary Key"    
- @GeneratedValue
    -> Gibt Anweisungen wie der Primary Key erzeugt werden soll. 
        Oracle: z.b. macht Sequenzen
        MySQL: z.b. macht mit Auto Increment
- @OneToMany: Mapped ein Ding zu vielen 
  @ManyToOne: Mapped viele Dinge zu einem
  @OneToOne: Mapped ein Ding zu einem anderen Ding
  @ManyToMany: Mapped viele Dinge zu vielen anderen Dingen
- @JoinTable, @JoinColumn: Wie sollen viele Dinge zu vielen anderen Dingen gemapped werden?              

MORGEN:

- Connection pool
- DTO

