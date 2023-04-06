package com.example.demo.utils;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ApplicationUtils {

   public static  <T> void updateOnTargetIfNonNullFromSource(Supplier<T> getterOfSource, Consumer<T> setterOfTarget) {
       T value = getterOfSource.get();
       if (value != null) {
           setterOfTarget.accept(value);
       }
   }
}
