package com.example.distributedsystems;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ToDoService {

    private List<ToDo> todos = new ArrayList<>(
            Arrays.asList(
                    new ToDo(1, "task_1", "summary_1", "desc_1"),
                    new ToDo(2, "task_2", "summary_2", "desc_2")
            )
    );

    public List<ToDo> getAllToDos(){
        return todos;
    }

    public ToDo getToDo(Integer id) {
        return todos.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void createToDo(ToDo todo) {
        todos.add(todo);
    }

    public void updateToDo(Integer id, ToDo todo) {
        for(int i=0; i<todos.size(); i++){
            ToDo t = todos.get(i);
            if(t.getId().equals(id)){
                todos.set(i, todo);
                return;
            }
        }
    }

    public void deleteToDo(Integer id) {
        todos.removeIf(t-> t.getId().equals(id));
    }
}