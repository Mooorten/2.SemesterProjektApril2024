package net.codejava;

import org.springframework.stereotype.Service;
import semesterprojekt.model.Cat;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatService {

    // Statisk liste over katte (erstat med databaseintegration efter behov)
    private static List<Cat> catList = new ArrayList<>();

    // Metode til at returnere alle katte
    public List<Cat> getAllCats() {
        return catList;
    }
}
