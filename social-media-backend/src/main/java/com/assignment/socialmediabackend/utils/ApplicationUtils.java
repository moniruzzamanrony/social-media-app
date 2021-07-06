package com.assignment.socialmediabackend.utils;

import java.util.UUID;

public class ApplicationUtils {

    public static String getUuid()
    {
        return UUID.randomUUID().toString();
    }
}
