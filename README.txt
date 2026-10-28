======================================================================
PROJECT REPORT: LIBRARY MANAGEMENT SYSTEM
JAVA TRAINING - AIMT
======================================================================

1. PROJECT DETAILS
------------------
Project Title : Project Assessment Library Management System - JAVA Training, AIMT
Name          : Mohd Asif
Course/Branch : B.Tech
Total Marks   : 20

2. PROJECT OBJECTIVE
--------------------
To develop a beginner-friendly, console-driven Library Management System 
in Java that manages a fixed set of books using basic Object-Oriented 
Programming (OOP) principles and core Java features without using a GUI 
or external database.

3. PROBLEM STATEMENT
---------------------
An institute library requires a simple and reliable console system to 
track books, verify their availability, handle borrowing and returning 
transactions, and provide basic library summaries for staff members.

4. OOP CONCEPTS USED
--------------------
- Classes and Objects: Created 'Book', 'Library', and 'Main' classes 
  to model real-world library components and transactions.
- Encapsulation: Book attributes (id, title, author, isAvailable) are 
  kept private and accessed/modified safely using getters, setters, and 
  dedicated class methods.
- Methods: Modular functions created for displaying, searching, 
  borrowing, returning, and summarizing library records.
- Constructors: Used parameterized constructors to initialize Book objects 
  with initial details and default availability.

5. ARRAYS AND STRINGS EXPLANATION
---------------------------------
- Arrays: A fixed-size array 'Book[]' is utilized inside the Library 
  class to store and iterate over the collection of book objects.
- Strings: Used to store textual information like book titles, authors, 
  and user search queries. String methods such as .toLowerCase() and 
  .contains() are implemented for case-insensitive search matching.

6. MENU OPTIONS
---------------
1. Display all books      - Displays ID, title, author, and status of every book.
2. Search book by title   - Searches for books matching full or partial title strings.
3. Borrow a book          - Updates availability to 'Borrowed' using the Book ID.
4. Return a book          - Restores status to 'Available' using the Book ID.
5. Show library summary   - Outputs counts of total, available, and borrowed books.
0. Exit                   - Safely terminates the program loop.

7. SAMPLE INPUT / OUTPUT
------------------------
Sample Interaction:
-------------------
Menu Choice: 1
--- Library Books ---
ID: 101  | Title: Java Basics                   | Author: Herbert Schildt      | Status: Available
ID: 102  | Title: Object-Oriented Programming   | Author: E. Balagurusamy      | Status: Available
ID: 103  | Title: Data Structures               | Author: Seymour Lipschutz    | Status: Available

Menu Choice: 3
Enter Book ID to borrow: 101
Success: You have borrowed "Java Basics".

Menu Choice: 5
--- Library Summary ---
Total Books     : 5
Available Books : 4
Borrowed Books  : 1

8. CHALLENGES FACED
-------------------
- Preventing Scanner newline skipping issues when alternating between 
  nextInt() and nextLine().
- Validating non-integer input to prevent crashes (InputMismatchException) 
  when users enter invalid menu choices or IDs.
- Ensuring case-insensitive matching for title queries so users can search 
  regardless of capitalization.

9. CONCLUSION
-------------
The project successfully implements a modular, clean, and robust console-based 
Library Management System. It fulfills all functional requirements including 
data display, search, checkout, check-in, and summary reporting while 
strictly adhering to core OOP principles.
======================================================================