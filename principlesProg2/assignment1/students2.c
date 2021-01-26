#include <stdio.h>
#include <string.h>

int main() {
	char name[3][50];
	int age[3];
	float gpa[3];
	char year[3][10];

	strcpy(name[0], "Bob");
	age[0] = 34;
	gpa[0] = 1.23f;
	strcpy(year[0], "junior");

	strcpy(name[1], "Sally");
	age[1] = 25;
	gpa[1] = 5.23f;
	strcpy(year[1], "freshman");

	strcpy(name[2], "Joe");
	age[2] = 77;;
	gpa[2] = 0.23f;
	strcpy(year[2], "senior");

	printf("Name: %s\nAge: %d\nGPA: %1.2f\nYear: %s \n\n",
			name[0], age[0], gpa[0], year[0]);

	printf("Name: %s\nAge: %d\nGPA: %1.2f\nYear: %s \n\n",
			name[1], age[1], gpa[1], year[1]);

	printf("Name: %s\nAge: %d\nGPA: %1.2f\nYear: %s \n\n",	
			name[2], age[2], gpa[2], year[2]);
		
	return 0;
}

/* Output
Name: Bob
Age: 34
GPA: 1.23
Year: junior 

Name: Sally
Age: 25
GPA: 5.23
Year: freshman 

Name: Joe
Age: 77
GPA: 0.23
Year: senior 
*/
