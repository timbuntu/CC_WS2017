
#ifndef LEAF
#define LEAF

#include "Node.h"
#include "Token.h"

template <class Type>
class Leaf : public Node {
	
	Token<Type> value;

 public:

    Leaf(std::string name, Token<Type> value);
    Token<Type> getValue() const;
    void setValue(Token<Type> value);
    void print(int level) const;

};

#endif
