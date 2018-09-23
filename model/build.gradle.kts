plugins {
    `java-library`
    jacoco
}

dependencies {
    api("com.fasterxml.jackson.core:jackson-annotations")
    api("com.fasterxml.jackson.core:jackson-databind")
    api("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")

    implementation("com.google.guava:guava")

    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
    testImplementation("org.skyscreamer:jsonassert")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

jacoco {
    toolVersion = "0.8.2"
}

publishing {
    publications {
        val main by creating(MavenPublication::class) {
            from(components["java"])

            val sourcesJar by tasks
            val javadocJar by tasks

            artifact(sourcesJar)
            artifact(javadocJar)
        }
    }
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

    val sourcesJar by creating(Jar::class) {
        from(sourceSets["main"].allJava)
        classifier = "sources"
    }

    val javadocJar by creating(Jar::class) {
        val javadoc by tasks

        from(javadoc)
        classifier = "javadoc"
    }
}
