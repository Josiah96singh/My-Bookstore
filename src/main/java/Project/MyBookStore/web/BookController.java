package Project.MyBookStore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Project.MyBookStore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository brepository;

	@RequestMapping(value = "/index", method=RequestMethod.GET)
	public String hello(Model model) {
		model.addAttribute("book", brepository.findAll());
		return "booklist";
	}
	
}
