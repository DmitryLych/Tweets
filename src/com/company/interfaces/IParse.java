package com.company.interfaces;

/**
 * parsing files interface
 * @param <T> stringClasses list
 */
public interface IParse<T> {
    T parse(String line);
}
