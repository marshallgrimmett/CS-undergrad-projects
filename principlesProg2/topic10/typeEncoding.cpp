#include <iostream>
#include <typeinfo>

using namespace std;

int something (void) {return 0;}

int main()
{
	cout << typeid(something).name() << endl;
	return 0;
}
