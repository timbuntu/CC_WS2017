
#include "Node.h"

Node::Node() { 
    m_name = "uninitialized";
}

Node::Node(std::string name) {
	m_name = name;
}

void Node::addNode(Node node) {
	nodes.push_back(node);
}

std::vector<Node> Node::getNodes() const {
	return nodes;
}


std::string Node::getName() const {
	return m_name;
}

void Node::setName(std::string name) {
	m_name = name;
}

void Node::print(int level) const {
    for(int i = 0; i < level; i++)
            std::cout << '\t';

    std::cout << getName() << "-->" << std::endl;

    /* for(Node node : getNodes()){ */
    for (int i = 0; i < (int) getNodes().size(); i++){
        Node node = getNodes()[i];
        /* std::cout << node.getName(); */
        node.print(level+1);
        /* node.print(level+1); */
    }
    
}
