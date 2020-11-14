package com.hoondragonite.aboutme.config.auth.service;

import com.hoondragonite.aboutme.config.auth.dto.CareerinfoDto;
import com.hoondragonite.aboutme.repository.CareerinfoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CareerinfoService {
    private CareerinfoRepository careerinfoRepository;

    public CareerinfoService(CareerinfoRepository careerinfoRepository){
        this.careerinfoRepository = careerinfoRepository;
    }

    @Transactional
    public String saveCareer(CareerinfoDto CareerinfoDto){
        return careerinfoRepository.save(CareerinfoDto.toEntity()).getName();
    }



}
