package cl.smartjob.ejercicio.util;

public class CoreConstants {
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
    public static final String JWT_SECRET = "586E3272357538782F413F4428472B4B6250655368566B597033733676397924";
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String AUTHORIZATION_HEADER_BEARER = "Bearer ";
    public static final String DATE_FORMAT_DD_MM_YYYY_HH_MM_SS = "dd-MM-yyyy HH:mm:ss";
    public static final String RGX_EMAIL = "^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@(dominio)+(.)+(cl)$";
    public static final String[] PUBLIC_RESOURCES = {"/swagger-ui/**", "/.well-known/**", "/v3/api-docs/**", "/auth/**"};
}
