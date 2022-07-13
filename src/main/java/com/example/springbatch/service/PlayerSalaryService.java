package com.example.springbatch.service;

import com.example.springbatch.dto.PlayerDto;
import com.example.springbatch.dto.PlayerSalaryDto;
import org.springframework.stereotype.Service;
import java.time.Year;

@Service
public class PlayerSalaryService {

    public PlayerSalaryDto calcSalary(PlayerDto player){
        int salary = (Year.now().getValue() - player.getBirthYear()) * 1000000;
        return PlayerSalaryDto.of(player, salary);
    }
}
