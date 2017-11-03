/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc_p1;

/**
 *
 * @author matti
 */
public class Tokens {
    // simplified str_literal
    final static String l_string = "[\"`][^\"']*[\"`]";
    final static String identifier = "[A-Za-z0-9][A-Za-z_0-9_]*";
    
    // keywords
    final static String k_import = "[Ii]mport";
    final static String k_package = "package";
    final static String k_left_bracket = "(";
    final static String k_right_bracket = ")";
    final static String k_semicolon = ";";
    final static String k_dot = ".";
}
