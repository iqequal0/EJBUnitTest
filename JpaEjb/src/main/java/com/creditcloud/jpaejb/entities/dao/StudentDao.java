/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.jpaejb.entities.dao;

import com.creditcloud.jpaejb.entities.Student;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sobranie
 */
@Stateless
@LocalBean
public class StudentDao {

    @PersistenceContext(unitName = "Student")
    private EntityManager em;

    public StudentDao() {

    }

    public Student queryUserById(int id) {
        Query query = em.createQuery("select s from Student s where s.id=:id");
        query.setParameter("id", id);
        Student student = (Student) query.getSingleResult();
        return student;
    }

}
