package com.fasttrack.homeWork21;

import com.fasttrack.homeWork21.model.Country;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;
@Service
public class CountryService {
    private final List<Country> countries;

    public CountryService() throws FileNotFoundException {
        this.countries = new CountryReader().readCountries("D:\\Java\\homeWork21\\homeWork21\\src\\main\\resources\\countries.txt");
    }
    public List<Country> getCountries(){
        return countries;
    }
    public List<String> getCountriesName() {
        return countries.stream()
                .map(Country::getName)
                .collect(Collectors.toList());
    }

    public String getCapitalOfCountry(int id) {
        return countries.stream()
                .filter(c -> c.getId() == id)
                .map(Country::getCapital)
                .findFirst()
                .get();
    }

    public long getPopulationOfCountry(int id){
        return countries.stream()
                .filter(s -> s.getId() == id)
                .map(Country::getPopulation)
                .findFirst()
                .get();

    }

    public List<String> getCountriesInContient(String continent){
        return countries.stream()
                .filter(s -> s.getContinent().equals(continent))
                .map(s -> s.getName())
                .collect(Collectors.toList());
    }

    public List<String> getCountryNeighbours(int id){
        return countries.stream()
                .filter(c -> c.getId() == id)
                .flatMap(c -> c.getNeighbour().stream())
                .collect(Collectors.toList());

    }

    public List<Country> getCountriesByContinentPopulation(String continent, long population){
        return countries.stream()
                .filter(c -> c.getContinent().equals(continent) && c.getPopulation() > population)
                .collect(Collectors.toList());
    }

    public List<Country> getCountriesByNeighbours(String neighbour1, String neighbour2){
        return countries.stream()
                .filter(c -> c.getNeighbour().contains(neighbour1))
                .filter(Predicate.not(c -> c.getNeighbour().contains(neighbour2)))
                .collect(Collectors.toList());
    }
    

    public Map<String,Long> getCountryToPopulation(){
        return countries.stream()
                .collect(toMap(
                        Country::getName,
                        Country::getPopulation
                ));
    }

    public Map<String, List<String>> getContinentToCountries() {
        return countries.stream()
                .sorted(Comparator.comparing(Country::getPopulation))
                .collect(toMap(
                        Country::getContinent,
                        c -> List.of(c.getName()),
                        (c1, c2) -> Stream.concat(c1.stream(), c2.stream())
                                .collect(Collectors.toList())
                ));
    }
}
