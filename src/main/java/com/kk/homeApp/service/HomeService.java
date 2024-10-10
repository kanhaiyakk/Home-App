package com.kk.homeApp.service;

import com.kk.homeApp.entity.Home;

import java.util.List;

public interface HomeService {
    List<Home> getAllHomes();
    Home getHomeById(Long id);
    Home addHome(Home home);
    Home updateHomeDetails(Long id, Home home);
    void deleteHome(Long id);

}
