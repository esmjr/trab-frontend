package br.com.frontend.projeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.frontend.projeto.models.Suggestion;

@Repository
public interface SuggestionRepository extends JpaRepository <Suggestion, Integer> {

	Optional<Suggestion> findById(Integer id);
}
