package org.echocat.kata.java.part1.service;

import lombok.RequiredArgsConstructor;
import org.echocat.kata.java.part1.domain.Magazine;
import org.echocat.kata.java.part1.repository.MagazineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MagazineService {

    private final MagazineRepository magazineRepository;

    public List<Magazine> getMagazines() {
        return magazineRepository.getMagazines();
    }
}
