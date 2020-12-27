package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Utente;

public interface UtentiRepository extends JpaRepository<Utente,String > {

}
