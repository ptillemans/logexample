package com.melexis.example.logexample;

import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Example to test support for java.util.logging.
 *
 * Although slf4j is the recommended logging API for new developments, there
 * are still libraries written against legacy frameworks.
 *
 * This servlet tests java.util.logging support.
 *
 * Note that the logger is not statically initialised as customary, but
 * dynamically in the doGet method to avoid deploy difficulties.
 */
public class LegacyJulServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger logger = Logger.getLogger(LegacyJulServlet.class.getName());
        String id = req.getParameter("id");
        logger.info("Entering java.util.logging servlet with id " + id);
        Writer out = resp.getWriter();
        out.write("Hello, java.util.logging stranger");
        logger.info("Leaving java.util.logging servlet with id " + id);
    }

}
