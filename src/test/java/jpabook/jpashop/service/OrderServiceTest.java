package jpabook.jpashop.service;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderServiceTest {
    @Autowired
    EntityManager em;
    @Autowired
    OrderService orderService;

    @Test
    @DisplayName("상품주문")
    void order() throws Exception {
        // given
        Member member = new Member();
        member.setName("회원1");
        member.setAddress(new Address("서울","강가","124024"));
        em.persist(member);

        Book book = new Book();
        book.setName("시골JPA");
        book.setPrice(10000);
        book.setStockQuantity(10);
        // when
        
        // then
    }

    @Test
    @DisplayName("주문취소")
    void cancel() throws Exception {
        // given
        
        // when
        
        // then
    }

    @Test
    @DisplayName("재고수량 초과")
    void stockOver() throws Exception {
        // given
        
        // when
        
        // then
    }
}