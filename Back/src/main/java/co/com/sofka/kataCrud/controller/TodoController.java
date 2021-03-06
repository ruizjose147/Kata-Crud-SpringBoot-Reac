package co.com.sofka.kataCrud.controller;

import co.com.sofka.kataCrud.model.Todo;
import co.com.sofka.kataCrud.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.util.Elements;
import javax.websocket.server.PathParam;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping(value = "api/list")
    public Iterable<Todo> list(){
        return service.list();
    }

    @PostMapping(value = "api/todo")
    public Todo save(@RequestBody Todo todo){
        return service.save(todo);
    }

    @PutMapping(value = "api/todo")
    public Todo update(@RequestBody Todo todo){
        if (todo.getId() != null){
            return service.save(todo);
        }
        throw new RuntimeException("No existe el id para actualizar");
    }

    @DeleteMapping(value = "api/{id}/todo")
    public void delete(@PathParam("id") Long id){
        service.delete(id);
    }

    @GetMapping(value = "api/{id}/todo")
    public Todo get(@PathParam("id") Long id){
        return service.get(id);
    }

}
