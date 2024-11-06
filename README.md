# SchoolManagemntSystem
School Management System (Hibernate with MySQL)
Description:
The School Management System is a Java-based application designed to automate and streamline the administrative operations of a school. It helps manage student records, teacher profiles, attendance tracking, course enrollment, results, and other essential academic tasks. The system uses Hibernate ORM to interact with a MySQL database and simplifies database operations by using Java objects.

This application covers all aspects of school management, from enrolling students to tracking attendance, recording exam results, and managing parent information. It is built using Java, Hibernate (for ORM), and MySQL (for the relational database).

Key Features:
Student Management: Add, edit, and manage student records, including personal information, class enrollment, and associated parents.
Teacher Management: Manage teacher profiles, assign subjects, and track teaching schedules.
Attendance Tracking: Record and manage student attendance for each class.
Subject Management: Add and manage subjects offered by the school.
Exam Management: Record details about exams, including exam dates, results, and subjects.
Parent Management: Manage parent details and associate them with their children (students).
Class Management: Define and manage different classes (e.g., Grade 1, Grade 2, etc.) and assign students and teachers to them.
Result Management: Store and manage exam results for each student in various subjects.
Reports: Generate reports on attendance, student performance (grades/results), and class activities.
Technologies Used:
Java: Core language for backend logic and handling business operations.
Hibernate ORM: For mapping Java objects to database tables and simplifying database operations.
MySQL: Relational database used to store all data related to students, teachers, attendance, exams, etc.
JDBC: For connecting Java with MySQL to perform CRUD operations.
Maven: For managing project dependencies and building the project.
Entities:
The system includes the following key entities, each mapped to a database table:

Student: Contains student information like name, roll number, date of birth, class, and associated parent.
Teacher: Stores teacher details, including name, subject taught, and assigned classes.
Attendance: Tracks attendance records for students, noting their presence or absence for each class session.
Subject: Represents subjects taught at the school (e.g., Mathematics, Science, English).
Exam: Contains details of exams, including subject, date, and related student results.
Parent: Holds parent information, such as contact details and associated children (students).
Class: Defines the different classes/grades in the school (e.g., Grade 1, Grade 2) and associates students and teachers to these classes.
Result: Records student results for exams, including grades and status.
Database Structure (MySQL):
Students: Stores student details, including their name, class, and associated parent.
Teachers: Contains teacher details and their assignments to subjects and classes.
Attendance: Tracks attendance for each student for every class, including date and status (present/absent).
Subjects: Stores the subjects offered by the school (e.g., Math, History, etc.).
Exams: Contains exam details, including subject, date, and related students' results.
Parents: Stores parent details and the students they are associated with.
Classes: Represents classes/grades and their relationships with students and teachers.
Results: Records the scores or grades of students for specific exams.
Example Database Tables:
Student Table:

student_id (PK)
first_name
last_name
dob
class_id (FK)
parent_id (FK)
Teacher Table:

teacher_id (PK)
first_name
last_name
subject_id (FK)
Attendance Table:

attendance_id (PK)
student_id (FK)
class_id (FK)
date
status (e.g., "Present", "Absent")
Subject Table:

subject_id (PK)
name
teacher_id (FK)
Exam Table:

exam_id (PK)
subject_id (FK)
exam_date
Parent Table:

parent_id (PK)
first_name
last_name
contact_info
Class Table:

class_id (PK)
class_name
Result Table:

result_id (PK)
exam_id (FK)
student_id (FK)
grade
