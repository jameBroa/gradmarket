package com.example.demo.repository;

import com.example.demo.model.Listing;
import org.springframework.data.repository.CrudRepository;

public interface ListingRepository extends CrudRepository<Listing, Long> {
}
