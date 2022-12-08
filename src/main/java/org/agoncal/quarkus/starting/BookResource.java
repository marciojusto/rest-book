package org.agoncal.quarkus.starting;

import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    Logger logger;

    @Inject
    BookRepository bookRepository;

    @GET
    public List<Book> getAll() {
        logger.info("Returns all books");
        return bookRepository.getAll();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countBooks() {
        logger.info("Returns the number of the books");
        return getAll().size();
    }

    @GET
    @Path("{id}")
    public Optional<Book> get(@PathParam("id") int id) {
        logger.info("Returns a single book with id: " + id);
        return getAll().stream().filter(book -> book.id == id).findFirst();
    }
}
