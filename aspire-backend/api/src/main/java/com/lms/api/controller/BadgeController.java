package com.lms.api.controller;

import com.lms.api.model.Badge;
import com.lms.api.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")



public class BadgeController {


    @Autowired
    private final BadgeService badgeService;

    public BadgeController(BadgeService badgeService) {
        this.badgeService = badgeService;
    }


    // API to get badge by ID
    @GetMapping("/badge/{id}")
    public ResponseEntity<Badge> get(@PathVariable String id) {
        return badgeService.get(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound()
                        .build());
    }

    // API to get all badges
    @GetMapping("/badges")
    public List<Badge> list() {
        return badgeService.list();
    }

     //API to create a badge
    @PostMapping("/addbadge")
    public String saveBadge(@RequestBody Badge badge) {
        badgeService.save(badge);
        return "Badge added successfully";
    }


    // API to delete a badge
    @DeleteMapping("badge/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable String id) {

        return badgeService.delete(id);

    }

    // API to update a badge
    @PutMapping("badge/update/{id}")
    public String updateBadge(@RequestBody Badge badge, @PathVariable String id){
        badge.setBadgeID(id);
        badgeService.save(badge);
        return "Badge updated successfully";
}

}











