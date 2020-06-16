package org.echocat.kata.java.part1.repository;

import org.echocat.kata.java.part1.domain.Magazine;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.echocat.kata.java.part1.utils.DataProcessorUtil.readData;

@Repository
public class MagazineRepository {

    public List<Magazine> getMagazines() {
        return readData(Magazine.class, "magazines.csv");
    }
}
