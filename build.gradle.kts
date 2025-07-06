plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`
}

group = "nl.martijnmuijsers"
version = "0.1"

gradlePlugin {
    plugins {
        create("martijnsSemanticVersioning") {
            id = "nl.martijnmuijsers.martijns-semantic-versioning"
            implementationClass = "nl.martijnmuijsers.martijnssemanticversioning.VersioningPlugin"
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}