package com.kk.homeApp.serviceImpl;

import com.kk.homeApp.entity.Home;
import com.kk.homeApp.exception.ResourceNotFoundException;
import com.kk.homeApp.repository.HomeRepository;
import com.kk.homeApp.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    HomeRepository homeRepository;


    @Override
    public List<Home> getAllHomes() {
        return homeRepository.findAll()    ;
    }

    @Override
    public Home getHomeById(Long id) {
        Optional<Home> home = homeRepository.findById(id);
        if (home.isPresent()){
            return home.get();
        }
        throw new ResourceNotFoundException("Home record not found with the provided ID.");
    }

    @Override
    public Home addHome(Home home) {
        return homeRepository.save(home);
    }

    @Override
    public Home updateHomeDetails(Long id, Home home) {
        Home existingHome = getHomeById(id);

        // Update String field (city) only if the new value is not null
        existingHome.setCity(home.getCity() != null ? home.getCity() : existingHome.getCity());

        // Update float field (area) only if the new value is not 0.0f
        existingHome.setArea(home.getArea() != 0.0f ? home.getArea() : existingHome.getArea());

        // Update float field (price) only if the new value is not 0.0f
        existingHome.setPrice(home.getPrice() != 0.0f ? home.getPrice() : existingHome.getPrice());

        // Save the updated home details
        return homeRepository.save(existingHome);
    }

    @Override
    public void deleteHome(Long id) {
        homeRepository.deleteById(id);
    }

}
