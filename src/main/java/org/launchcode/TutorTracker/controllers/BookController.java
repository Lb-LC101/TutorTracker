package org.launchcode.TutorTracker.controllers;

import org.launchcode.TutorTracker.data.BookRepository;
import org.launchcode.TutorTracker.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("books")
public class BookController {

        @Autowired
        private BookRepository bookRepository;

        @GetMapping
        public String displayAllBooks(Model model) {
            model.addAttribute("title", "All Books");
            model.addAttribute("books", bookRepository.findAll());
            // book/index is the file path in the project structure
            return "book/index";
        }

        // create is the URL path books/create
        @GetMapping("create")
        public String displayCreateBookForm(Model model) {
            model.addAttribute("title", "Create Book Profile");
            model.addAttribute(new Book());
            // book/create is the file path in the project structure
            return "book/create";
        }

        @PostMapping("create")
        public String processCreateBookForm(@Valid @ModelAttribute Book book,
                                               Errors errors, Model model) {

            if (errors.hasErrors()) {
                model.addAttribute("title", "Create Book Profile");
                model.addAttribute(new Book());
                // book/create is the file path in the project structure
                return "book/create";
            }

            bookRepository.save(book);
            // redirect: is the URL path from RequestMapping (The main mapping from the controller)
            return "redirect:/books";
        }


        //update book profile
        @GetMapping("edit/{bookId}")
        public String displayEditBookForm(@PathVariable int bookId, Model model) {
            Optional<Book> result = bookRepository.findById(bookId);
            if (result.isEmpty()) {
                model.addAttribute("title", "Invalid Book ID: " + bookId);
            } else {
                Book book = result.get();
                model.addAttribute("title", "Edit Book Name" + book.getBookName());
                model.addAttribute("title", "Edit Book Description" + book.getBookDescription());
                model.addAttribute("title", "Edit Book Name" + book.getLessonName());
                model.addAttribute("title", "Edit Book Description" + book.getLessonDescription());
                model.addAttribute("title", "Edit Book Name" + book.getProcedureName());
                model.addAttribute("title", "Edit Book Description" + book.getProcedureDescription());
                model.addAttribute("book", book);
            }
            return "book/edit";
        }

        @PostMapping("edit")
        public String processEditStudentForm(int bookId, String bookName, String bookDescription, String lessonName, String lessonDescription, String procedureName, String procedureDescription) {
            Book book = bookRepository.findById(bookId).get();
            book.setBookName(bookName);
            book.setBookDescription(bookDescription);
            book.setLessonName(lessonName);
            book.setLessonDescription(lessonDescription);
            book.setProcedureName(procedureName);
            book.setProcedureDescription(procedureDescription);
            bookRepository.save(book);
            return "redirect:/books";
        }

}
