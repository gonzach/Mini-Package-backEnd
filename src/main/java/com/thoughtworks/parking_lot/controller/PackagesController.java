package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.core.Packages;
import com.thoughtworks.parking_lot.service.PackagesServices;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/booking")
public class PackagesController {

    @Autowired
    PackagesServices packageServices;

    @PostMapping(produces={"application/json"})
    public Packages createBooking(@RequestBody Packages packages) throws NotFoundException {
        return packageServices.createBooking(packages);
    }

    @GetMapping(value = "/all", produces={"application/json"})
    public Iterable<Packages> getAllPackages(@RequestParam(defaultValue = "1") Integer page,
                                             @RequestParam(defaultValue = "15") Integer pageSize) throws NotFoundException {
        return packageServices.getAllPackages(page, pageSize);
    }

    @GetMapping(produces={"application/json"})
    public Iterable<Packages> getPackagesByStatus(@RequestParam(required = false) String status) throws NotFoundException {
        return packageServices.getPackagesByStatus(status);
    }

    @PatchMapping(value = "/{status}", produces = {"application/json"})
    public Orders updateOrderStatus(@PathVariable String name, @PathVariable String plateNumber) throws NotFoundException {
        return orderServices.updateOrderStatus(name, plateNumber);
    }

}
