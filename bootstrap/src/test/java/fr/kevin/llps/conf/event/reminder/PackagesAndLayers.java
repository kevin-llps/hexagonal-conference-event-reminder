package fr.kevin.llps.conf.event.reminder;

public class PackagesAndLayers {
  // APPLICATION PACKAGES
  public static final String BOOTSTRAP_PACKAGE = "fr.kevin.llps.conf.event.reminder.bootstrap..";
  public static final String DOMAIN_PACKAGE = "fr.kevin.llps.conf.event.reminder.domain..";
  public static final String CLIENT_PACKAGE = "fr.kevin.llps.conf.event.reminder.api.rest..";
  public static final String REST_ADAPTER_PACKAGE =
      "fr.kevin.llps.conf.event.reminder.api.rest..";
  public static final String SERVER_PACKAGE = "fr.kevin.llps.conf.event.reminder.infrastructure..";
  public static final String POSTGRES_ADAPTER_PACKAGE =
      "fr.kevin.llps.conf.event.reminder.infrastructure.mysql..";

  // JAVA, FRAMEWORKS AND LIBRARIES PACKAGES
  public static final String JAVA_PACKAGE = "java..";
  public static final String LOMBOK_PACKAGE = "lombok..";
  public static final String SLF4J = "org.slf4j..";

  // APPLICATION LAYERS
  public static final String DOMAIN_LAYER = "Domain";
  public static final String BOOTSTRAP_LAYER = "Bootstrap";
  public static final String CLIENT_LAYER = "Client";
  public static final String REST_ADAPTER_LAYER = "Rest";
  public static final String SERVER_LAYER = "Server";
  public static final String POSTGRES_ADAPTER_LAYER = "Postgres";
}
