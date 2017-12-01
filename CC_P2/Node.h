
#ifndef NODE
#define NODE

#include <string>
#include <list>
#include <iostream>

class Node {
	
	std::string name;
	std::list<Node> nodes;

public:
	Node(std::string name);

	void addNode(Node node);
	std::list<Node> getNodes() const;

	std::string getName() const;
	void setName(std::string name);
    
    void print(int value) const;
};

#endif
