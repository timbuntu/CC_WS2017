
#ifndef TOKEN
#define TOKEN

template <class Type>
class Token {
	
	int tokenType;
	Type value;
	
public:
	Token(int tokenType, Type value);
	
	int getTokenType();
	void setTokenType(int tokenType);
	Type getValue();
	void setValue(Type value);
	
};

#endif
