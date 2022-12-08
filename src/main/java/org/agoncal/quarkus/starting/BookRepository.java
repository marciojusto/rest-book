package org.agoncal.quarkus.starting;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name = "books.genre", defaultValue = "Sci-Fi")
    String genre;

    public List<Book> getAll() {
        return List.of(new Book(1,
                                "Understanding Quarkus",
                                "Antonio",
                                2020,
                                genre),
                       new Book(2,
                                "Practising Quarkus",
                                "Antonio",
                                2020,
                                genre),
                       new Book(3,
                                "Effective Java",
                                "Josh Bloch",
                                2001,
                                genre),
                       new Book(4,
                                "Thinking Java",
                                "Bruce Eckel",
                                1998,
                                genre));
    }
}
