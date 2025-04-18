import java.util.*;

public class StudentOperations
{
    // new array-list to store students
    private ArrayList<Student> students = new ArrayList<>();

    // method to add a new student
    public void addStudent(Student student)
            throws DuplicatePRNException, InvalidCGPAException
    {
        // iterate through each student
        for (Student s : students)
        {
            // throw exception if PRNs are same
            if (s.getPRN() == student.getPRN())
            {
                throw new DuplicatePRNException("Student with PRN " + student.getPRN() + " already exists.");
            }
        }

        // throw exception if CGPA is invalid (out of bounds)
        if (student.getCGPA() < 0.0 || student.getCGPA() > 10.0)
        {
            throw new InvalidCGPAException("CGPA must be between 0 and 10.");
        }
        students.add(student);
        System.out.println("Student added successfully!");
    }

    // method to display students
    public void displayStudents() throws EmptyStudentListException
    {
        // throw exception if list is empty
        if (students.isEmpty())
        {
            throw new EmptyStudentListException("No students to display.");
        }

        // iterate and display each student's details
        for (Student student : students)
        {
            student.display();
        }
    }

