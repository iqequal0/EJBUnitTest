/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.glassfishembeded.remote;

import com.creditcloud.glassfishembededinf.IHelloWorld;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author sobranie
 */
@Stateless
@Remote(IHelloWorld.class)
public class HelloWorldRemote implements IHelloWorld {

    @Override
    public String say() {
        return "HelloWorld";
    }

}
