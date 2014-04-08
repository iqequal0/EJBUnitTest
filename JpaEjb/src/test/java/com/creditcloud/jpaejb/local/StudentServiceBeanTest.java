/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.jpaejb.local;

import com.creditcloud.jpaejb.local.api.StudentService;
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
public class StudentServiceBeanTest {

    public static EJBContainer container;
    public static Context context;

    @BeforeClass
    public static void setUpClass() {
        Map properties = new HashMap();
        // 字节码的位置
        properties.put(EJBContainer.MODULES, new File[]{new File("target/classes"), new File("target/test-classes")});
        // 服务器的安装的位置
        properties.put("org.glassfish.ejb.embedded.glassfish.installation.root", "/Users/sobranie/majinming/glassfish4/glassfish");
        //指定服务器的配置文件的位置
        properties.put("org.glassfish.ejb.embedded.glassfish.configuration.file", "/Users/sobranie/majinming/commomfile/domain.xml");
        container = EJBContainer.createEJBContainer(properties);
        context = container.getContext();
        System.out.println("Opening the Container");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        container.close();
    }

    public StudentServiceBeanTest() {

    }

    @Test
    public void testGetSchool() throws NamingException {
        StudentService bean = (StudentService) context.lookup("java:global/classes/StudentServiceBean");
        System.out.println("------------TESTGETSCHOOL------------------------");
        String school = bean.getSchool(1);
        System.out.println("RRRRRRRREEEEEEEEEEESSSSSSSSSSSSUUUUUUUUULLLLLLLTTTTTTT is: " + school);
        System.out.println("------------TESTGETSCHOOL------------------------");
        Assert.assertEquals("bupt", school);
    }

}
