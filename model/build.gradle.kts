plugins {
    `java-library`
    jacoco
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

jacoco {
    toolVersion = "0.8.2"
}

tasks {
    val test by getting(Test::class) {
        useJUnitPlatform()
    }

    val jacocoTestReport by getting(JacocoReport::class) {
        reports {
            xml.setEnabled(true)
        }
    }
}
