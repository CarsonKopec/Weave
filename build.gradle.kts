plugins {
    id("java")
}

group = "dev.jkit.weave"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jsoup:jsoup:1.18.1")
    implementation("com.helger:ph-css:7.0.1")
    implementation("org.apache.commons:commons-text:1.12.0")
}
