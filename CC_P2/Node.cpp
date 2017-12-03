
#include "Node.h"

Node::Node() { }

Node::Node(std::string name) {
	this->name = name;
}

void Node::addNode(Node node) {
	nodes.push_back(node);
}

std::list<Node> Node::getNodes() const {
	return nodes;
}


std::string Node::getName() const {
	return name;
}

void Node::setName(std::string name) {
	this->name = name;
}

void Node::print(int level) const {
    for(int i = 0; i < level; i++)
            std::cout << '\t';

    std::cout << this->name << "-->" << std::endl;
    std::cout << "Count of Nodes in this node: " << this->getNodes().size() <<std::endl;

    for(Node node : nodes){
        node.print(level+1);
    }
    
}
