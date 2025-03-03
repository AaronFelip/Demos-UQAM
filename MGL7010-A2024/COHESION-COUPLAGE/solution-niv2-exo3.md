## Exercice 3 du niveau 2 : Conception d'un module cohésif pour un système de gestion de bibliothèque

### Conception du Module de Gestion de Bibliothèque
Pour créer un module cohésif, nous allons définir plusieurs classes ayant chacune une responsabilité unique dans le système de gestion de bibliothèque. Voici les classes que nous allons concevoir :

1. **Library** : Gère les opérations générales de la bibliothèque.
2. **Book** : Représente un livre avec ses attributs de base.
3. **Member** : Représente un membre de la bibliothèque.
4. **LoanService** : Gère les emprunts et retours de livres.
5. **NotificationService** : Gère les notifications (par exemple, pour les livres en retard).

#### 1. Classe `Library`

La classe `Library` gère l'ajout de livres et de membres, et maintient la liste des livres et des membres de la bibliothèque.

```java
public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Member> getMembers() {
        return members;
    }
}
```

*Explication* : `Library` a la responsabilité de gérer la collection de livres et de membres, fournissant ainsi une vue d'ensemble sur les ressources disponibles dans la bibliothèque.

#### 2. Classe `Book`

La classe `Book` représente un livre et inclut des attributs tels que le titre, l'auteur, et l'identifiant unique (ISBN).

```java
public class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Getters pour les attributs
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }
}
```

*Explication* : `Book` représente les caractéristiques d'un livre de manière cohésive, sans dépendre d'autres classes.

#### 3. Classe `Member`

La classe `Member` représente un membre de la bibliothèque, avec des informations de base comme le nom et l'identifiant.

```java
public class Member {
    private String name;
    private String memberId;

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public String getMemberId() {
        return memberId;
    }
}
```

*Explication* : `Member` stocke les informations d'un membre, respectant ainsi le principe de cohésion en encapsulant ces informations dans une seule classe.

#### 4. Classe `LoanService`

La classe `LoanService` gère les emprunts et retours de livres. Elle utilise les classes `Book` et `Member` pour représenter les livres empruntés par les membres.

```java
public class LoanService {
    private Map<Member, List<Book>> loans = new HashMap<>();

    public void borrowBook(Member member, Book book) {
        loans.computeIfAbsent(member, k -> new ArrayList<>()).add(book);
    }

    public void returnBook(Member member, Book book) {
        if (loans.containsKey(member)) {
            loans.get(member).remove(book);
        }
    }

    public List<Book> getLoansForMember(Member member) {
        return loans.getOrDefault(member, new ArrayList<>());
    }
}
```

*Explication* : `LoanService` gère les transactions de prêts, maintenant ainsi une cohésion forte en se concentrant uniquement sur les opérations de prêt et de retour.

#### 5. Classe `NotificationService`

La classe `NotificationService` envoie des notifications, comme pour avertir les membres des livres en retard.

```java
public class NotificationService {
    public void sendOverdueNotification(Member member, Book book) {
        // Logique pour envoyer une notification de retard
        System.out.println("Notification envoyée à " + member.getName() + " pour le livre : " + book.getTitle());
    }
}
```

*Explication* : `NotificationService` est dédiée aux notifications, permettant ainsi de gérer la communication de manière séparée des autres opérations.

### Conclusion
Ce module de gestion de bibliothèque est bien structuré, avec des classes fortement cohésives qui facilitent la maintenance et l'extension du système. Chaque classe a une responsabilité unique, ce qui rend le module plus modulaire et adapté à des changements futurs.
