package com.example.Magazine_Reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/magazines")
public class MagazineController {
    @Autowired
    private MagazineService magazineService;
    
    // Endpoint pour afficher un message de bienvenue
    @GetMapping("/")
    public String welcome() {
        return "Bienvenue dans l'application de gestion des magazines !";
    }
    
    // Endpoint pour obtenir tous les magazines
    @GetMapping("/all")
    public List<Magazine> getAllMagazines() {
        return magazineService.getAllMagazines();
    }

    // Endpoint pour obtenir les magazines disponibles
    @GetMapping
    public List<Magazine> getAvailableMagazines() {
        return magazineService.getAllAvailableMagazines();
    }

    /* 
    @GetMapping("/{id}")
    public Magazine getMagazineById(@PathVariable Long id) {
        return magazineService.getMagazineById(id).orElse(null);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<Magazine> getMagazineById(@PathVariable Long id) {
        return magazineService.getMagazineById(id)
            .map(magazine -> ResponseEntity.ok(magazine))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/reserve")
    public void reserveMagazines(@RequestBody List<Long> magazineIds) {
        magazineService.reserveMagazines(magazineIds);
    }
}


