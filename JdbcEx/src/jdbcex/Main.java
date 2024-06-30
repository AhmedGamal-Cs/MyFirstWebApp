
package jdbcex;

import com.epsilon.entity.Employee;
import java.util.Scanner;
import com.epsilon.dao.EmployeeImp;
import java.util.*;
public class Main {
    public static void menu()
    {
        // Printing statements displaying menu on console
        System.out.println("MENU");
        System.out.println("1: Add Employee");
        System.out.println("2: Delete Employee");
        System.out.println("3: Update Employee");
        System.out.println("4: Search Employee");
        System.out.println("5: Display Employees");
        System.out.println("9: Exit program");
        System.out.print("Enter your selection : ");
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        EmployeeImp cud = new EmployeeImp();
        int option = 0;
        do{
            menu();
            option = input.nextInt();
            EmployeeImp crud = new EmployeeImp();
            switch(option){
                case 1:
                    System.out.println("Enter ID:");
                    int ID = input.nextInt();
                    input.nextLine(); // Consume newline

                    System.out.println("Enter name:");
                    String name = input.nextLine();

                    System.out.println("Enter Birthdate:");
                    String Birthdate = input.nextLine();

                    System.out.println("Enter Salary:");
                    int salary = input.nextInt();

                    System.out.println("Enter Age:");
                    int age = input.nextInt();

                    Employee t = new Employee(ID, name, Birthdate, salary, age);
                    crud.insert(t);
                    break;

                case 2:
                    System.out.println("Enter ID:");
                    ID = input.nextInt();
                    crud.delete(ID);
                    break;

                case 3:
                    System.out.println("Enter ID:");
                    ID = input.nextInt();
                    input.nextLine(); // Consume newline

                    System.out.println("Enter name:");
                    name = input.nextLine();

                    System.out.println("Enter Birthdate:");
                    Birthdate = input.nextLine();

                    System.out.println("Enter Salary:");
                    salary = input.nextInt();

                    System.out.println("Enter Age:");
                    age = input.nextInt();

                    Employee tt = new Employee(ID, name, Birthdate, salary, age);
                    crud.update(tt);
                    break;

                case 4:
                    System.out.println("Enter ID:");
                    int id = input.nextInt();
                    Employee emp = crud.get(id);
                    System.out.println(emp.toString());
                    break;

                case 5:
                    List<Employee> le = crud.getAll();
                    for (Employee empl : le) {
                        System.out.println(empl.toString());
                    }
                    break;

                case 9:
                    System.out.println("\nThank you for using the program. Goodbye!\n");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nInvalid input\n");
                    break;      
            }
        }while(option != 9);
    }
}
