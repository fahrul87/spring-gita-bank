package com.fahrul.bank.gita.repository;

import com.fahrul.bank.gita.entity.Appointment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AppointmentDao extends CrudRepository<Appointment, Long> {

    List<Appointment> findAll();
}