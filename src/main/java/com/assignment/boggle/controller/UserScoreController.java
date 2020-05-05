package com.assignment.boggle.controller;

import com.assignment.boggle.cache.Cache;
import com.assignment.boggle.model.UserScoreDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/userScoreDetail")
public class UserScoreController {

    private final Cache cache;

    public UserScoreController(Cache cache) {
        this.cache = cache;
    }

    @PostMapping
    @CrossOrigin
    public ResponseEntity<UserScoreDetail> addUserScoreDetail(@RequestBody UserScoreDetail userScoreDetail) {
        cache.add(userScoreDetail.getUsername(), userScoreDetail.getScore());
        return ResponseEntity.ok(userScoreDetail);
    }

    @GetMapping
    public ResponseEntity<List<UserScoreDetail>> getUserScoreDetails() {
        final List<UserScoreDetail> userScoreDetailList = cache.getAll()
                .entrySet()
                .stream()
                .map(stringIntegerEntry -> new UserScoreDetail(stringIntegerEntry.getKey(), stringIntegerEntry.getValue()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(userScoreDetailList);
    }
}
