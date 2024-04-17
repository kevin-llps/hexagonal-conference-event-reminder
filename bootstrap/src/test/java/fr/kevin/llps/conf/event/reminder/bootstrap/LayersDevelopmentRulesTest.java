package fr.kevin.llps.conf.event.reminder.bootstrap;

import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.junit.CacheMode.FOREVER;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;
import static fr.kevin.llps.conf.event.reminder.bootstrap.PackagesAndLayers.*;

@AnalyzeClasses(
        packages = "fr.kevin.llps.conf.event.reminder",
        cacheMode = FOREVER,
        importOptions = {DoNotIncludeTests.class})
public class LayersDevelopmentRulesTest {

    @ArchTest
    public static final ArchRule LAYERS_DEVELOPMENT_RULE =
            layeredArchitecture()
                    .layer(DOMAIN_LAYER)
                    .definedBy(DOMAIN_PACKAGE)
                    .layer(BOOTSTRAP_LAYER)
                    .definedBy(BOOTSTRAP_PACKAGE)
                    .layer(CLIENT_LAYER)
                    .definedBy(CLIENT_PACKAGE)
                    .layer(REST_ADAPTER_LAYER)
                    .definedBy(REST_ADAPTER_PACKAGE)
                    .layer(SERVER_LAYER)
                    .definedBy(SERVER_PACKAGE)
                    .layer(MYSQL_ADAPTER_LAYER)
                    .definedBy(MYSQL_ADAPTER_PACKAGE)
                    .whereLayer(DOMAIN_LAYER)
                    .mayOnlyBeAccessedByLayers(BOOTSTRAP_LAYER, CLIENT_LAYER, SERVER_LAYER)
                    .whereLayer(BOOTSTRAP_LAYER)
                    .mayNotBeAccessedByAnyLayer()
                    .whereLayer(CLIENT_LAYER)
                    .mayOnlyBeAccessedByLayers(BOOTSTRAP_LAYER)
                    .whereLayer(REST_ADAPTER_LAYER)
                    .mayOnlyBeAccessedByLayers(BOOTSTRAP_LAYER)
                    .whereLayer(SERVER_LAYER)
                    .mayOnlyBeAccessedByLayers(BOOTSTRAP_LAYER)
                    .whereLayer(MYSQL_ADAPTER_LAYER)
                    .mayOnlyBeAccessedByLayers(BOOTSTRAP_LAYER)
                    .ignoreDependency("fr.kevin.llps.conf.event.reminder.Application", "fr.kevin.llps.conf.event.reminder.bootstrap.config.AppConfiguration");
}
