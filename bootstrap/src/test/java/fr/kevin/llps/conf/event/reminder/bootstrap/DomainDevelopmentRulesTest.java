package fr.kevin.llps.conf.event.reminder.bootstrap;

import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.junit.CacheMode.FOREVER;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static fr.kevin.llps.conf.event.reminder.bootstrap.PackagesAndLayers.*;

@AnalyzeClasses(
        packages = "fr.kevin.llps.conf.event.reminder.domain",
        cacheMode = FOREVER,
        importOptions = {DoNotIncludeTests.class})
public class DomainDevelopmentRulesTest {

    private static final String[] allowedPackages = {
            JAVA_PACKAGE, DOMAIN_PACKAGE, LOMBOK_PACKAGE, SLF4J, "org.apache.commons..", ""
    };

    private static final String[] allowedAccessors = {
            DOMAIN_PACKAGE, BOOTSTRAP_PACKAGE, CLIENT_PACKAGE, SERVER_PACKAGE
    };

    @ArchTest
    public static final ArchRule DOMAIN_DEVELOPMENT_RULE =
            classes()
                    .that()
                    .resideInAPackage(DOMAIN_PACKAGE)
                    .should()
                    .onlyDependOnClassesThat()
                    .resideInAnyPackage(allowedPackages)
                    .andShould()
                    .onlyAccessClassesThat()
                    .resideInAnyPackage(allowedPackages)
                    .andShould()
                    .onlyBeAccessed()
                    .byClassesThat()
                    .resideInAnyPackage(allowedAccessors)
                    .andShould()
                    .onlyHaveDependentClassesThat()
                    .resideInAnyPackage(allowedAccessors);
}
