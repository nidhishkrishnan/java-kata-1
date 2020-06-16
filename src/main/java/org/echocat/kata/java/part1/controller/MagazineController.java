package org.echocat.kata.java.part1.controller;

import lombok.RequiredArgsConstructor;
import org.echocat.kata.java.part1.domain.Magazine;
import org.echocat.kata.java.part1.service.MagazineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/magazines")
public class MagazineController {

    private final MagazineService magazineService;

    @GetMapping("/")
    public List<Magazine> books() {
        return magazineService.getMagazines();
    }
}
