plugins {
    kotlin("multiplatform") version "1.8.0-dev-1593"
}

allprojects {
    repositories {
	mavenLocal()
	mavenCentral()
        maven {
            url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/bootstrap")
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    	kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.experimental.ExperimentalObjCName"
    }
}


kotlin {
    macosX64("native") {
    binaries {
      framework {
        baseName = "Demo"
      }
    }
  }
}

tasks.wrapper {
  gradleVersion = "6.7.1"
  distributionType = Wrapper.DistributionType.ALL
}
