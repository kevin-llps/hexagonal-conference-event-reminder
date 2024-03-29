package fr.kevin.llps.conf.event.reminder.bootstrap.server;

import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.junit.CacheMode.FOREVER;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static fr.kevin.llps.conf.event.reminder.bootstrap.PackagesAndLayers.BOOTSTRAP_PACKAGE;
import static fr.kevin.llps.conf.event.reminder.bootstrap.PackagesAndLayers.SERVER_PACKAGE;

@AnalyzeClasses(
        packages = "fr.kevin.llps.conf.event.reminder.infrastructure",
        cacheMode = FOREVER,
        importOptions = {DoNotIncludeTests.class})
public class ServerDevelopmentRulesTest {

    @ArchTest
    public static final ArchRule SERVER_DEVELOPMENT_RULE =
            classes()
                    .that()
                    .resideInAPackage(SERVER_PACKAGE)
                    .should()
                    .onlyHaveDependentClassesThat()
                    .resideInAnyPackage(SERVER_PACKAGE, BOOTSTRAP_PACKAGE)
                    .andShould()
                    .onlyBeAccessed()
                    .byAnyPackage(BOOTSTRAP_PACKAGE, SERVER_PACKAGE);
}
