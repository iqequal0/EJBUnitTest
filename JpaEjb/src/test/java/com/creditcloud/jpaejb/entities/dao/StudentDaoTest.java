/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.jpaejb.entities.dao;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 *
 * @author sobranie
 */
@RunWith(JUnit4.class)
public class StudentDaoTest {

    public StudentDaoTest() {

    }

    static EJBContainer container;
    static Context context;

    @BeforeClass
    public static void setUpClass() {
        Map properties = new HashMap();
        properties.put(EJBContainer.MODULES, new File[]{new File("target/classes"), new File("target/test-classes")});
        //在数据中，需要给系统指定新的安装的位置。
        properties.put("org.glassfish.ejb.embedded.glassfish.installation.root", "/Users/sobranie/majinming/glassfish4/glassfish");
        //配置文件的位置
        properties.put("org.glassfish.ejb.embedded.glassfish.configuration.file", "/Users/sobranie/majinming/commomfile/domain.xml");
        container = EJBContainer.createEJBContainer(properties);
        context = container.getContext();
        System.err.println("Opening the Container");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        container.close();
    }

    @Test
    public void testQueryUserById() throws NamingException {
        StudentDao dao = (StudentDao) context.lookup("java:global/classes/StudentDao");
        System.out.println("------------------------------------");
        System.out.println("RRRRRRRREEEEEEEEEEESSSSSSSSSSSSUUUUUUUUULLLLLLLTTTTTTT is: " + dao.queryUserById(1).getSchool());
        System.out.println("------------------------------------");
        Assert.assertEquals("bupt", dao.queryUserById(1).getSchool());
    }

}
