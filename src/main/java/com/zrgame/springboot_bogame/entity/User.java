package com.zrgame.springboot_bogame.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @TableId
    private String name;
    private int yixiu;
    private int erju;
    private int sijin;
    private int sanhong;
    private int straight6;
    private int redotfour;
    private int blackdot5;
    private int redotfive;
    private int blackdot6;
    private int blossomone;
    private int allaroundsix;
    private int icing;
    private int blank;
}
