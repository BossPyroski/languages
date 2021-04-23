package com.BossPyroski.languages.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.BossPyroski.languages.Services.LanguageService;
import com.BossPyroski.languages.models.Language;


@Controller
public class LanguageController {
private final LanguageService langServ;
public LanguageController(LanguageService langServ) {
	this.langServ = langServ;
}
	@RequestMapping("/languages")
	public String home (Model model, @ModelAttribute("language") Language language) {
		
		
		this.langServ.allLangs();
		model.addAttribute("allLang", this.langServ.allLangs());
		
			return "index.jsp";
		}
	
	@PostMapping("/languages")
	public String createLang(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("allLang", this.langServ.allLangs());
			return "index.jsp";
		}else {
			this.langServ.createLang(language);
			return "redirect:/languages";
			
		}
	}
	@RequestMapping("/languages/edit/{id}")
	public String editLang(@PathVariable("id")Long id, Model model) {
		Language lang = this.langServ.getLang(id);
		model.addAttribute("language", lang);
		return "edit.jsp";
	}
	@PostMapping("/languages/{id}/update")
	public String updateLang(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			this.langServ.updateLang(language);
			return "redirect:/languages";
		}
	}
	@GetMapping(value="/languages/{id}/delete")
	public String destroy(@PathVariable("id") Long id) {
      this.langServ.deleteLang(id);
        return "redirect:/languages";
}
}

//@RequestMapping("/books/new")
//public String newBook(@ModelAttribute("book") Book book) {
//    return "/books/new.jsp";
//}
//@RequestMapping(value="/books", method=RequestMethod.POST)
//public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
//    if (result.hasErrors()) {
//        return "/books/new.jsp";
//    } else {
//        bookService.createBook(book);
//        return "redirect:/books";
//    }