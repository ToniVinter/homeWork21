package com.fasttrack.homeWork21;

import com.fasttrack.homeWork21.model.Country;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<Country> countryList = new CountryReader().readCountries("D:\\Java\\homeWork21\\homeWork21\\src\\main\\resources\\countries.txt");
        System.out.println(countryList.get(1));
    }
}
