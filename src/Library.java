import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n0+++++++++++++++++++++++++++++++++++++++++++++++++++++0");
            System.out.println("1. Ajouter un livre");
            System.out.println("2. Afficher tous les livres");
            System.out.println("3. Rechercher un livre par nom");
            System.out.println("4. Emprunter un livre");
            System.out.println("5. Rendre un livre");
            System.out.println("6. Afficher les livres disponibles");
            System.out.println("7. Modifier les informations d’un livre");
            System.out.println("8. Quitter");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consommer le saut de ligne

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    displayBooks();
                    break;
                case 3:
                    searchBookByName(scanner);
                    break;
                case 4:
                    borrowBook(scanner);
                    break;
                case 5:
                    returnBook(scanner);
                    break;
                case 6:
                    displayAvailableBooks();
                    break;
                case 7:
                    editBook(scanner);
                    break;
                case 8:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        } while (choice != 8);
        scanner.close();
    }

    private static void addBook(Scanner scanner) {
        System.out.print("Nom du livre : ");
        String name = scanner.nextLine();
        System.out.print("Nombre de pages : ");
        int pages = scanner.nextInt();
        System.out.print("Année de publication : ");
        int years = scanner.nextInt();
        scanner.nextLine(); // Consommer le saut de ligne
        System.out.print("Genre : ");
        String genderName = scanner.nextLine();
        System.out.print("Prénom de l'auteur : ");
        String authorFirstName = scanner.nextLine();
        System.out.print("Nom de l'auteur : ");
        String authorLastName = scanner.nextLine();
        System.out.print("Éditeur : ");
        String editor = scanner.nextLine();

        Gender gender = new Gender(genderName);
        Author author = new Author(authorFirstName, authorLastName);
        books.add(new Book(name, pages, gender, years, author, editor, true));
        System.out.println("Livre ajouté avec succès !");
    }

    private static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Aucun livre disponible.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private static void searchBookByName(Scanner scanner) {
        System.out.print("Entrez le nom du livre : ");
        String bookName = scanner.nextLine();
        boolean found = false;
        for (Book book : books) {
            if (book.getName().equalsIgnoreCase(bookName)) {
                System.out.println("Livre trouvé : " + book);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Livre non trouvé.");
        }
    }

    private static void borrowBook(Scanner scanner) {
        System.out.print("Entrez le nom du livre à emprunter : ");
        String bookName = scanner.nextLine();
        for (Book book : books) {
            if (book.getName().equalsIgnoreCase(bookName) && book.isAvailable()) {
                book.setAvailability(false);
                System.out.println("Vous avez emprunté le livre : " + bookName);
                return;
            }
        }
        System.out.println("Livre non disponible ou non trouvé.");
    }

    private static void returnBook(Scanner scanner) {
        System.out.print("Entrez le nom du livre à rendre : ");
        String bookName = scanner.nextLine();
        for (Book book : books) {
            if (book.getName().equalsIgnoreCase(bookName) && !book.isAvailable()) {
                book.setAvailability(true);
                System.out.println("Merci d'avoir rendu le livre : " + bookName);
                return;
            }
        }
        System.out.println("Ce livre n'est pas enregistré comme emprunté.");
    }

    private static void displayAvailableBooks() {
        boolean anyAvailable = false;
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
                anyAvailable = true;
            }
        }
        if (!anyAvailable) {
            System.out.println("Aucun livre disponible.");
        }
    }

    private static void editBook(Scanner scanner) {
        System.out.print("Entrez le nom du livre à modifier : ");
        String bookName = scanner.nextLine();
        for (Book book : books) {
            if (book.getName().equalsIgnoreCase(bookName)) {
                System.out.print("Nouveau nom (laissez vide pour ne pas changer) : ");
                String newName = scanner.nextLine();
                if (!newName.isEmpty()) {
                    book.setName(newName);
                }

                System.out.print("Nouveau nombre de pages (0 pour ne pas changer) : ");
                int newPages = scanner.nextInt();
                if (newPages > 0) {
                    book.setPages(newPages);
                }

                scanner.nextLine(); // Consommer le saut de ligne
                System.out.print("Nouveau éditeur (laissez vide pour ne pas changer) : ");
                String newEditor = scanner.nextLine();
                if (!newEditor.isEmpty()) {
                    book.setEditor(newEditor);
                }
                System.out.println("Informations mises à jour !");
                return;
            }
        }
        System.out.println("Livre non trouvé.");
    }

}