import com.jfrog.bintray.gradle.BintrayExtension
import com.jfrog.bintray.gradle.BintrayPlugin
import io.spring.gradle.dependencymanagement.DependencyManagementPlugin
import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension

plugins {
    id("io.spring.dependency-management").version("1.0.6.RELEASE").apply(false)
    id("com.jfrog.bintray").version("1.8.4").apply(false)
}

subprojects {
    apply<DependencyManagementPlugin>()
    apply<MavenPublishPlugin>()
    apply<BintrayPlugin>()

    repositories {
        jcenter()
    }

    configure<DependencyManagementExtension> {
        imports {
            mavenBom("org.junit:junit-bom:5.3.1")
            mavenBom("com.fasterxml.jackson:jackson-bom:2.9.7")
        }
        dependencies {
            dependency("org.skyscreamer:jsonassert:1.5.0")
            dependency("nl.jqno.equalsverifier:equalsverifier:3.0.3")
        }
    }

    configure<BintrayExtension> {
        user = System.getenv("BINTRAY_USER")
        key = System.getenv("BINTRAY_KEY")
    }
}

tasks {
    wrapper {
        gradleVersion = "5.0"
        distributionType = Wrapper.DistributionType.ALL
    }
}
