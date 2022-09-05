package com.project.jobis.scrap.enums;

public enum IncomeType {

    EARNED("근로소득(연간)"),
    TAX_AMOUNT("산출세액");

    private String description;

    IncomeType(String description) {
        this.description = description;
    }
}
