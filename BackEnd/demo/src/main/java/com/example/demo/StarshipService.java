package com.example.demo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

@Service
public class StarshipService {

    private static final String FILE_PATH = "demo\\src\\main\\resources\\naves.json";
    private static final String REQUESTS_FILE = "demo\\src\\main\\resources\\peticiones.json";
    private static final Gson gson = new Gson();

    // Obtener todos los vehículos desde el JSON
    public List<Starship> getAllStarships() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<ArrayList<Starship>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public boolean generatePDFAndLogRequest(String shipName) {
        List<Starship> starships = getAllStarships();

        // Buscar la nave por nombre
        Optional<Starship> optionalStarship = starships.stream()
                .filter(s -> s.getName().equalsIgnoreCase(shipName))
                .findFirst();

        if (optionalStarship.isPresent()) {
            Starship starship = optionalStarship.get();

            // Generar el PDF
            try {
                pdfManager pdfManagerInstance = new pdfManager();
                pdfManagerInstance.generateStarshipPDF(starship);
                updateRequestLog(shipName);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * Actualiza el registro de peticiones en el archivo JSON.
     */
    private void updateRequestLog(String shipName) {
        Map<String, Integer> requestLog = new HashMap<>();

        try (FileReader reader = new FileReader(REQUESTS_FILE)) {
            Type type = new TypeToken<Map<String, Integer>>() {}.getType();
            requestLog = gson.fromJson(reader, type);
        } catch (Exception ignored) {
        }

        // Incrementar el contador de solicitudes
        requestLog.put(shipName, requestLog.getOrDefault(shipName, 0) + 1);

        // Guardar el registro actualizado
        try (FileWriter writer = new FileWriter(REQUESTS_FILE)) {
            gson.toJson(requestLog, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
