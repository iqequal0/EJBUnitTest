/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.jpaejb.local;

import com.creditcloud.jpaejb.entities.Student;
import com.creditcloud.jpaejb.entities.dao.StudentDao;
import com.creditcloud.jpaejb.local.api.StudentService;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Singleton;
import javax.ejb.Stateless;

/**
 *
 * @author sobranie
 */
@Singleton
@Stateless
@Local(StudentService.class)
public class StudentServiceBean implements StudentService {

    @EJB
    StudentDao studentDao;

    /**
     *
     * @param id
     * @return
     */
    @Override
    public String getSchool(int id) {
        Student student = studentDao.queryUserById(id);
        if (student != null) {
            return student.getSchool();
        }
        return null;
    }

}
