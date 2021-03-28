package org.bffl.dbConnector.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class ApiService {

    public ResponseEntity<HttpStatus> redirectToTargetURL(HttpServletResponse response, String groupID, String shortUrlID) throws IOException {
        response.sendRedirect("https://google.de");
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
