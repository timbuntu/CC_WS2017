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
public class Operator {

    public final static String l_left_bracket = "^\\($";
    public final static String l_right_bracket = "^\\)$";     //TODO: "^\\);*$"
    public final static String l_semicolon = "^;$";
    public final static String l_dot = "^\\.$";
    public final static String l_comma = "^,$";
    public final static String l_equal = "^=$";
    public final static String l_plus = "^\\+$";
    public final static String l_minus = "^\\-$";

    public static boolean match(String value) {
        for (Field field : Operator.class.getDeclaredFields()) {
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
