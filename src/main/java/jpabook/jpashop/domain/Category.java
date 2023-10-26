package jpabook.jpashop.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Category {
    @Id
    @GeneratedValue
    private Long id;
}
