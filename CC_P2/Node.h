
#ifndef NODE
#define NODE

#include <string>
#include <vector>
#include <iostream>

class Node {
    
    std::string m_name;
    std::vector<Node> nodes;

public:
    Node();
    Node(std::string name);

    void addNode(Node node);
    void copyNodes(Node node);
    std::vector<Node> getNodes() const;

    std::string getName() const;
    void setName(std::string name);
    
    void print(int value) const;
};

#endif
