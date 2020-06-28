package com.example.pizza.repositories;

import com.example.pizza.model.Size;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SizeRepository extends CrudRepository<Size, Long> {
        Optional<Size> getSizeByNr(String name);
}
