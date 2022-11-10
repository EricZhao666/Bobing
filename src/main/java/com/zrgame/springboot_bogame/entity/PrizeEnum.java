package com.zrgame.springboot_bogame.entity;

/**
 * A list of bo game prizes
 * @author hlx
 * @version 1.0 2018-3-16
 */
public enum PrizeEnum {
    SHOW("yixiu"),
    LIFT("erju"),
    ENTER("sijin"),
    RED("sanhong"),
    PAIR("straight6"),
    CHIEF("redotfour"),
    FIVE("blackdot5"),

    FIVERED("redotfive"),

    SIXBLACK("blackdot6"),

    SIXONE("blossomone"),
    SIXFIVE("allaroundsix"),
    FLOWER("icing"),
    BLANK("NULL");

    private String desc;

    PrizeEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }


    public static PrizeEnum get(Integer id){
        switch (id) {
            case 0:
                return SHOW;
            case 1:
                return LIFT;
            case 2:
                return ENTER;
            case 3:
                return RED;
            case 4:
                return PAIR;
            case 5:
                return CHIEF;
        }
        return BLANK;
    }
}
