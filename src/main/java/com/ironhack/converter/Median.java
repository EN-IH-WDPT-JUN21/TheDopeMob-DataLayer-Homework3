package com.ironhack.converter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class Median {
    private Long accountId;
    private Integer median;

    @Override
    public String toString() {
        return "Median: " + median;
    }
}
