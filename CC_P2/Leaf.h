
#ifndef LEAF
#define LEAF

#include "Node.h"
#include "Token.hpp"

class Leaf : public Node {
	
        std::string value;

 public:

    Leaf(std::string name, std::string value);
    
    std::string getValue() const;
    void setValue(std::string value);
    void print(int level) const;
};

#endif
