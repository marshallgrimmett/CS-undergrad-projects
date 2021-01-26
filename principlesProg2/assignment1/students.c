#include <stdio.h>
#include <string.h>

struct Student {
	char name[50];
	int age;
	float gpa;
	char year[10];
};

int main() {
	struct Student s1[3];

	strcpy(s1[0].name, "Bob");
	s1[0].age = 34;
	s1[0].gpa = 1.23f;
	strcpy(s1[0].year, "junior");

	strcpy(s1[1].name, "Sally");
	s1[1].age = 25;
	s1[1].gpa = 5.23f;
	strcpy(s1[1].year, "freshman");

	strcpy(s1[2].name, "Joe");
	s1[2].age = 77;;
	s1[2].gpa = 0.23f;
	strcpy(s1[2].year, "senior");

	printf("Name: %s\nAge: %d\nGPA: %1.2f\nYear: %s \n\n",
			s1[0].name, s1[0].age, s1[0].gpa, s1[0].year);

	printf("Name: %s\nAge: %d\nGPA: %1.2f\nYear: %s \n\n",
			s1[1].name, s1[1].age, s1[1].gpa, s1[1].year);

	printf("Name: %s\nAge: %d\nGPA: %1.2f\nYear: %s \n\n",	
			s1[2].name, s1[2].age, s1[2].gpa, s1[2].year);
			
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
