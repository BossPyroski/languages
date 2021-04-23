package com.BossPyroski.languages.Services;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.BossPyroski.languages.models.Language;
import com.BossPyroski.languages.repositories.LanguageRepository;

@Service

public class LanguageService {

	private final LanguageRepository langRepository;
	public LanguageService(LanguageRepository langRepository) {
		this.langRepository = langRepository;
	}
	public List<Language> allLangs(){
		return this.langRepository.findAll();
	}
	
	
	public Language createLang(Language l) {
		return this.langRepository.save(l);
	}
	public Language getLang(Long id) {
		return this.langRepository.findById(id).orElse(null);
		
	}
	public Language updateLang(Long id, String name, String creator, Float version) {
		Language toUpdate = this.langRepository.findById(id).orElse(null);
		if(toUpdate == null) {
			
			return null;
		}
	 else {
		toUpdate.setName(name);
		toUpdate.setCreator(creator);
		toUpdate.setVersion(version);

		return this.langRepository.save(toUpdate);
	 	}
	}
	public Language updateLang(Language lang) {
		return this.langRepository.save(lang);
	}
	public void deleteLang(Long id) {
		langRepository.deleteById(id);
		
	}
}
	    
