/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc_p1.TokenDefinition;

import java.lang.reflect.Field;

/**
 *
 * @author matti
 */
public class Keyword {

    // keywords
    public final static String k_package = "^package$";
    public final static String k_import = "^[Ii]mport$";
    public final static String k_var = "^var$";
    public final static String k_const = "^const$";

    public static boolean match(String value) {
        for (Field field : Keyword.class.getDeclaredFields()) {
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
