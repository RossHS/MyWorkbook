package javaCore.generics;

import java.util.ArrayList;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 16.04.2018
 */
public class test {
    public static void main(String[] args) {
        Object a = new ArrayList<Integer>();
        Cloneable cloneable =(Cloneable) a;
        System.out.println(cloneable.getClass());
    }
}
