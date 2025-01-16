package org.vaadin.example;


import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

    private final StarshipService starshipService;
    private final Grid<Starship> grid;

    public MainView(StarshipService starshipService) {
        this.starshipService = starshipService;
        this.grid = new Grid<>(Starship.class, false);

        configureGrid();
        add(grid);
        loadData();
    }

    private void configureGrid() {
        grid.addColumn(Starship::getName).setHeader("Nombre");
        grid.addColumn(Starship::getModel).setHeader("Modelo");
        grid.addColumn(Starship::getStarshipClass).setHeader("Clase");
        grid.addColumn(Starship::getCrew).setHeader("Tripulación");

        grid.addComponentColumn(starship -> {
            Button generateButton = new Button("Generar PDF");
            generateButton.addClickListener(e -> {
                starshipService.generatePDF(starship.getName());
                generateButton.setText("Generado");
                generateButton.setEnabled(false);
            });
            return generateButton;
        }).setHeader("Acciones");
    }

    private void loadData() {
        grid.setItems(starshipService.getAllStarships());
    }
}
