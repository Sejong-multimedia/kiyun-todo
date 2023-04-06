/*Entity = DB에 저장하기 위해 유저가 정의한 클래스*/

package com.mysite.todo.todoList;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class ToDoEntity {

    /*ID = 기본 키, 번호로 이용 예정*/
    /*1씩 자동증가*/
    @Id                                                     /*primary key를 가지는 변수 선언*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)     /*strategy = 고유번호 생성옵션*/
    private Integer id;                                     /*GenerationType=IDENTITY = 해당 컬럼의 독립적인 시퀀스 생성*/                                            /*GeneratedValue = Id값을 어떻게 자동으로 생성할건지*/

    /*Column의 세부설정*/
    @Column(length=200)
    private String content;
    @Column(nullable = false)
    private Boolean completed;
}