package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.core.Packages;
import com.thoughtworks.parking_lot.repository.PackagesRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class PackagesServices {

    private static final String NO_AVAILABLE_FOR_THIS_STATUS = "No available status for this";

    @Autowired
    private PackagesRepository packagesRepository;

    public Packages createBooking(Packages packages) throws NotFoundException {
        packages.setBookingTime(new Timestamp(new Date().getTime()));
        return packagesRepository.save(packages);
    }

    public Iterable<Packages> getAllPackages(Integer page, Integer pageSize) {
        return packagesRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    public List<Packages> getPackagesByStatus(String status) throws NotFoundException {
        if (packagesRepository.findByStatus(status).size() == 0) {
            throw new NotFoundException(NO_AVAILABLE_FOR_THIS_STATUS);
        } else {
            return packagesRepository.findAll();
        }
    }
}
