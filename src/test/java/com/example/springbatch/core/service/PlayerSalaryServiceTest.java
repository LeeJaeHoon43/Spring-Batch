package com.example.springbatch.core.service;

import com.example.springbatch.dto.PlayerDto;
import com.example.springbatch.dto.PlayerSalaryDto;
import com.example.springbatch.service.PlayerSalaryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.Year;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerSalaryServiceTest {

    private PlayerSalaryService playerSalaryService;

    @BeforeEach
    public void setUp(){
        playerSalaryService = new PlayerSalaryService();
    }

    @Test
    public void calaSalary(){
        // given
        Year mockYear = mock(Year.class);
        when(mockYear.getValue()).thenReturn(2022);
        Mockito.mockStatic(Year.class).when(Year::now).thenReturn(mockYear);

        PlayerDto mockPlayer = mock(PlayerDto.class);
        when(mockPlayer.getBirthYear()).thenReturn(1980);

        // when
        PlayerSalaryDto result = playerSalaryService.calcSalary(mockPlayer);

        // then
        Assertions.assertEquals(result.getSalary(), 40000000);
    }
}
