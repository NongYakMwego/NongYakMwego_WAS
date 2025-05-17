package nym.nym.global.util;

import org.springframework.context.annotation.Bean;

import java.util.UUID;
public class UuidUtil {
    public static String createUuid(){
        return UUID.randomUUID().toString();
    }
}
