package co.com.sofka.kataCrud.repository;

import co.com.sofka.kataCrud.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
}
