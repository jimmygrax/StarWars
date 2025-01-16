package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class StarshipController {

    @Autowired
    private final StarshipService navesService;

    public StarshipController(StarshipService navesService) {
        this.navesService = navesService;
    }

    @GetMapping("/starship")
    public List<Starship> getAllStarships() {
        return navesService.getAllStarships();
    }

    @PostMapping("/starship/pdf")
    public ResponseEntity<String> generateStarshipPDF(@RequestBody Map<String, String> request) {
        String shipName = request.get("ship");
        if (shipName == null || shipName.isEmpty()) {
            return ResponseEntity.badRequest().body("El nombre de la nave es obligatorio.");
        }

        boolean result = navesService.generatePDFAndLogRequest(shipName);
        if (result) {
            return ResponseEntity.ok("PDF generado correctamente para la nave: " + shipName);
        } else {
            return ResponseEntity.badRequest().body("La nave '" + shipName + "' no fue encontrada.");
        }
    }
    

    

}
