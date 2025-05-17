package com.example.demo.repository;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entities.Phone;

@Repository
public interface PhoneRepository extends CrudRepository<Phone, UUID> {}
