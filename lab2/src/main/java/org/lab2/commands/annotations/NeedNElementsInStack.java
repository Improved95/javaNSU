package org.lab2.commands.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface NeedNElementsInStack {
    int requiredNumberOfElements();
}
