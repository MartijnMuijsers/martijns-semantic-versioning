plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`
}

object ArtifactProperties {
    const val GROUP = "nl.martijnmuijsers.martijns-semantic-versioning"
    const val ID = "martijns-semantic-versioning"
    const val VERSION = "0.1"
}

group = ArtifactProperties.GROUP
version = ArtifactProperties.VERSION

gradlePlugin {
    plugins {
        create("martijnsSemanticVersioning") {
            group = ArtifactProperties.GROUP
            id = ArtifactProperties.ID
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

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/MartijnMuijsers/martijns-semantic-versioning")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
            }
        }
    }
}