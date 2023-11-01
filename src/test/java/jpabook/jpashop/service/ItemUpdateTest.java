package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemUpdateTest {
    @Autowired
    EntityManager em;
    @Test
    void ItemUpdateTest() throws Exception {
        Book book = em.find(Book.class, 1L);

        // 변경감지 == dirty checking
        // setter 호출 후 persist에 다시 넣는 작업 없이 자동으로 변경을 감지함
        book.setName("asdfa");

        // then
        // 준영속 상태 : 데이터베이스에 들어갔다 나와서 식별자가 있는 자바 객체
    }
}
