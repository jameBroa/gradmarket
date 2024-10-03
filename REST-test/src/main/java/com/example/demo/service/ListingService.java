package com.example.demo.service;

import com.example.demo.dto.ListingDto;
import com.example.demo.model.Listing;
import com.example.demo.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class ListingService {

    private final ListingRepository listingRepository;

    @Autowired
    public ListingService(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }


    // Returns ALL listings
    public Iterable<ListingDto> getAllListings() {
        Iterable<Listing> allListings = listingRepository.findAll();
        ArrayList<ListingDto> ret = new ArrayList<>();
        for (Listing listing : allListings) {
            ret.add(convertListToListDto(listing));
        }
        return ret;
    }

    public ListingDto createListing(ListingDto listingDto) {
        Listing listing = new Listing(listingDto.getOwner_id(),
                listingDto.getTitle(),
                listingDto.getDescription(),
                listingDto.getPrice(),
                listingDto.getMedia());
        listingRepository.save(listing);
        return listingDto;
    }

    public boolean deleteListing(Long id) {
        try {
            listingRepository.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }


    private ListingDto convertListToListDto(Listing listing) {
        return new ListingDto(listing.getId(),
                listing.getOwner_id(), listing.getTitle(),
                listing.getDescription(), listing.getPrice(), listing.getMedia());
    }
}
