group = "org.example"
version = "1.0"

plugins {
    java
    kotlin("jvm") version "1.3.70"
}

repositories {
    mavenCentral()
}

dependencies {
    compile(gradleApi())
    implementation(kotlin("stdlib-jdk8"))
}
