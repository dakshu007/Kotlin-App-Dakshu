// Top-level build file where you can add configuration options common to all sub-projects/modules.

import org.gradle.api.tasks.Delete
import org.gradle.jvm.toolchain.JavaLanguageVersion

plugins {
    // Android and Kotlin plugins are declared here with versions, and applied in module build scripts.
    id("com.android.application") version "8.3.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false

    // Java plugin to enable toolchain configuration and common Java-related tasks at the root.
    java
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

// Use the default `clean` task created by the base/java plugins.