/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.glassfishembeded.local;

import com.creditcloud.glassfishembeded.local.api.IHelloWorldLocal;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @author sobranie
 */
@Stateless
@Local(IHelloWorldLocal.class)
public class HelloWorldLocal implements IHelloWorldLocal {

    @Override
    public String sayLocal() {
        return "HelloWorldLocal";
    }

}
