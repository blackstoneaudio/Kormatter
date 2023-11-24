# Kormatter

This is more or less the exact same project as [this](https://github.com/pearxteam/kormatter). I 
simply updated it to support native kotlin platforms and updated the build system to work with 
modern Kotlin Multiplatform. Big thanks to the original creator [mrapplexz](https://github.com/mrapplexz)


## Description
Kormatter is a multiplatform Kotlin interpreter for printf-style format strings 
(like java.util.Formatter). Allows to do your favourite (or not so) String.format(...) in pure Kotlin ;).

### How to Add Kormatter to Your Project

```kotlin 
repositories {
    ... 
    maven("https://repos.awhb.dev/releases")
    ...
}
```

add following in your commonMain source set
```kotlin
sourceSets {
  val commonMain by getting {
    dependencies {
      ...
      implementation("com.blackstone:kormatter:0.1.0")
        ...
    }
  }
}
  ...
```
