package com.example.demo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class NavesService {

    private static final String FILE_PATH = "demo\\src\\main\\resources\\naves.json";
    private static final Gson gson = new Gson();

    // Guardar un vehículo en el JSON
    public void saveVehicle(Naves naves) {
        List<Naves> vehicles = getAllNaves();
        vehicles.add(naves);

        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(vehicles, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Obtener todos los vehículos desde el JSON
    public List<Naves> getAllNaves() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<ArrayList<Naves>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
