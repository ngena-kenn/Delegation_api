package fr.sacem.api.controller;

import fr.sacem.api.model.City;
import fr.sacem.api.service.CitiesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "cities")
@RestController
public class CitiesController {

    @Autowired
    private CitiesService citiesService;
    @ApiOperation(value = "liste des cities", tags = "cities")
    @GetMapping("/cities")
    public List<City> getCities(){
        List<City> cities = citiesService.getCities();

        return cities;

    }

    @ApiOperation(value = "telecharger la liste des cities au format json", tags = "cities")
    @GetMapping("/downloadCities")
    public ResponseEntity downloadFile(){
        List<City> cities = citiesService.getCities();

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=alimentation-inseeptt.json" )
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(cities);

        }





    }
