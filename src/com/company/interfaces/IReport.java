package com.company.interfaces;

import java.io.IOException;

/**
 * reports interface
 * @param <T> string classes list
 */
public interface IReport<T> {
 void report(T list) throws IOException;
}