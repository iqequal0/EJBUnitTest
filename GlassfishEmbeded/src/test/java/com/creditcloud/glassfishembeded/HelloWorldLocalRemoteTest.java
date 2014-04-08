package com.creditcloud.glassfishembeded;

import com.creditcloud.glassfishembeded.local.api.IHelloWorldLocal;
import com.creditcloud.glassfishembededinf.IHelloWorld;
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

@RunWith(JUnit4.class)
public class HelloWorldLocalRemoteTest {

    public HelloWorldLocalRemoteTest() {

    }

    static EJBContainer container;
    static Context context;

    @BeforeClass
    public static void setUpClass() {
        Map properties = new HashMap();
        // 指定的编译的位置
        properties.put(EJBContainer.MODULES, new File[]{new File("target/classes"), new File("target/test-classes")});
        // 服务器的安装的位置
        properties.put("org.glassfish.ejb.embedded.glassfish.installation.root", "/Users/sobranie/majinming/glassfish4/glassfish");
        //指定服务器的配置文件的位置
        properties.put("org.glassfish.ejb.embedded.glassfish.configuration.file", "/Users/sobranie/majinming/commomfile/domain.xml");
        container = EJBContainer.createEJBContainer();
        context = container.getContext();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        container.close();
    }

    /**
     * Test of say method, of class HelloWorldService.
     *
     * @throws java.lang.Exception
     */
    @Test //运行正式的测试内容
    public void testSayLocal() throws Exception {
        IHelloWorldLocal helloWorld = (IHelloWorldLocal) context.lookup("java:global/classes/HelloWorldLocal");
        System.err.println("------------------------------------");
        System.err.println("RRRRRRRREEEEEEEEEEESSSSSSSSSSSSUUUUUUUUULLLLLLLTTTTTTT is: " + helloWorld.sayLocal());
        System.err.println("------------------------------------");
        Assert.assertEquals("HelloWorldLocal", helloWorld.sayLocal());
    }

    @Test
    public void testSayRemote() throws NamingException {
        IHelloWorld helloWorld = (IHelloWorld) context.lookup("java:global/classes/HelloWorldRemote");
        System.err.println("------------------------------------");
        System.err.println("RRRRRRRREEEEEEEEEEESSSSSSSSSSSSUUUUUUUUULLLLLLLTTTTTTT is: " + helloWorld.say());
        System.err.println("------------------------------------");
        Assert.assertEquals("HelloWorld", helloWorld.say());
    }
}
