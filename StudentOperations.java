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

    // method to search student by PRN
    public Student searchByPRN(long prn) throws StudentNotFoundException
    {
        for (Student student : students)
        {
            // return student if PRNs match
            if (student.getPRN() == prn)
            {
                return student;
            }
        }
        // throw exception if PRN not found
        throw new StudentNotFoundException("Student with PRN " + prn + " not found.");
    }

    // method to search student by name
    public Student searchByName(String name) throws StudentNotFoundException
    {
        for (Student student : students)
        {
            // return student if names match
            if (student.getName().equalsIgnoreCase(name))
            {
                return student;
            }
        }
        // throw exception if name not found
        throw new StudentNotFoundException("Student with name " + name + " not found.");
    }

    // method to search student by position
    public Student searchByPosition(int pos)
            throws InvalidPositionException, EmptyStudentListException
    {
        // throw exception if list is empty
        if (students.isEmpty())
        {
            throw new EmptyStudentListException("Student list is empty.");
        }
        // throw exception if position is invalid
        if (pos < 0 || pos >= students.size())
        {
            throw new InvalidPositionException("Position " + pos + " is invalid.");
        }
        // return position at which student found
        return students.get(pos);
    }

    // method to update student details
    public void updateStudent(long prn, String name, String dept, String batch, double cgpa)
            throws StudentNotFoundException, InvalidCGPAException
    {
        // search student to be updated
        Student student = searchByPRN(prn);
        // throw exception if CGPA out of bounds
        if (cgpa < 0.0 || cgpa > 10.0)
        {
            throw new InvalidCGPAException("CGPA must be between 0 and 10.");
        }
        // update and print details
        student.setName(name);
        student.setDept(dept);
        student.setBatch(batch);
        student.setCGPA(cgpa);
        System.out.println("Student Updated Successfully!");
    }

