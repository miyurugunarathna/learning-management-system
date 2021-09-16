package com.lms.api.controller;

import com.lms.api.model.FreeCard;
import com.lms.api.service.FreeCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")

public class FreeCardController {

    @Autowired
    private final FreeCardService freeCardService;


    public FreeCardController(FreeCardService freeCardService) {
        this.freeCardService = freeCardService;
    }

    //API to get all free cards
    @GetMapping("/freeCards")
    public List<FreeCard> list() {
        return freeCardService.list();
    }
}
