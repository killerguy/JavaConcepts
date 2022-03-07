package com.mukul.whatstheoutput;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MultipleSort {
    public static void main(String[] args) {

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(500, "Core Java", 200, "Kathy Sierra", 1065.5));
        bookList.add(new Book(501, "JSP & Servlets", 350, "Kathy Sierra", 1749.0));
        bookList.add(new Book(502, "Spring in Action", 480, "Craig Walls", 940.75));
        bookList.add(new Book(503, "Pro Angular", 260, "Freeman", 1949.25));
        bookList.add(new Book(504, "HTML CSS", 100, "Thomas Powell", 2317.09));
        bookList.add(new Book(505, "Hibernate in Action", 180, "Gavin King", 889.25));

        System.out.println("Sort List of Book objects by BookName");
        //Sort by Name
        bookList.stream()
                .sorted((book1, book2) -> book1.getName().compareToIgnoreCase(book2.getName()))
                .forEach(System.out::println);

        // Create Comparators for Name, Author & Cost fields respectively
        System.out.println("\nSort list of book objects by name then by author then by cost");
        Comparator<Book> sortByName = (b1, b2) -> b1.getName().compareToIgnoreCase(b2.getName());
        Comparator<Book> sortByAuthor = (b1, b2) -> b1.getAuthor().compareToIgnoreCase(b2.getAuthor());
        Comparator<Book> sortByCost = Comparator.comparingDouble(Book::getCost);

        //Sort by Name then Sort by Author then sort by Cost
        bookList.stream()
                .sorted(sortByName
                        .thenComparing(sortByAuthor)
                        .thenComparing(sortByCost))
                .forEach(System.out::println);
    }
}

class Book {

    private int id;
    private String name;
    private final int pages;
    private final String author;
    private final double cost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }

    public Double getCost() {
        return cost;
    }


    public Book(Integer id, String name, Integer pages, String author, Double cost) {
        this.id = id;
        this.name = name;
        this.pages = pages;
        this.author = author;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", pages=" + pages + ", author=" + author + ", cost=" + cost + "]";
    }
}
