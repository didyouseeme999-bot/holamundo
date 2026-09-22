package com.springproject1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject1.Entity.Mensaje;

public interface MensajeRepository extends JpaRepository<Mensaje, Long> {

}
