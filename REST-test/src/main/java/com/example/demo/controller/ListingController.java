package com.example.demo.controller;

import com.example.demo.dto.ListingDto;
import com.example.demo.service.ListingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/listing")
public class ListingController {
    private final ListingService listingService;

    public ListingController(ListingService listingService) {
        this.listingService = listingService;
    }

    @GetMapping
    public ResponseEntity<Iterable<ListingDto>> getListings() {
        try {
            return new ResponseEntity<>(listingService.getAllListings(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<ListingDto> createListing(@RequestParam(name="owner_id") Long ownerId,
                                                    @RequestParam(name="title") String title,
                                                    @RequestParam(name="description") String description,
                                                    @RequestParam(name="price") float price,
                                                    @RequestParam(name="media") byte[] media) {
        try {
            ListingDto listingDto = new ListingDto((long) -1, ownerId, title, description, price, media);
            return new ResponseEntity<>(listingService.createListing(listingDto), HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteListing(@PathVariable("id") Long id) {
        try {
            boolean result = listingService.deleteListing(id);
            if(!result) {
                return new ResponseEntity<>("Failed to find listing", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>("Successfully deleted listing", HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return new ResponseEntity<>("Failed to delete listing", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
