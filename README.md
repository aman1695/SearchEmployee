Coding Challenge
This coding challenge is for entry-level programmers. It requires no previous work experience. But, it requires the programmer to be well versed with at least one programming language. You can use any language you are comfortable with - C, C++, Swift, Java, Python, …
Requirements
You will implement a program that allows the user to search for employees based on id, names and skills.  The program should work in the following manner:
* Upon starting the program, it reads the employee records from a file named employees.csv.  
* The file contains employee data in a CSV file (comma separated values) format, such as the example below:
e101, John Doe, Mobile app development, iOS, Swift
e102, Jane Lee, Mobile app development, Android, Java
…
where,
                Each line in the file represents an employee.
                First field (e101, e102, …) in a line is an employee number
                Second field (John Doe, Jane Lee) is a employee name
                Rest are skills. There can be one or more skills for each employee. There
                is no upper limit for number of skills per employee.
* The program parses the employee records, and stores it in an in-memory data structure such as a linked list.
* Upon loading the records, it prompts the user for a search string.
* User enters a search string.  The search string could be anything, an employee-id, a name or one or more skills.
* Program returns the employees matching the specified search string.
Additional constraints
* Each employee may have more than one skill and there is no maximum for number of skills (you can’t use fixed length arrays)
* Search query can have multiple parameters such as “Java, Android” and employees with matching results should be returned.
* User can search employees with full name (John Doe), first name (John) or last name (Doe)
* This is a data structure challenge, not a database challenge. Do not use any database.
