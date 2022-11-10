package com.zrgame.springboot_bogame.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameResult {
    private String resultName;
    private String resultNum;
    private String resultSortNum;
}
