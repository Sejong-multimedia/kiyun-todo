/*JpaRepository : Entity 의 기본적인 CRUD(Create/Read/Update/Delete)를 가능하게 함*/

package com.mysite.todo.todoList;

import org.springframework.data.jpa.repository.JpaRepository;
public interface ToDoRepository extends JpaRepository<ToDoEntity,Integer>{
    /*JpaRepository<T,ID>,  T=사용할 Entity 클래스*/
    /*JpaRepository 를 상속하기만 해도 적용된다.*/

    /* <JpaRepository 가 Entity 에 제공하는 기본기능>*/
    /*
     * save() : 레코드 저장(insert, update)
     * findOne() : primary key로 레코드 한 건 찾기
     * findAll() : 전체 레코드 불러오기, 정렬(sort)/페이징(pageable)가능
     * count() : 레코드 갯수
     * delete() : 레코드 삭제
     * */

    /* +JpaRepository 의 조회기능
     *
     * findBy_() : 쿼리 요청 메서드
     * countBy_() : 쿼리 결과 레코드 수 요청 메서드
     *  */
}



/* 참고 : https://jobc.tistory.com/120 */