package com.reliantcomputing.mtcapply.constants;

public class SecurityConstants {
    public static final String AUTH_LOGIN_URL = "/auth";
    public static final String AUTH_REFRESH_TOKEN_URL = "/refresh";

    // Signing key for HS512 algorithm
    // You can use the page http://www.allkeysgenerator.com/ to generate all kinds of keys
    public static final String JWT_SECRET = "n2r5u8x/A%D*G-KaPdSgVkYp3s6v9y$B&E(H+MbQeThWmZq4t7w!z%C*F-J@NcRf";

    // JWT token defaults
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_ISSUER = "secure-api";
    public static final String TOKEN_AUDIENCE = "secure-app";

    public static final long TOKEN_EXPIRY_TIME = 604800;
    public static final long TOKEN_VALIDITY_IN_MILLISECONDS = 86400;
    public static final long TOKEN_VALIDITY_IN_MILLISECONDS_FOR_REMEMBER_ME = 108000;

    private SecurityConstants() {
        throw new IllegalStateException("Cannot create instance of static util class");
    }
}
