/*Controller : 중간 제어자 역할, MVC_Structure(Model_View_Controller)*/

package com.mysite.todo.todoList;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;   /*@Controller 사용하기 위해 import*/
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;   /*.annotation.RequestMapping*/

@RequiredArgsConstructor
@Controller                                 /*Controller*/
public class ToDoController {

    private final ToDoService toDoService;

    @RequestMapping("/todo")            /*요청주소와 실제주소를 매핑*/
    public String list(Model model){
        List<ToDoEntity> toDoEntityList = this.toDoService.getList();
        model.addAttribute("toDoEntityList",toDoEntityList);
        return "todolist";
    }
    @RequestMapping("/")
    public String root(){
        return "redirect:/todo";
    }

    //아이템 추가하기
    @PostMapping("/todo/create")
    public String todoCreate(@RequestParam String content){

        this.toDoService.create(content);
        // : 아이템 삽입
        // 다시 원래 화면으로 리다이렉트
        return "redirect:/todo";
    }

    //아이템 삭제하기
    @DeleteMapping("/todo/delete/{id}")
    public String toDoDelete(@PathVariable Integer id){
        this.toDoService.delete(id);
        return "redirect:/todo";
    }

    //아이템 수정하기
    @PutMapping("/todo/update/{id}")
    public String todoUpdate(@RequestBody String content, @PathVariable Integer id){
        this.toDoService.update(id,content);
        return "redirect:/todo";
    }

}