package org.cstefana.finalCalss.finalMethod;

class Author {
    Author() {
    }

    public void createdBy() {
        System.out.println("Created by Me");
    }
}

class Book extends Author {
    Book() {
    }

    public void createdBy() {
        System.out.println("Created by Book printer");
    }
}

public class Main {
    public static void main(String[] args) {
        Author author = new Book();
        author.createdBy();
    }
}
