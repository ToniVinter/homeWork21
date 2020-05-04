package com.fasttrack.homeWork21;

import com.fasttrack.homeWork21.model.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("countries")
public class CountryController {
    private final CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }
    @GetMapping
    public List<Country> getAllCountries(){
       return service.getCountries();
    }

    @GetMapping("/names")
    public List<String> getCountriesName(){
        return service.getCountriesName();
    }

    @GetMapping("/{id}/capital")
    public String getCapitalOfCountry(@PathVariable int id){
        return service.getCapitalOfCountry(id);
    }

    @GetMapping("/{id}/population")
    public long getPopulationOfCountry(@PathVariable int id){
        return service.getPopulationOfCountry(id);
    }

    @GetMapping("/continents/{continentName}/countries")
    public List<String> getCountriesInContinent(@PathVariable String continentName){
        return service.getCountriesInContient(continentName);
    }

    @GetMapping("/{id}/neighbours")
    public List<String> getCountriesNeighbours(@PathVariable int id){
        return service.getCountryNeighbours(id);
    }

    @GetMapping("population")
    public Map<String,Long> getMapFromCountryToPopulation(){
        return service.getCountryToPopulation();
    }

    @GetMapping("/contients/countries")
    public Map<String,List<String>> getMapFromContinentToCountries(){
        return service.getContinentToCountries();
    }

    @GetMapping("/continents/{contientName}/countries?minPopulation={minPopulation}")
    public List<Country> getCountriesWithPopulationLargerThan(@PathVariable String continentName, @PathVariable int minPopulation){
        return service.getCountriesByContinentPopulation(continentName,minPopulation);
    }

    @GetMapping("?includeNeighbour={incNeighbour}&excludedNeighbour={excNeighbour}")
    public List<Country> getCountriesNeighboursIncludedExcluded(@PathVariable String incNeighbour, @PathVariable String excNeighbour ){
        return service.getCountriesByNeighbours(incNeighbour,excNeighbour);
    }




}
