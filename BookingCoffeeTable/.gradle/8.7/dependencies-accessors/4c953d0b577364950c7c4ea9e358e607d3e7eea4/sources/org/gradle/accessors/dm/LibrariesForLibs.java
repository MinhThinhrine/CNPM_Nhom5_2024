package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the {@code libs} extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final ComLibraryAccessors laccForComLibraryAccessors = new ComLibraryAccessors(owner);
    private final CommonsLibraryAccessors laccForCommonsLibraryAccessors = new CommonsLibraryAccessors(owner);
    private final JavaxLibraryAccessors laccForJavaxLibraryAccessors = new JavaxLibraryAccessors(owner);
    private final JunitLibraryAccessors laccForJunitLibraryAccessors = new JunitLibraryAccessors(owner);
    private final MysqlLibraryAccessors laccForMysqlLibraryAccessors = new MysqlLibraryAccessors(owner);
    private final OrgLibraryAccessors laccForOrgLibraryAccessors = new OrgLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Group of libraries at <b>com</b>
     */
    public ComLibraryAccessors getCom() {
        return laccForComLibraryAccessors;
    }

    /**
     * Group of libraries at <b>commons</b>
     */
    public CommonsLibraryAccessors getCommons() {
        return laccForCommonsLibraryAccessors;
    }

    /**
     * Group of libraries at <b>javax</b>
     */
    public JavaxLibraryAccessors getJavax() {
        return laccForJavaxLibraryAccessors;
    }

    /**
     * Group of libraries at <b>junit</b>
     */
    public JunitLibraryAccessors getJunit() {
        return laccForJunitLibraryAccessors;
    }

    /**
     * Group of libraries at <b>mysql</b>
     */
    public MysqlLibraryAccessors getMysql() {
        return laccForMysqlLibraryAccessors;
    }

    /**
     * Group of libraries at <b>org</b>
     */
    public OrgLibraryAccessors getOrg() {
        return laccForOrgLibraryAccessors;
    }

    /**
     * Group of versions at <b>versions</b>
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Group of bundles at <b>bundles</b>
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class ComLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleLibraryAccessors laccForComGoogleLibraryAccessors = new ComGoogleLibraryAccessors(owner);
        private final ComSunLibraryAccessors laccForComSunLibraryAccessors = new ComSunLibraryAccessors(owner);

        public ComLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google</b>
         */
        public ComGoogleLibraryAccessors getGoogle() {
            return laccForComGoogleLibraryAccessors;
        }

        /**
         * Group of libraries at <b>com.sun</b>
         */
        public ComSunLibraryAccessors getSun() {
            return laccForComSunLibraryAccessors;
        }

    }

    public static class ComGoogleLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleApiLibraryAccessors laccForComGoogleApiLibraryAccessors = new ComGoogleApiLibraryAccessors(owner);
        private final ComGoogleCodeLibraryAccessors laccForComGoogleCodeLibraryAccessors = new ComGoogleCodeLibraryAccessors(owner);
        private final ComGoogleOauthLibraryAccessors laccForComGoogleOauthLibraryAccessors = new ComGoogleOauthLibraryAccessors(owner);

        public ComGoogleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.api</b>
         */
        public ComGoogleApiLibraryAccessors getApi() {
            return laccForComGoogleApiLibraryAccessors;
        }

        /**
         * Group of libraries at <b>com.google.code</b>
         */
        public ComGoogleCodeLibraryAccessors getCode() {
            return laccForComGoogleCodeLibraryAccessors;
        }

        /**
         * Group of libraries at <b>com.google.oauth</b>
         */
        public ComGoogleOauthLibraryAccessors getOauth() {
            return laccForComGoogleOauthLibraryAccessors;
        }

    }

    public static class ComGoogleApiLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleApiClientLibraryAccessors laccForComGoogleApiClientLibraryAccessors = new ComGoogleApiClientLibraryAccessors(owner);

        public ComGoogleApiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.api.client</b>
         */
        public ComGoogleApiClientLibraryAccessors getClient() {
            return laccForComGoogleApiClientLibraryAccessors;
        }

    }

    public static class ComGoogleApiClientLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleApiClientGoogleLibraryAccessors laccForComGoogleApiClientGoogleLibraryAccessors = new ComGoogleApiClientGoogleLibraryAccessors(owner);

        public ComGoogleApiClientLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.api.client.google</b>
         */
        public ComGoogleApiClientGoogleLibraryAccessors getGoogle() {
            return laccForComGoogleApiClientGoogleLibraryAccessors;
        }

    }

    public static class ComGoogleApiClientGoogleLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleApiClientGoogleApiLibraryAccessors laccForComGoogleApiClientGoogleApiLibraryAccessors = new ComGoogleApiClientGoogleApiLibraryAccessors(owner);

        public ComGoogleApiClientGoogleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.api.client.google.api</b>
         */
        public ComGoogleApiClientGoogleApiLibraryAccessors getApi() {
            return laccForComGoogleApiClientGoogleApiLibraryAccessors;
        }

    }

    public static class ComGoogleApiClientGoogleApiLibraryAccessors extends SubDependencyFactory {

        public ComGoogleApiClientGoogleApiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>client</b> with <b>com.google.api-client:google-api-client</b> coordinates and
         * with version reference <b>com.google.api.client.google.api.client</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getClient() {
            return create("com.google.api.client.google.api.client");
        }

    }

    public static class ComGoogleCodeLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleCodeGsonLibraryAccessors laccForComGoogleCodeGsonLibraryAccessors = new ComGoogleCodeGsonLibraryAccessors(owner);

        public ComGoogleCodeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.code.gson</b>
         */
        public ComGoogleCodeGsonLibraryAccessors getGson() {
            return laccForComGoogleCodeGsonLibraryAccessors;
        }

    }

    public static class ComGoogleCodeGsonLibraryAccessors extends SubDependencyFactory {

        public ComGoogleCodeGsonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>gson</b> with <b>com.google.code.gson:gson</b> coordinates and
         * with version reference <b>com.google.code.gson.gson</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getGson() {
            return create("com.google.code.gson.gson");
        }

    }

    public static class ComGoogleOauthLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleOauthClientLibraryAccessors laccForComGoogleOauthClientLibraryAccessors = new ComGoogleOauthClientLibraryAccessors(owner);

        public ComGoogleOauthLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.oauth.client</b>
         */
        public ComGoogleOauthClientLibraryAccessors getClient() {
            return laccForComGoogleOauthClientLibraryAccessors;
        }

    }

    public static class ComGoogleOauthClientLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleOauthClientGoogleLibraryAccessors laccForComGoogleOauthClientGoogleLibraryAccessors = new ComGoogleOauthClientGoogleLibraryAccessors(owner);

        public ComGoogleOauthClientLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.oauth.client.google</b>
         */
        public ComGoogleOauthClientGoogleLibraryAccessors getGoogle() {
            return laccForComGoogleOauthClientGoogleLibraryAccessors;
        }

    }

    public static class ComGoogleOauthClientGoogleLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleOauthClientGoogleOauthLibraryAccessors laccForComGoogleOauthClientGoogleOauthLibraryAccessors = new ComGoogleOauthClientGoogleOauthLibraryAccessors(owner);

        public ComGoogleOauthClientGoogleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.oauth.client.google.oauth</b>
         */
        public ComGoogleOauthClientGoogleOauthLibraryAccessors getOauth() {
            return laccForComGoogleOauthClientGoogleOauthLibraryAccessors;
        }

    }

    public static class ComGoogleOauthClientGoogleOauthLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleOauthClientGoogleOauthClientLibraryAccessors laccForComGoogleOauthClientGoogleOauthClientLibraryAccessors = new ComGoogleOauthClientGoogleOauthClientLibraryAccessors(owner);

        public ComGoogleOauthClientGoogleOauthLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.oauth.client.google.oauth.client</b>
         */
        public ComGoogleOauthClientGoogleOauthClientLibraryAccessors getClient() {
            return laccForComGoogleOauthClientGoogleOauthClientLibraryAccessors;
        }

    }

    public static class ComGoogleOauthClientGoogleOauthClientLibraryAccessors extends SubDependencyFactory {

        public ComGoogleOauthClientGoogleOauthClientLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jetty</b> with <b>com.google.oauth-client:google-oauth-client-jetty</b> coordinates and
         * with version reference <b>com.google.oauth.client.google.oauth.client.jetty</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJetty() {
            return create("com.google.oauth.client.google.oauth.client.jetty");
        }

    }

    public static class ComSunLibraryAccessors extends SubDependencyFactory {
        private final ComSunMailLibraryAccessors laccForComSunMailLibraryAccessors = new ComSunMailLibraryAccessors(owner);

        public ComSunLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.sun.mail</b>
         */
        public ComSunMailLibraryAccessors getMail() {
            return laccForComSunMailLibraryAccessors;
        }

    }

    public static class ComSunMailLibraryAccessors extends SubDependencyFactory {
        private final ComSunMailJakartaLibraryAccessors laccForComSunMailJakartaLibraryAccessors = new ComSunMailJakartaLibraryAccessors(owner);

        public ComSunMailLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.sun.mail.jakarta</b>
         */
        public ComSunMailJakartaLibraryAccessors getJakarta() {
            return laccForComSunMailJakartaLibraryAccessors;
        }

    }

    public static class ComSunMailJakartaLibraryAccessors extends SubDependencyFactory {

        public ComSunMailJakartaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>mail</b> with <b>com.sun.mail:jakarta.mail</b> coordinates and
         * with version reference <b>com.sun.mail.jakarta.mail</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMail() {
            return create("com.sun.mail.jakarta.mail");
        }

    }

    public static class CommonsLibraryAccessors extends SubDependencyFactory {
        private final CommonsFileuploadLibraryAccessors laccForCommonsFileuploadLibraryAccessors = new CommonsFileuploadLibraryAccessors(owner);
        private final CommonsIoLibraryAccessors laccForCommonsIoLibraryAccessors = new CommonsIoLibraryAccessors(owner);

        public CommonsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>commons.fileupload</b>
         */
        public CommonsFileuploadLibraryAccessors getFileupload() {
            return laccForCommonsFileuploadLibraryAccessors;
        }

        /**
         * Group of libraries at <b>commons.io</b>
         */
        public CommonsIoLibraryAccessors getIo() {
            return laccForCommonsIoLibraryAccessors;
        }

    }

    public static class CommonsFileuploadLibraryAccessors extends SubDependencyFactory {
        private final CommonsFileuploadCommonsLibraryAccessors laccForCommonsFileuploadCommonsLibraryAccessors = new CommonsFileuploadCommonsLibraryAccessors(owner);

        public CommonsFileuploadLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>commons.fileupload.commons</b>
         */
        public CommonsFileuploadCommonsLibraryAccessors getCommons() {
            return laccForCommonsFileuploadCommonsLibraryAccessors;
        }

    }

    public static class CommonsFileuploadCommonsLibraryAccessors extends SubDependencyFactory {

        public CommonsFileuploadCommonsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>fileupload</b> with <b>commons-fileupload:commons-fileupload</b> coordinates and
         * with version reference <b>commons.fileupload.commons.fileupload</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getFileupload() {
            return create("commons.fileupload.commons.fileupload");
        }

    }

    public static class CommonsIoLibraryAccessors extends SubDependencyFactory {
        private final CommonsIoCommonsLibraryAccessors laccForCommonsIoCommonsLibraryAccessors = new CommonsIoCommonsLibraryAccessors(owner);

        public CommonsIoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>commons.io.commons</b>
         */
        public CommonsIoCommonsLibraryAccessors getCommons() {
            return laccForCommonsIoCommonsLibraryAccessors;
        }

    }

    public static class CommonsIoCommonsLibraryAccessors extends SubDependencyFactory {

        public CommonsIoCommonsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>io</b> with <b>commons-io:commons-io</b> coordinates and
         * with version reference <b>commons.io.commons.io</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getIo() {
            return create("commons.io.commons.io");
        }

    }

    public static class JavaxLibraryAccessors extends SubDependencyFactory {
        private final JavaxMailLibraryAccessors laccForJavaxMailLibraryAccessors = new JavaxMailLibraryAccessors(owner);
        private final JavaxServletLibraryAccessors laccForJavaxServletLibraryAccessors = new JavaxServletLibraryAccessors(owner);

        public JavaxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>javax.mail</b>
         */
        public JavaxMailLibraryAccessors getMail() {
            return laccForJavaxMailLibraryAccessors;
        }

        /**
         * Group of libraries at <b>javax.servlet</b>
         */
        public JavaxServletLibraryAccessors getServlet() {
            return laccForJavaxServletLibraryAccessors;
        }

    }

    public static class JavaxMailLibraryAccessors extends SubDependencyFactory {

        public JavaxMailLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>mail</b> with <b>javax.mail:mail</b> coordinates and
         * with version reference <b>javax.mail.mail</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMail() {
            return create("javax.mail.mail");
        }

    }

    public static class JavaxServletLibraryAccessors extends SubDependencyFactory {
        private final JavaxServletJavaxLibraryAccessors laccForJavaxServletJavaxLibraryAccessors = new JavaxServletJavaxLibraryAccessors(owner);
        private final JavaxServletJspLibraryAccessors laccForJavaxServletJspLibraryAccessors = new JavaxServletJspLibraryAccessors(owner);

        public JavaxServletLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jstl</b> with <b>javax.servlet:jstl</b> coordinates and
         * with version reference <b>javax.servlet.jstl</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJstl() {
            return create("javax.servlet.jstl");
        }

        /**
         * Group of libraries at <b>javax.servlet.javax</b>
         */
        public JavaxServletJavaxLibraryAccessors getJavax() {
            return laccForJavaxServletJavaxLibraryAccessors;
        }

        /**
         * Group of libraries at <b>javax.servlet.jsp</b>
         */
        public JavaxServletJspLibraryAccessors getJsp() {
            return laccForJavaxServletJspLibraryAccessors;
        }

    }

    public static class JavaxServletJavaxLibraryAccessors extends SubDependencyFactory {
        private final JavaxServletJavaxServletLibraryAccessors laccForJavaxServletJavaxServletLibraryAccessors = new JavaxServletJavaxServletLibraryAccessors(owner);

        public JavaxServletJavaxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>javax.servlet.javax.servlet</b>
         */
        public JavaxServletJavaxServletLibraryAccessors getServlet() {
            return laccForJavaxServletJavaxServletLibraryAccessors;
        }

    }

    public static class JavaxServletJavaxServletLibraryAccessors extends SubDependencyFactory {

        public JavaxServletJavaxServletLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>javax.servlet:javax.servlet-api</b> coordinates and
         * with version reference <b>javax.servlet.javax.servlet.api</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getApi() {
            return create("javax.servlet.javax.servlet.api");
        }

    }

    public static class JavaxServletJspLibraryAccessors extends SubDependencyFactory {

        public JavaxServletJspLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>javax.servlet:jsp-api</b> coordinates and
         * with version reference <b>javax.servlet.jsp.api</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getApi() {
            return create("javax.servlet.jsp.api");
        }

    }

    public static class JunitLibraryAccessors extends SubDependencyFactory {

        public JunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>junit</b> with <b>junit:junit</b> coordinates and
         * with version reference <b>junit.junit</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJunit() {
            return create("junit.junit");
        }

    }

    public static class MysqlLibraryAccessors extends SubDependencyFactory {
        private final MysqlMysqlLibraryAccessors laccForMysqlMysqlLibraryAccessors = new MysqlMysqlLibraryAccessors(owner);

        public MysqlLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>mysql.mysql</b>
         */
        public MysqlMysqlLibraryAccessors getMysql() {
            return laccForMysqlMysqlLibraryAccessors;
        }

    }

    public static class MysqlMysqlLibraryAccessors extends SubDependencyFactory {
        private final MysqlMysqlConnectorLibraryAccessors laccForMysqlMysqlConnectorLibraryAccessors = new MysqlMysqlConnectorLibraryAccessors(owner);

        public MysqlMysqlLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>mysql.mysql.connector</b>
         */
        public MysqlMysqlConnectorLibraryAccessors getConnector() {
            return laccForMysqlMysqlConnectorLibraryAccessors;
        }

    }

    public static class MysqlMysqlConnectorLibraryAccessors extends SubDependencyFactory {

        public MysqlMysqlConnectorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>java</b> with <b>mysql:mysql-connector-java</b> coordinates and
         * with version reference <b>mysql.mysql.connector.java</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJava() {
            return create("mysql.mysql.connector.java");
        }

    }

    public static class OrgLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheLibraryAccessors laccForOrgApacheLibraryAccessors = new OrgApacheLibraryAccessors(owner);
        private final OrgJdbiLibraryAccessors laccForOrgJdbiLibraryAccessors = new OrgJdbiLibraryAccessors(owner);
        private final OrgSlf4jLibraryAccessors laccForOrgSlf4jLibraryAccessors = new OrgSlf4jLibraryAccessors(owner);

        public OrgLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache</b>
         */
        public OrgApacheLibraryAccessors getApache() {
            return laccForOrgApacheLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.jdbi</b>
         */
        public OrgJdbiLibraryAccessors getJdbi() {
            return laccForOrgJdbiLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.slf4j</b>
         */
        public OrgSlf4jLibraryAccessors getSlf4j() {
            return laccForOrgSlf4jLibraryAccessors;
        }

    }

    public static class OrgApacheLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheHttpcomponentsLibraryAccessors laccForOrgApacheHttpcomponentsLibraryAccessors = new OrgApacheHttpcomponentsLibraryAccessors(owner);

        public OrgApacheLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.httpcomponents</b>
         */
        public OrgApacheHttpcomponentsLibraryAccessors getHttpcomponents() {
            return laccForOrgApacheHttpcomponentsLibraryAccessors;
        }

    }

    public static class OrgApacheHttpcomponentsLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheHttpcomponentsFluentLibraryAccessors laccForOrgApacheHttpcomponentsFluentLibraryAccessors = new OrgApacheHttpcomponentsFluentLibraryAccessors(owner);

        public OrgApacheHttpcomponentsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.httpcomponents.fluent</b>
         */
        public OrgApacheHttpcomponentsFluentLibraryAccessors getFluent() {
            return laccForOrgApacheHttpcomponentsFluentLibraryAccessors;
        }

    }

    public static class OrgApacheHttpcomponentsFluentLibraryAccessors extends SubDependencyFactory {

        public OrgApacheHttpcomponentsFluentLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>hc</b> with <b>org.apache.httpcomponents:fluent-hc</b> coordinates and
         * with version reference <b>org.apache.httpcomponents.fluent.hc</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getHc() {
            return create("org.apache.httpcomponents.fluent.hc");
        }

    }

    public static class OrgJdbiLibraryAccessors extends SubDependencyFactory {
        private final OrgJdbiJdbi3LibraryAccessors laccForOrgJdbiJdbi3LibraryAccessors = new OrgJdbiJdbi3LibraryAccessors(owner);

        public OrgJdbiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.jdbi.jdbi3</b>
         */
        public OrgJdbiJdbi3LibraryAccessors getJdbi3() {
            return laccForOrgJdbiJdbi3LibraryAccessors;
        }

    }

    public static class OrgJdbiJdbi3LibraryAccessors extends SubDependencyFactory {

        public OrgJdbiJdbi3LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>org.jdbi:jdbi3-core</b> coordinates and
         * with version reference <b>org.jdbi.jdbi3.core</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("org.jdbi.jdbi3.core");
        }

        /**
         * Dependency provider for <b>sqlobject</b> with <b>org.jdbi:jdbi3-sqlobject</b> coordinates and
         * with version reference <b>org.jdbi.jdbi3.sqlobject</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSqlobject() {
            return create("org.jdbi.jdbi3.sqlobject");
        }

    }

    public static class OrgSlf4jLibraryAccessors extends SubDependencyFactory {
        private final OrgSlf4jSlf4jLibraryAccessors laccForOrgSlf4jSlf4jLibraryAccessors = new OrgSlf4jSlf4jLibraryAccessors(owner);

        public OrgSlf4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.slf4j.slf4j</b>
         */
        public OrgSlf4jSlf4jLibraryAccessors getSlf4j() {
            return laccForOrgSlf4jSlf4jLibraryAccessors;
        }

    }

    public static class OrgSlf4jSlf4jLibraryAccessors extends SubDependencyFactory {

        public OrgSlf4jSlf4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>org.slf4j:slf4j-api</b> coordinates and
         * with version reference <b>org.slf4j.slf4j.api</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getApi() {
            return create("org.slf4j.slf4j.api");
        }

        /**
         * Dependency provider for <b>log4j12</b> with <b>org.slf4j:slf4j-log4j12</b> coordinates and
         * with version reference <b>org.slf4j.slf4j.log4j12</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getLog4j12() {
            return create("org.slf4j.slf4j.log4j12");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final ComVersionAccessors vaccForComVersionAccessors = new ComVersionAccessors(providers, config);
        private final CommonsVersionAccessors vaccForCommonsVersionAccessors = new CommonsVersionAccessors(providers, config);
        private final JavaxVersionAccessors vaccForJavaxVersionAccessors = new JavaxVersionAccessors(providers, config);
        private final JunitVersionAccessors vaccForJunitVersionAccessors = new JunitVersionAccessors(providers, config);
        private final MysqlVersionAccessors vaccForMysqlVersionAccessors = new MysqlVersionAccessors(providers, config);
        private final OrgVersionAccessors vaccForOrgVersionAccessors = new OrgVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com</b>
         */
        public ComVersionAccessors getCom() {
            return vaccForComVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.commons</b>
         */
        public CommonsVersionAccessors getCommons() {
            return vaccForCommonsVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.javax</b>
         */
        public JavaxVersionAccessors getJavax() {
            return vaccForJavaxVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.junit</b>
         */
        public JunitVersionAccessors getJunit() {
            return vaccForJunitVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.mysql</b>
         */
        public MysqlVersionAccessors getMysql() {
            return vaccForMysqlVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org</b>
         */
        public OrgVersionAccessors getOrg() {
            return vaccForOrgVersionAccessors;
        }

    }

    public static class ComVersionAccessors extends VersionFactory  {

        private final ComGoogleVersionAccessors vaccForComGoogleVersionAccessors = new ComGoogleVersionAccessors(providers, config);
        private final ComSunVersionAccessors vaccForComSunVersionAccessors = new ComSunVersionAccessors(providers, config);
        public ComVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google</b>
         */
        public ComGoogleVersionAccessors getGoogle() {
            return vaccForComGoogleVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.com.sun</b>
         */
        public ComSunVersionAccessors getSun() {
            return vaccForComSunVersionAccessors;
        }

    }

    public static class ComGoogleVersionAccessors extends VersionFactory  {

        private final ComGoogleApiVersionAccessors vaccForComGoogleApiVersionAccessors = new ComGoogleApiVersionAccessors(providers, config);
        private final ComGoogleCodeVersionAccessors vaccForComGoogleCodeVersionAccessors = new ComGoogleCodeVersionAccessors(providers, config);
        private final ComGoogleOauthVersionAccessors vaccForComGoogleOauthVersionAccessors = new ComGoogleOauthVersionAccessors(providers, config);
        public ComGoogleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google.api</b>
         */
        public ComGoogleApiVersionAccessors getApi() {
            return vaccForComGoogleApiVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.com.google.code</b>
         */
        public ComGoogleCodeVersionAccessors getCode() {
            return vaccForComGoogleCodeVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.com.google.oauth</b>
         */
        public ComGoogleOauthVersionAccessors getOauth() {
            return vaccForComGoogleOauthVersionAccessors;
        }

    }

    public static class ComGoogleApiVersionAccessors extends VersionFactory  {

        private final ComGoogleApiClientVersionAccessors vaccForComGoogleApiClientVersionAccessors = new ComGoogleApiClientVersionAccessors(providers, config);
        public ComGoogleApiVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google.api.client</b>
         */
        public ComGoogleApiClientVersionAccessors getClient() {
            return vaccForComGoogleApiClientVersionAccessors;
        }

    }

    public static class ComGoogleApiClientVersionAccessors extends VersionFactory  {

        private final ComGoogleApiClientGoogleVersionAccessors vaccForComGoogleApiClientGoogleVersionAccessors = new ComGoogleApiClientGoogleVersionAccessors(providers, config);
        public ComGoogleApiClientVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google.api.client.google</b>
         */
        public ComGoogleApiClientGoogleVersionAccessors getGoogle() {
            return vaccForComGoogleApiClientGoogleVersionAccessors;
        }

    }

    public static class ComGoogleApiClientGoogleVersionAccessors extends VersionFactory  {

        private final ComGoogleApiClientGoogleApiVersionAccessors vaccForComGoogleApiClientGoogleApiVersionAccessors = new ComGoogleApiClientGoogleApiVersionAccessors(providers, config);
        public ComGoogleApiClientGoogleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google.api.client.google.api</b>
         */
        public ComGoogleApiClientGoogleApiVersionAccessors getApi() {
            return vaccForComGoogleApiClientGoogleApiVersionAccessors;
        }

    }

    public static class ComGoogleApiClientGoogleApiVersionAccessors extends VersionFactory  {

        public ComGoogleApiClientGoogleApiVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.google.api.client.google.api.client</b> with value <b>1.32.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getClient() { return getVersion("com.google.api.client.google.api.client"); }

    }

    public static class ComGoogleCodeVersionAccessors extends VersionFactory  {

        private final ComGoogleCodeGsonVersionAccessors vaccForComGoogleCodeGsonVersionAccessors = new ComGoogleCodeGsonVersionAccessors(providers, config);
        public ComGoogleCodeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google.code.gson</b>
         */
        public ComGoogleCodeGsonVersionAccessors getGson() {
            return vaccForComGoogleCodeGsonVersionAccessors;
        }

    }

    public static class ComGoogleCodeGsonVersionAccessors extends VersionFactory  {

        public ComGoogleCodeGsonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.google.code.gson.gson</b> with value <b>2.10.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getGson() { return getVersion("com.google.code.gson.gson"); }

    }

    public static class ComGoogleOauthVersionAccessors extends VersionFactory  {

        private final ComGoogleOauthClientVersionAccessors vaccForComGoogleOauthClientVersionAccessors = new ComGoogleOauthClientVersionAccessors(providers, config);
        public ComGoogleOauthVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google.oauth.client</b>
         */
        public ComGoogleOauthClientVersionAccessors getClient() {
            return vaccForComGoogleOauthClientVersionAccessors;
        }

    }

    public static class ComGoogleOauthClientVersionAccessors extends VersionFactory  {

        private final ComGoogleOauthClientGoogleVersionAccessors vaccForComGoogleOauthClientGoogleVersionAccessors = new ComGoogleOauthClientGoogleVersionAccessors(providers, config);
        public ComGoogleOauthClientVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google.oauth.client.google</b>
         */
        public ComGoogleOauthClientGoogleVersionAccessors getGoogle() {
            return vaccForComGoogleOauthClientGoogleVersionAccessors;
        }

    }

    public static class ComGoogleOauthClientGoogleVersionAccessors extends VersionFactory  {

        private final ComGoogleOauthClientGoogleOauthVersionAccessors vaccForComGoogleOauthClientGoogleOauthVersionAccessors = new ComGoogleOauthClientGoogleOauthVersionAccessors(providers, config);
        public ComGoogleOauthClientGoogleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google.oauth.client.google.oauth</b>
         */
        public ComGoogleOauthClientGoogleOauthVersionAccessors getOauth() {
            return vaccForComGoogleOauthClientGoogleOauthVersionAccessors;
        }

    }

    public static class ComGoogleOauthClientGoogleOauthVersionAccessors extends VersionFactory  {

        private final ComGoogleOauthClientGoogleOauthClientVersionAccessors vaccForComGoogleOauthClientGoogleOauthClientVersionAccessors = new ComGoogleOauthClientGoogleOauthClientVersionAccessors(providers, config);
        public ComGoogleOauthClientGoogleOauthVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google.oauth.client.google.oauth.client</b>
         */
        public ComGoogleOauthClientGoogleOauthClientVersionAccessors getClient() {
            return vaccForComGoogleOauthClientGoogleOauthClientVersionAccessors;
        }

    }

    public static class ComGoogleOauthClientGoogleOauthClientVersionAccessors extends VersionFactory  {

        public ComGoogleOauthClientGoogleOauthClientVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.google.oauth.client.google.oauth.client.jetty</b> with value <b>1.32.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJetty() { return getVersion("com.google.oauth.client.google.oauth.client.jetty"); }

    }

    public static class ComSunVersionAccessors extends VersionFactory  {

        private final ComSunMailVersionAccessors vaccForComSunMailVersionAccessors = new ComSunMailVersionAccessors(providers, config);
        public ComSunVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.sun.mail</b>
         */
        public ComSunMailVersionAccessors getMail() {
            return vaccForComSunMailVersionAccessors;
        }

    }

    public static class ComSunMailVersionAccessors extends VersionFactory  {

        private final ComSunMailJakartaVersionAccessors vaccForComSunMailJakartaVersionAccessors = new ComSunMailJakartaVersionAccessors(providers, config);
        public ComSunMailVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.sun.mail.jakarta</b>
         */
        public ComSunMailJakartaVersionAccessors getJakarta() {
            return vaccForComSunMailJakartaVersionAccessors;
        }

    }

    public static class ComSunMailJakartaVersionAccessors extends VersionFactory  {

        public ComSunMailJakartaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.sun.mail.jakarta.mail</b> with value <b>1.6.7</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMail() { return getVersion("com.sun.mail.jakarta.mail"); }

    }

    public static class CommonsVersionAccessors extends VersionFactory  {

        private final CommonsFileuploadVersionAccessors vaccForCommonsFileuploadVersionAccessors = new CommonsFileuploadVersionAccessors(providers, config);
        private final CommonsIoVersionAccessors vaccForCommonsIoVersionAccessors = new CommonsIoVersionAccessors(providers, config);
        public CommonsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.commons.fileupload</b>
         */
        public CommonsFileuploadVersionAccessors getFileupload() {
            return vaccForCommonsFileuploadVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.commons.io</b>
         */
        public CommonsIoVersionAccessors getIo() {
            return vaccForCommonsIoVersionAccessors;
        }

    }

    public static class CommonsFileuploadVersionAccessors extends VersionFactory  {

        private final CommonsFileuploadCommonsVersionAccessors vaccForCommonsFileuploadCommonsVersionAccessors = new CommonsFileuploadCommonsVersionAccessors(providers, config);
        public CommonsFileuploadVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.commons.fileupload.commons</b>
         */
        public CommonsFileuploadCommonsVersionAccessors getCommons() {
            return vaccForCommonsFileuploadCommonsVersionAccessors;
        }

    }

    public static class CommonsFileuploadCommonsVersionAccessors extends VersionFactory  {

        public CommonsFileuploadCommonsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>commons.fileupload.commons.fileupload</b> with value <b>1.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getFileupload() { return getVersion("commons.fileupload.commons.fileupload"); }

    }

    public static class CommonsIoVersionAccessors extends VersionFactory  {

        private final CommonsIoCommonsVersionAccessors vaccForCommonsIoCommonsVersionAccessors = new CommonsIoCommonsVersionAccessors(providers, config);
        public CommonsIoVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.commons.io.commons</b>
         */
        public CommonsIoCommonsVersionAccessors getCommons() {
            return vaccForCommonsIoCommonsVersionAccessors;
        }

    }

    public static class CommonsIoCommonsVersionAccessors extends VersionFactory  {

        public CommonsIoCommonsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>commons.io.commons.io</b> with value <b>2.11.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getIo() { return getVersion("commons.io.commons.io"); }

    }

    public static class JavaxVersionAccessors extends VersionFactory  {

        private final JavaxMailVersionAccessors vaccForJavaxMailVersionAccessors = new JavaxMailVersionAccessors(providers, config);
        private final JavaxServletVersionAccessors vaccForJavaxServletVersionAccessors = new JavaxServletVersionAccessors(providers, config);
        public JavaxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.javax.mail</b>
         */
        public JavaxMailVersionAccessors getMail() {
            return vaccForJavaxMailVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.javax.servlet</b>
         */
        public JavaxServletVersionAccessors getServlet() {
            return vaccForJavaxServletVersionAccessors;
        }

    }

    public static class JavaxMailVersionAccessors extends VersionFactory  {

        public JavaxMailVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>javax.mail.mail</b> with value <b>1.4.7</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMail() { return getVersion("javax.mail.mail"); }

    }

    public static class JavaxServletVersionAccessors extends VersionFactory  {

        private final JavaxServletJavaxVersionAccessors vaccForJavaxServletJavaxVersionAccessors = new JavaxServletJavaxVersionAccessors(providers, config);
        private final JavaxServletJspVersionAccessors vaccForJavaxServletJspVersionAccessors = new JavaxServletJspVersionAccessors(providers, config);
        public JavaxServletVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>javax.servlet.jstl</b> with value <b>1.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJstl() { return getVersion("javax.servlet.jstl"); }

        /**
         * Group of versions at <b>versions.javax.servlet.javax</b>
         */
        public JavaxServletJavaxVersionAccessors getJavax() {
            return vaccForJavaxServletJavaxVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.javax.servlet.jsp</b>
         */
        public JavaxServletJspVersionAccessors getJsp() {
            return vaccForJavaxServletJspVersionAccessors;
        }

    }

    public static class JavaxServletJavaxVersionAccessors extends VersionFactory  {

        private final JavaxServletJavaxServletVersionAccessors vaccForJavaxServletJavaxServletVersionAccessors = new JavaxServletJavaxServletVersionAccessors(providers, config);
        public JavaxServletJavaxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.javax.servlet.javax.servlet</b>
         */
        public JavaxServletJavaxServletVersionAccessors getServlet() {
            return vaccForJavaxServletJavaxServletVersionAccessors;
        }

    }

    public static class JavaxServletJavaxServletVersionAccessors extends VersionFactory  {

        public JavaxServletJavaxServletVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>javax.servlet.javax.servlet.api</b> with value <b>3.1.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getApi() { return getVersion("javax.servlet.javax.servlet.api"); }

    }

    public static class JavaxServletJspVersionAccessors extends VersionFactory  {

        public JavaxServletJspVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>javax.servlet.jsp.api</b> with value <b>2.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getApi() { return getVersion("javax.servlet.jsp.api"); }

    }

    public static class JunitVersionAccessors extends VersionFactory  {

        public JunitVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>junit.junit</b> with value <b>3.8.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJunit() { return getVersion("junit.junit"); }

    }

    public static class MysqlVersionAccessors extends VersionFactory  {

        private final MysqlMysqlVersionAccessors vaccForMysqlMysqlVersionAccessors = new MysqlMysqlVersionAccessors(providers, config);
        public MysqlVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.mysql.mysql</b>
         */
        public MysqlMysqlVersionAccessors getMysql() {
            return vaccForMysqlMysqlVersionAccessors;
        }

    }

    public static class MysqlMysqlVersionAccessors extends VersionFactory  {

        private final MysqlMysqlConnectorVersionAccessors vaccForMysqlMysqlConnectorVersionAccessors = new MysqlMysqlConnectorVersionAccessors(providers, config);
        public MysqlMysqlVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.mysql.mysql.connector</b>
         */
        public MysqlMysqlConnectorVersionAccessors getConnector() {
            return vaccForMysqlMysqlConnectorVersionAccessors;
        }

    }

    public static class MysqlMysqlConnectorVersionAccessors extends VersionFactory  {

        public MysqlMysqlConnectorVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>mysql.mysql.connector.java</b> with value <b>8.0.30</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJava() { return getVersion("mysql.mysql.connector.java"); }

    }

    public static class OrgVersionAccessors extends VersionFactory  {

        private final OrgApacheVersionAccessors vaccForOrgApacheVersionAccessors = new OrgApacheVersionAccessors(providers, config);
        private final OrgJdbiVersionAccessors vaccForOrgJdbiVersionAccessors = new OrgJdbiVersionAccessors(providers, config);
        private final OrgSlf4jVersionAccessors vaccForOrgSlf4jVersionAccessors = new OrgSlf4jVersionAccessors(providers, config);
        public OrgVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache</b>
         */
        public OrgApacheVersionAccessors getApache() {
            return vaccForOrgApacheVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.jdbi</b>
         */
        public OrgJdbiVersionAccessors getJdbi() {
            return vaccForOrgJdbiVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.slf4j</b>
         */
        public OrgSlf4jVersionAccessors getSlf4j() {
            return vaccForOrgSlf4jVersionAccessors;
        }

    }

    public static class OrgApacheVersionAccessors extends VersionFactory  {

        private final OrgApacheHttpcomponentsVersionAccessors vaccForOrgApacheHttpcomponentsVersionAccessors = new OrgApacheHttpcomponentsVersionAccessors(providers, config);
        public OrgApacheVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.httpcomponents</b>
         */
        public OrgApacheHttpcomponentsVersionAccessors getHttpcomponents() {
            return vaccForOrgApacheHttpcomponentsVersionAccessors;
        }

    }

    public static class OrgApacheHttpcomponentsVersionAccessors extends VersionFactory  {

        private final OrgApacheHttpcomponentsFluentVersionAccessors vaccForOrgApacheHttpcomponentsFluentVersionAccessors = new OrgApacheHttpcomponentsFluentVersionAccessors(providers, config);
        public OrgApacheHttpcomponentsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.httpcomponents.fluent</b>
         */
        public OrgApacheHttpcomponentsFluentVersionAccessors getFluent() {
            return vaccForOrgApacheHttpcomponentsFluentVersionAccessors;
        }

    }

    public static class OrgApacheHttpcomponentsFluentVersionAccessors extends VersionFactory  {

        public OrgApacheHttpcomponentsFluentVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.apache.httpcomponents.fluent.hc</b> with value <b>4.5.14</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getHc() { return getVersion("org.apache.httpcomponents.fluent.hc"); }

    }

    public static class OrgJdbiVersionAccessors extends VersionFactory  {

        private final OrgJdbiJdbi3VersionAccessors vaccForOrgJdbiJdbi3VersionAccessors = new OrgJdbiJdbi3VersionAccessors(providers, config);
        public OrgJdbiVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.jdbi.jdbi3</b>
         */
        public OrgJdbiJdbi3VersionAccessors getJdbi3() {
            return vaccForOrgJdbiJdbi3VersionAccessors;
        }

    }

    public static class OrgJdbiJdbi3VersionAccessors extends VersionFactory  {

        public OrgJdbiJdbi3VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.jdbi.jdbi3.core</b> with value <b>3.34.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCore() { return getVersion("org.jdbi.jdbi3.core"); }

        /**
         * Version alias <b>org.jdbi.jdbi3.sqlobject</b> with value <b>3.34.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSqlobject() { return getVersion("org.jdbi.jdbi3.sqlobject"); }

    }

    public static class OrgSlf4jVersionAccessors extends VersionFactory  {

        private final OrgSlf4jSlf4jVersionAccessors vaccForOrgSlf4jSlf4jVersionAccessors = new OrgSlf4jSlf4jVersionAccessors(providers, config);
        public OrgSlf4jVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.slf4j.slf4j</b>
         */
        public OrgSlf4jSlf4jVersionAccessors getSlf4j() {
            return vaccForOrgSlf4jSlf4jVersionAccessors;
        }

    }

    public static class OrgSlf4jSlf4jVersionAccessors extends VersionFactory  {

        public OrgSlf4jSlf4jVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.slf4j.slf4j.api</b> with value <b>1.7.5</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getApi() { return getVersion("org.slf4j.slf4j.api"); }

        /**
         * Version alias <b>org.slf4j.slf4j.log4j12</b> with value <b>1.7.5</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLog4j12() { return getVersion("org.slf4j.slf4j.log4j12"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
