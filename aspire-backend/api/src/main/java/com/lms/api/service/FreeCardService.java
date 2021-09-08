package com.lms.api.service;

import com.lms.api.model.FreeCard;
import com.lms.api.repository.FreeCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreeCardService {

    private final FreeCardRepository FRepo;


    public FreeCardService(FreeCardRepository FRepo) {
        this.FRepo = FRepo;
    }

    public FreeCard save(FreeCard freeCard) {
        return FRepo.save(freeCard);
    }

    public List<FreeCard> list() {
        return FRepo.findAll();
    }
}
