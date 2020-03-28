group = "org.example"
version = "1.0"

plugins {
    groovy
}

dependencies {
    implementation(gradleApi())
    implementation(localGroovy())
}

buildscript {
    repositories {
        flatDir {
            dirs("../build/libs")
        }
    }

    dependencies {
        classpath(group = "org.example", name = "GradlePlugin", version = "1.0")
    }
}

apply {
    plugin("org.example.PrintFilePlugin")
}