pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()

    }
}


dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven { url = uri("https://www.jitpack.io" ) }

    }
}

rootProject.name = "WeatherNowLater"
include(":app")
include(":core")
include(":data")
include(":features:home")
include(":features:city_chooser")
include(":features:forecast_list")
include(":weatherIconsLibrary")
