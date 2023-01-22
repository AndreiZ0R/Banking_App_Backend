package com.example.demo.service;

import com.example.demo.model.Moving;
import com.example.demo.repository.MovingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovingService {
    private final MovingRepository movingRepo;

    @Autowired
    public MovingService(MovingRepository movingRepo) {
        this.movingRepo = movingRepo;
    }

    public List<Moving> getAllMovings() {
        return movingRepo.getAllMovings();
    }

    public List<Moving> getMovingsByCardNr(Long nrcard) {
        return movingRepo.getMovingsByCardNr(nrcard);
    }

    public List<Moving> getMovingsByPurpose(String scop) {
        return movingRepo.getMovingsByPurpose(scop);
    }

    public List<Moving> getMovingsBetweenValues(double lower, double upper) {
        return movingRepo.getMovingsBetweenValues(lower, upper);
    }

    public void addMoving(Moving moving) {
        movingRepo.addMoving(
                moving.getNrcard(),
                moving.getData_ora(),
                moving.getValoare(),
                moving.getScop());
    }

    public void deleteMoving(Moving moving) {
        movingRepo.deleteMovingByCardNrValuePurpose(
                moving.getNrcard(),
                moving.getValoare(),
                moving.getScop());
    }


}
