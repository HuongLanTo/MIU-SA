package customers;

import customers.domain.Address;
import customers.domain.CreditCard;
import customers.domain.Customer;
import customers.domain.Student;
import customers.repository.CustomerRepository;
import customers.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        // create customer
		Customer customer = new Customer(101,"John doe", "johnd@acme.com", "0622341678");
		CreditCard creditCard = new CreditCard("12324564321", "Visa", "11/23");
		customer.setCreditCard(creditCard);
		customerRepository.save(customer);
		customer = new Customer(109,"John Jones", "jones@acme.com", "0624321234");
		creditCard = new CreditCard("657483342", "Visa", "09/23");
		customer.setCreditCard(creditCard);
		customerRepository.save(customer);
		customer = new Customer(66,"James Johnson", "jj123@acme.com", "068633452");
		creditCard = new CreditCard("99876549876", "MasterCard", "01/24");
		customer.setCreditCard(creditCard);
		customerRepository.save(customer);
		//get customers
		System.out.println(customerRepository.findById(66).get());
		System.out.println(customerRepository.findById(101).get());
		System.out.println("-----------All customers ----------------");
		System.out.println(customerRepository.findAll());
		//update customer
		customer = customerRepository.findById(101).get();
		customer.setEmail("jd@gmail.com");
		customerRepository.save(customer);
		System.out.println("-----------find by phone ----------------");
		System.out.println(customerRepository.findByPhone("0622341678"));
		System.out.println("-----------find by email ----------------");
		System.out.println(customerRepository.findByEmail("jj123@acme.com"));
		System.out.println("-----------find customers with a certain type of creditcard ----------------");
		List<Customer> customers = customerRepository.findByCreditCardType("Visa");
		for (Customer cust : customers){
			System.out.println(cust);
		}

		System.out.println("-----------find by name ----------------");
		System.out.println(customerRepository.findByName("John doe"));

		// create student
		Address address1 = new Address("4th", "Fairfield", 52557);
		Address address2 = new Address("5th", "Chicago", 52557);
		Address address3 = new Address("6th", "New York", 52557);
		Address address4 = new Address("7th", "Seattle", 52557);
		Address address5 = new Address("8th", "Fairfield", 52557);

		Student student1 = new Student(1, "John", "+7859475932", "john@gmail.com", address1);
		studentRepository.save(student1);
		Student student2 = new Student(2, "Peter", "+7859475932", "peter@gmail.com", address2);
		studentRepository.save(student2);
		Student student3 = new Student(3, "Mary", "+9847837264", "mary@gmail.com", address3);
		studentRepository.save(student3);
		Student student4 = new Student(4, "Jenny", "+6392751546", "jenny@gmail.com", address4);
		studentRepository.save(student4);
		Student student5 = new Student(5, "Lisa", "+0927418462", "lisa@gmail.com", address5);
		studentRepository.save(student5);

		// get all students
		System.out.println("-----------All students ----------------");
		System.out.println(studentRepository.findAll());

		// get all students with a certain name
		System.out.println("-----------find by certain name ----------------");
		System.out.println(studentRepository.findByName("John"));

		// get a student with a certain phone number
		System.out.println("-----------find by certain phone number ----------------");
		System.out.println(studentRepository.findByPhoneNumber("+0927418462"));

		// get all students from a certain city
		System.out.println("-----------find by certain city ----------------");
		System.out.println(studentRepository.findByAddressCity("Fairfield"));

	}

}
