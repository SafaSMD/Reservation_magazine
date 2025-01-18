package com.example.Magazine_Reservation;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MagazineService {
    private List<Magazine> magazines = new ArrayList<>();

    public MagazineService() {
        // Initialisation avec quelques magazines
        magazines.add(new Magazine(1L, "Magazine A", "Description A", true));
        magazines.add(new Magazine(2L, "Magazine B", "Description B", true));
        magazines.add(new Magazine(3L, "Magazine C", "Description C", false));
    }

    // Méthode pour obtenir tous les magazines
    public List<Magazine> getAllMagazines() {
        return magazines;
    }

    public List<Magazine> getAllAvailableMagazines() {
        List<Magazine> availableMagazines = new ArrayList<>();
        for (Magazine magazine : magazines) {
            if (magazine.isAvailable()) {
                availableMagazines.add(magazine);
            }
        }
        return availableMagazines;
    }

    public Optional<Magazine> getMagazineById(Long id) {
        return magazines.stream().filter(m -> m.getId().equals(id)).findFirst();
    }

    public void reserveMagazines(List<Long> magazineIds) {
        for (Long id : magazineIds) {
            getMagazineById(id).ifPresent(m -> {
                m.setAvailable(false);
            });
        }
    }
}

