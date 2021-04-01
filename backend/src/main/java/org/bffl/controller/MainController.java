package org.bffl.controller;

import org.bffl.dbConnector.dao.model.Target_url;
import org.bffl.dbConnector.services.AppService;
import org.bffl.iamConnector.iamConfig.CustomKeycloakConfigResolver;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "https://bfflshort.de"}, maxAge = 3600L)
@RestController
@RequestMapping(value="/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class MainController {

    //controller für die WebApp

    @Autowired
    private AppService app_Service;

    @GetMapping("/target_urls")
    public ResponseEntity<List<Target_url>> getAllTargetURLs(HttpServletResponse response, Principal principal) {
        System.out.println(response.getHeader("Authorization"));
        KeycloakAuthenticationToken keycloakAuthenticationToken = (KeycloakAuthenticationToken) principal;
        AccessToken accessToken = keycloakAuthenticationToken.getAccount().getKeycloakSecurityContext().getToken();
        System.out.println(accessToken.getSubject());
        return app_Service.findAllTarget_urls();
    }

}
