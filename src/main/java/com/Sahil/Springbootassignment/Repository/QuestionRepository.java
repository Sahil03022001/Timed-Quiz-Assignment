package com.Sahil.Springbootassignment.Repository;

import com.Sahil.Springbootassignment.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
