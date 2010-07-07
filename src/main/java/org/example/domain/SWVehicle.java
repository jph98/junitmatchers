package org.example.domain;

import java.util.List;

public class SWVehicle {

    private String name;
    private List<SWFigure> figures;
       
    public SWVehicle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public List<SWFigure> getFigures() {
        return figures;
    }

    public void setFigures(List<SWFigure> figures) {
        this.figures = figures;
    }
    
    public SWFigure getFigureByName(String name) {
        for (SWFigure fig: figures) {
            if (fig.getName().equals(name)) {
                return fig;
            }
        }
        return null;
    }


}
