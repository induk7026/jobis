package com.project.jobis.user.enums;

import com.project.jobis.exception.BadRequestException;
import java.util.Arrays;

public enum RegistrableUser {
    
    HONG("860824-1655068","홍길동"),
    KIM("921108-1582816", "김둘리"),
    MA("921108-1582816", "마징가"),
    BE("921108-1582816", "베지터"),
    SON("921108-1582816", "손오공"),
    UNKNOWN("-", "-");

    private String regNo;
    private String name;

    RegistrableUser(String regNo, String name) {
        this.regNo = regNo;
        this.name = name;
    }

    public static RegistrableUser find(String regNo, String name) {
        return Arrays.stream(RegistrableUser.values())
            .filter(registrableUser -> registrableUser.regNo.equals(regNo) && registrableUser.name.equals(name))
            .findFirst()
            .orElse(UNKNOWN);
    }
}
