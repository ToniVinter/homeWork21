package com.fasttrack.homeWork21.model;

import java.util.List;
import java.util.Objects;

public class Country {
    private static int COUNT = 1;
    private final int id;
    private final String name;
    private final String capital;
    private final Long population;
    private final long area;
    private final String continent;
    private final List<String> neighbour;

    public Country(String name, String capital, long population, long area, String continent, List<String> neighbour) {
        this.id = COUNT++;
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.continent = continent;
        this.neighbour = neighbour;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public long getPopulation() {
        return population;
    }

    public long getArea() {
        return area;
    }

    public String getContinent() {
        return continent;
    }


    public List<String> getNeighbour() {
        return neighbour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return population == country.population &&
                area == country.area &&
                Objects.equals(name, country.name) &&
                Objects.equals(capital, country.capital) &&
                Objects.equals(continent, country.continent) &&
                Objects.equals(neighbour, country.neighbour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capital, population, area, continent, neighbour);
    }

    @Override
    public String
    toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                ", area=" + area +
                ", continent='" + continent + '\'' +
                ", neighbour=" + neighbour +
                '}';
    }
}
