package br.com.santosandrey.sl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.santosandrey.sl.model.ShoppingListControlEntity;
import br.com.santosandrey.sl.model.ShoppingListEntity;

public interface ShoppingListControlRepository extends JpaRepository<ShoppingListControlEntity, Long> {

}
