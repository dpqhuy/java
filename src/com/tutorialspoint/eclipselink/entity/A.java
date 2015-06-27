package com.tutorialspoint.eclipselink.entity;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

import com.tutorialspoint.eclipselink.entity.A.Key;

public class A {
	public static void main(String[] args) {
        for (Map map : new Map[]{
                new HashMap<>(),
                new WeakHashMap<>(),
                new TreeMap<>(),
                new IdentityHashMap<>(),
                new EnumMap<>(Key.class),
                new Hashtable<>(),
                new LinkedHashMap<>(),
                new ConcurrentSkipListMap<>(),
                new ConcurrentHashMap<>()
        }) {
            System.out.print(map.getClass().getSimpleName() + ": ");
            map.computeIfAbsent(Key.Hello, s -> {
                map.computeIfAbsent(Key.Hello, t -> 1);
                return 2;
            });
            System.out.println(map);
        }
    }

    enum Key {Hello}
}
