import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("idea")
	id("java")
	alias(libs.plugins.kotlin.jvm).apply(false)
	alias(libs.plugins.kotlin.spring).apply(false)
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

dependencies {
	implementation(libs.springBootStarter)
	implementation(libs.kotlinReflect)
	compileOnly(libs.lombok)
	annotationProcessor(libs.lombok)
	testImplementation(libs.springBootStarterTest)
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

