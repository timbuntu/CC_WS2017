
#ifndef TOKEN
#define TOKEN


template <class Type>
class Token {
    
    int tokenType;
    Type value;
    
public:
    Token();
    Token(int tokenType, Type value);
    
    int getTokenType();
    void setTokenType(int tokenType);
    Type getValue();
    void setValue(Type value);
    
};

template <class Type>
Token<Type>::Token() {
}

template <class Type>
Token<Type>::Token(int tokenType, Type value) {
	this->tokenType = tokenType;
	this->value = value;
}

template <class Type>
int Token<Type>::getTokenType() {
	return tokenType;
}

template <class Type>
void Token<Type>::setTokenType(int tokenType) {
	this->tokenType = tokenType;
}

template <class Type>
Type Token<Type>::getValue() {
	return value;
}

template <class Type>
void Token<Type>::setValue(Type value) {
	this->value = value;
}

#endif
