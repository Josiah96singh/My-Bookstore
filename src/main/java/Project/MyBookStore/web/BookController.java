package Project.MyBookStore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Project.MyBookStore.domain.Book;
import Project.MyBookStore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository brepository;

	@RequestMapping(value = "/index")
	public String hello(Model model) {
		model.addAttribute("book", brepository.findAll());
		return "booklist";
	}
	
   @RequestMapping(value= "/addbook",  method = RequestMethod.GET)
   public String addbook(Model model) {
	   model.addAttribute("book", new Book());
	   return "addbook";
   }
   
   @RequestMapping(value = "/save", method = RequestMethod.POST)
   public String savebook(Book book) {
	   brepository.save(book);
	   return "redirect:index";
   }
   
   @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
   public String deleteBook(@PathVariable("id")Long bookId, Model model) {
	 brepository.delete(bookId);
	 return "redirect:../index";
   }
   
   @RequestMapping(value = "/edit/{id}")
   public String addbook(@PathVariable("id") Long bookId, Model model) {
	   model.addAttribute("book", brepository.findOne(bookId));
	   return "editbook";
   }
   
	
}
