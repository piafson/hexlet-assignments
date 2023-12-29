package exercise.service;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    // BEGIN
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    public List<BookDTO> getAll() {
        var books = bookRepository.findAll();
        var result = books.stream()
                .map(bookMapper::map)
                .toList();
        return result;
    }

    public BookDTO findById (long id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found " + id));
        var bookDTO = bookMapper.map(book);
        return bookDTO;
    }

    public BookDTO create(BookCreateDTO data) {
        var book = bookMapper.map(data);
        bookRepository.save(book);
        var bookDTO = bookMapper.map(book);
        return bookDTO;

    }

    public BookDTO update(BookUpdateDTO data, long id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found "));
        bookMapper.update(data, book);
        bookRepository.save(book);
        var bookDTO = bookMapper.map(book);
        return bookDTO;
    }

    public void delete(long id) {
        bookRepository.deleteById(id);
    }
    // END
}
