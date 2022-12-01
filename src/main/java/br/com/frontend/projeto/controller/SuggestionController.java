package br.com.frontend.projeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.frontend.projeto.models.Suggestion;
import br.com.frontend.projeto.repository.SuggestionRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Sugestoes")
@CrossOrigin(origins="*")
public class SuggestionController {
		
	@Autowired
	SuggestionRepository suggestionRepository;
	
	@GetMapping("/suggestions")
	@ApiOperation(value="Retorna a lista de sugestoes")
	public List<Suggestion> listSuggestions() {
		return suggestionRepository.findAll();
	}
	
	@GetMapping("/suggestion/{id}")
	@ApiOperation(value="Retorna a lista de sugestoes por id")
	public Optional<Suggestion> listOneSuggestion(@PathVariable(value="id") Integer id) {
		return suggestionRepository.findById(id);
	}
		
	@PostMapping("/suggestion")
	@ApiOperation(value="Salva uma sugestao")
	public Suggestion saveSuggestion(@RequestBody Suggestion suggestion) {
		return suggestionRepository.save(suggestion);
	}
		
	@DeleteMapping("/suggestion")
	@ApiOperation(value="Deleta uma sugestao")
	public void deleteSuggestion(@RequestBody Suggestion suggestion) {
		suggestionRepository.delete(suggestion);
	}
	
	@PutMapping("/suggestion")
	@ApiOperation(value="Atualiza uma sugestao")
	public Suggestion updateSuggestion(@RequestBody Suggestion suggestion) {
		return suggestionRepository.save(suggestion);	
	}
}
