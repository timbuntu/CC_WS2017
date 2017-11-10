/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc_p1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tim
 */

public class Node {

    private String name;
    private List<Node> nodes;

    public Node(String name) {
        this.name = name;
        nodes = new ArrayList<>();
    }

    public boolean addNode(Node n) {
        return getNodes().add(n);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the nodes
     */
    public List<Node> getNodes() {
        return nodes;
    }

    public void print(int level) {
        
        for(int i = 0; i < level; i++)
            System.out.print("\t");
            
        System.out.println(this.getName() + " -->");
        for(Node n : getNodes())
            n.print(level+1);
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param nodes the nodes to set
     */
    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }
}

