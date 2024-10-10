package com.kk.homeApp.controller;

import com.kk.homeApp.entity.Home;
import com.kk.homeApp.service.HomeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    HomeService homeService;

    @GetMapping("/homes")
    public ResponseEntity<List<Home>> getAllHomes(){
        return new ResponseEntity<>(homeService.getAllHomes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Home> getHomeById(@PathVariable Long id){
        return new ResponseEntity<>(homeService.getHomeById(id),HttpStatus.OK);
    }
    @PostMapping("/home")
    public ResponseEntity<Home> addHome(@Valid @RequestBody Home home){
        return new ResponseEntity<>(homeService.addHome(home), HttpStatus.CREATED);
    }
    @PutMapping("/home/{id}")
    public ResponseEntity<Home> updateHomeDetails(@PathVariable Long id, @RequestBody Home home) {
        // Call the service method to update the home
        Home updatedHome = homeService.updateHomeDetails(id, home);

        // Check if the updated home is null, which indicates it wasn't found
        if (updatedHome == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Return 404 Not Found if the home does not exist
        }

        // Return the updated home with 200 OK status
        return new ResponseEntity<>(updatedHome, HttpStatus.OK);
    }

    @DeleteMapping("/home/{id}")
    public ResponseEntity<Void> deleteHome(@PathVariable Long id) {
        // Call the service to delete the home
        homeService.deleteHome(id);

        // Return a 204 No Content response
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
