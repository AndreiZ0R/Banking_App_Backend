package com.example.demo.controller;

import com.example.demo.model.Moving;
import com.example.demo.service.MovingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movings")
public class MovingController {
    private final MovingService movingService;

    @Autowired
    public MovingController(MovingService movingService) {
        this.movingService = movingService;
    }

    @GetMapping
    List<Moving> getAllMovings() {
        return movingService.getAllMovings();
    }

    @GetMapping("/card_nr={nr}")
    List<Moving> getMovingsByCardNr(@PathVariable("nr") Long nr) {
        return movingService.getMovingsByCardNr(nr);
    }

    @GetMapping("/purpose={purpose}")
    List<Moving> getMovingsByPurpose(@PathVariable("purpose") String purpose) {
        return movingService.getMovingsByPurpose(purpose);
    }

    @GetMapping("/lower={lower}&upper={upper}")
    List<Moving> getMovingsBetweenValues(@PathVariable("lower") double lower, @PathVariable("upper") double upper) {
        return movingService.getMovingsBetweenValues(lower, upper);
    }

    @PostMapping(consumes = "application/json")
    void addMoving(@RequestBody Moving moving) {
        movingService.addMoving(moving);
    }

    @DeleteMapping(consumes = "application/json")
    void deleteMoving(@RequestBody Moving moving) {
        movingService.deleteMoving(moving);
    }
}
