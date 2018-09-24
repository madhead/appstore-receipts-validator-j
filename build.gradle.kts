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
            dependency("com.google.guava:guava:26.0-jre")
            dependency("org.skyscreamer:jsonassert:1.5.0")
        }
    }

    configure<BintrayExtension> {
        user = System.getenv("BINTRAY_USER")
        key = System.getenv("BINTRAY_KEY")
    }
}

task<Wrapper>("wrapper") {
    gradleVersion = "4.10.2"
    distributionType = Wrapper.DistributionType.ALL
}
