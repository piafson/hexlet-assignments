package exercise.service;

import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    // BEGIN
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    AuthorMapper authorMapper;

    public List<AuthorDTO> getAll() {
        var authors = authorRepository.findAll();
        var result =  authors.stream()
                .map(authorMapper::map)
                .toList();
        return result;
    }

    public AuthorDTO findById(long id) {
        var authors = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found " + id));
        var authorDTO = authorMapper.map(authors);
        return authorDTO;
    }

    public AuthorDTO create(AuthorCreateDTO data) {
        var author = authorMapper.map(data);
        authorRepository.save(author);
        var authorDTO = authorMapper.map(author);
        return authorDTO;
    }

    public AuthorDTO update(AuthorUpdateDTO data, long id) {
        var author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found "));
        authorMapper.update(data, author);
        authorRepository.save(author);
        var authorDTO = authorMapper.map(author);
        return authorDTO;
    }

    public void delete(long id) {
        authorRepository.deleteById(id);
    }
    // END
}
