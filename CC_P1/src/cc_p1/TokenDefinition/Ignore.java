/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc_p1.TokenDefinition;

import java.lang.reflect.Field;

/**
 *
 * @author tim
 */
public class Ignore {
    final static String i_white = "\\s*";

    public static boolean match(String value) {
        for (Field field : Ignore.class.getDeclaredFields()) {
            try {
                if (value.matches((String) field.get(null))) {
                    return true;
                }
            } catch (IllegalAccessException | IllegalArgumentException e) {
                return false;
            }
        }
        return false;
    }

}
