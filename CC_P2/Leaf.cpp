
#include "Leaf.h"


Leaf::Leaf(std::string name, std::string value) : Node(name) {
 this->value = value;
}

std::string Leaf::getValue() const {
    return value;
}

void Leaf::setValue(std::string value) {
    this->value = value;
}

void Leaf::print(int level) const {
    for(int i = 0; i < level; i++)
            std::cout << '\t';

    std::cout << getName() << " " << value << std::endl;
}

