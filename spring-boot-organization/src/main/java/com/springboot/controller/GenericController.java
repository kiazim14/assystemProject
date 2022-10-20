package com.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

@Slf4j
public class GenericController {

    void printLogsForException(Exception e){
        log.error((e.getMessage()));
        log.debug(Arrays.toString(e.getStackTrace()));
    }
}
