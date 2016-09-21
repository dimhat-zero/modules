package com.jianla.faudit.entity;

import javax.persistence.*;

/**
 * 实地审核表
 *
 * @author : zwj
 * @data : 2016/9/21
 */
@Entity
@Table(name="faudit")
public class Faudit {

    @Id
    @GeneratedValue
    @Column(name="id",nullable = false,unique = true)
    private Long id;

    @Column(name="answer_id")
    private Long answerId;

    //...
}
