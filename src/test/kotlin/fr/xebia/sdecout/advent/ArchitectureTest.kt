package fr.xebia.sdecout.advent

import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices

@AnalyzeClasses(
    packages = ["fr.xebia.sdecout.advent"],
    importOptions = [DoNotIncludeTests::class]
)
class ArchitectureTest {

    @ArchTest
    val `each day is independent`: ArchRule = slices()
        .matching("fr.xebia.sdecout.advent.(*)..")
        .should().notDependOnEachOther()
        .because("Dependencies are most likely mistakes")

}
