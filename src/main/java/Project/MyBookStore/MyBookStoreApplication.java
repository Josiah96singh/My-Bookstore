package Project.MyBookStore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Project.MyBookStore.domain.Book;
import Project.MyBookStore.domain.BookRepository;
import Project.MyBookStore.domain.Category;
import Project.MyBookStore.domain.CategoryRepository;

@SpringBootApplication
public class MyBookStoreApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MyBookStoreApplication.class, args);

	}

	@Bean
	public CommandLineRunner app(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			
			crepository.save(new Category("Drama"));
			crepository.save(new Category("Fiction"));
			crepository.save(new Category("Romance"));
			crepository.save(new Category("Biopic"));
			
			brepository.save(new Book("A good friend", "Sam",2010, "1145", 12.50, crepository.findByName("Drama").get(0)));
			brepository.save(new Book("Mad man", "John", 1990,"4145", 14.40, crepository.findByName("Fiction").get(0)));
		
		};

	}
}
