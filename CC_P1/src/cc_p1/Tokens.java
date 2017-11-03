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
    final String l_string = "[\"`][^\"']*[\"`]";
    
    // keywords
    final String k_import = "[Ii]mport";
    final String k_left_bracket = "(";
    final String k_right_bracket = ")";
    final String k_semicolon = ";";
    final String k_dot = ".";
}
