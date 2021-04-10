package org.bffl.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiControllerTest {

    @Test
    public void createController() {
        ApiController controller;
        controller = new ApiController();

        assertNotNull(controller);
    }
}