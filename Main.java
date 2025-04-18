import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		StudentOperations operations = new StudentOperations();

		try
		{
			// sample list of 5 students created
			operations.addStudent(new Student("Rohit Sharma", 23070126101L, "CSE", "A1", 9.1));
			operations.addStudent(new Student("Virat Kohli", 23070126102L, "ENTC", "B3", 8.5));
			operations.addStudent(new Student("Riddhim Kawdia", 23070126103L, "AIML", "B2", 7.8));
			operations.addStudent(new Student("David Warner", 23070126104L, "CIVIL", "A2", 8.2));
			operations.addStudent(new Student("Chris Gayle", 23070126105L, "CSE", "B1", 9.0));
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

		// menu for operations
		while (true)
		{
			System.out.println("\nSTUDENT MANAGEMENT SYSTEM");
			System.out.println("1. Add Student");
			System.out.println("2. Display All Students");
			System.out.println("3. Search Student by PRN");
			System.out.println("4. Search Student by Name");
			System.out.println("5. Search Student by Position");
			System.out.println("6. Update Student Details");
			System.out.println("7. Delete Student");
			System.out.println("8. Exit");

			// take user input for choice
			System.out.print("Enter your choice: ");
			int choice = scan.nextInt();
			scan.nextLine();

			try
			{
				// switch-case
				switch (choice)
				{
					case 1:
						System.out.print("Enter Name: ");
						String name = scan.nextLine();
						System.out.print("Enter PRN: ");
						long prn = scan.nextLong();
						scan.nextLine();
						System.out.print("Enter Department: ");
						String dept = scan.nextLine();
						System.out.print("Enter Batch: ");
						String batch = scan.nextLine();
						System.out.print("Enter CGPA: ");
						double cgpa = scan.nextDouble();
						scan.nextLine();
						operations.addStudent(new Student(name, prn, dept, batch, cgpa));
						break;
					case 2:
						operations.displayStudents();
						break;
					case 3:
						System.out.print("Enter PRN to search: ");
						Student s1 = operations.searchByPRN(scan.nextLong());
						s1.display();
						break;
					case 4:
						System.out.print("Enter Name to search: ");
						Student s2 = operations.searchByName(scan.nextLine());
						s2.display();
						break;
					case 5:
						System.out.print("Enter Position: ");
						Student s3 = operations.searchByPosition(scan.nextInt());
						s3.display();
						break;
					case 6:
						System.out.print("Enter PRN of student to update: ");
						long updated_PRN = scan.nextLong();
						scan.nextLine();
						System.out.print("Enter New Name: ");
						String updated_Name = scan.nextLine();
						System.out.print("Enter New Department: ");
						String updated_Dept = scan.nextLine();
						System.out.print("Enter New Batch: ");
						String updated_Batch = scan.nextLine();
						System.out.print("Enter New CGPA: ");
						double updated_CGPA = scan.nextDouble();
						scan.nextLine();
						operations.updateStudent(
								updated_PRN,
								updated_Name,
								updated_Dept,
								updated_Batch,
								updated_CGPA
						);
						System.out.println("Student updated successfully!");
						break;
					case 7:
						System.out.print("Enter PRN of student to delete: ");
						operations.deleteStudent(scan.nextLong());
						break;
					case 8:
						System.out.println("Exiting program...");
						scan.close();
						return;
					default:
						System.out.println("Invalid choice! Try again.");
				}
			}
			catch (Exception e)
			{
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
}