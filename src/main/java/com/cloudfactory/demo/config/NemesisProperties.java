package com.cloudfactory.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.cors.CorsConfiguration;

@ConfigurationProperties(
        prefix = "nemesis",
        ignoreUnknownFields = false
)
@PropertySources({@PropertySource(
        value = {"classpath:git.properties"},
        ignoreResourceNotFound = true
), @PropertySource(
        value = {"classpath:META-INF/build-info.properties"},
        ignoreResourceNotFound = true
)})
public class NemesisProperties {

    private final NemesisProperties.Async async = new NemesisProperties.Async();
    private final NemesisProperties.Security security = new NemesisProperties.Security();
    private final CorsConfiguration cors = new CorsConfiguration();

    public NemesisProperties() {
    }

    public NemesisProperties.Async getAsync() {
        return this.async;
    }
    public NemesisProperties.Security getSecurity() {
        return this.security;
    }
    public CorsConfiguration getCors() {
        return this.cors;
    }

    public static class Security {
        private final NemesisProperties.Security.Authentication authentication = new NemesisProperties.Security.Authentication();

        public Security() {
        }

        public NemesisProperties.Security.Authentication getAuthentication() {
            return this.authentication;
        }

        public static class Authentication {
            private final NemesisProperties.Security.Authentication.Jwt jwt = new NemesisProperties.Security.Authentication.Jwt();

            public Authentication() {
            }

            public NemesisProperties.Security.Authentication.Jwt getJwt() {
                return this.jwt;
            }

            public static class Jwt {
                private String secret;
                private String base64Secret;
                private long tokenValidityInSeconds;
                private long tokenValidityInSecondsForRememberMe;

                public Jwt() {
                    this.tokenValidityInSeconds = 1800L;
                    this.tokenValidityInSecondsForRememberMe = 2592000L;
                }

                public String getSecret() {
                    return this.secret;
                }

                public void setSecret(String secret) {
                    this.secret = secret;
                }

                public String getBase64Secret() {
                    return this.base64Secret;
                }

                public void setBase64Secret(String base64Secret) {
                    this.base64Secret = base64Secret;
                }

                public long getTokenValidityInSeconds() {
                    return this.tokenValidityInSeconds;
                }

                public void setTokenValidityInSeconds(long tokenValidityInSeconds) {
                    this.tokenValidityInSeconds = tokenValidityInSeconds;
                }

                public long getTokenValidityInSecondsForRememberMe() {
                    return this.tokenValidityInSecondsForRememberMe;
                }

                public void setTokenValidityInSecondsForRememberMe(long tokenValidityInSecondsForRememberMe) {
                    this.tokenValidityInSecondsForRememberMe = tokenValidityInSecondsForRememberMe;
                }
            }
        }
    }

    public static class Async {
        private int corePoolSize = 2;
        private int maxPoolSize = 50;
        private int queueCapacity = 10000;

        public Async() {
        }

        public int getCorePoolSize() {
            return this.corePoolSize;
        }

        public void setCorePoolSize(int corePoolSize) {
            this.corePoolSize = corePoolSize;
        }

        public int getMaxPoolSize() {
            return this.maxPoolSize;
        }

        public void setMaxPoolSize(int maxPoolSize) {
            this.maxPoolSize = maxPoolSize;
        }

        public int getQueueCapacity() {
            return this.queueCapacity;
        }

        public void setQueueCapacity(int queueCapacity) {
            this.queueCapacity = queueCapacity;
        }
    }


}