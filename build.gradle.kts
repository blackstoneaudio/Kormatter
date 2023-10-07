plugins {
    //trick: for the same plugin versions in all sub-modules
    kotlin("multiplatform").version("1.9.0").apply(false)
}

//tasks.register("clean", Delete::class) {
//    delete(rootProject.buildDir)
//}
