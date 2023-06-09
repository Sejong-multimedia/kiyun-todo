package com.mysite.todo.todoList;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ToDoService {
    private final ToDoRepository toDoRepository;

    public List<ToDoEntity> getList(){
        return this.toDoRepository.findAll();
    }
    //아이템 추가하기
    public void create(String content){
        ToDoEntity toDoEntity = new ToDoEntity();
        toDoEntity.setContent(content);
        toDoEntity.setCompleted(false);
        this.toDoRepository.save(toDoEntity);
    }

    //아이템 삭제하기
    @Transactional
    public void delete(Integer id){
        ToDoEntity toDoEntity = toDoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 아이템이 없습니다. id=" + id));
        this.toDoRepository.delete(toDoEntity);
    }

    //아이템 수정하기
    @Transactional
    public void update(Integer id, String content){
        ToDoEntity toDoEntity = toDoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 아이템이 없습니다. id=" + id));
        toDoEntity.setContent(content);
        this.toDoRepository.save(toDoEntity);
    }
}