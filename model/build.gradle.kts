plugins {
    `java-library`
}

dependencies {
    api("com.fasterxml.jackson.core:jackson-annotations")
    api("com.fasterxml.jackson.core:jackson-databind")

    implementation("com.google.guava:guava")

    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
    testImplementation("org.skyscreamer:jsonassert")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks {
    val test by getting(Test::class) {
        useJUnitPlatform()
    }
}
