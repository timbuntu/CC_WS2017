
#include "Leaf.h"


template <class Type>
Leaf<Type>::Leaf(std::string name, Token<Type> value) 
: Node(name)
{
 this->value(value);
}

template <class Type>
Token<Type> Leaf<Type>::getValue() const {
    return value;
}

template <class Type>
void Leaf<Type>::setValue(Token<Type> value) {
    this->value = value;
}

template <class Type>
void Leaf<Type>::print(int level) const {
    for(int i = 0; i < level; i++)
            std::cout << '\t';

    std::cout << value.getTokenType() << ' ' << value.getValue() << std::endl;
}

