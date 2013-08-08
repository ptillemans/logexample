package com.melexis.example.logexample;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Example to test support for commons logging.
 *
 * Although slf4j is the recommended logging API for new developments, there
 * are still libraries written against legacy frameworks.
 *
 * This servlet tests commons logging support.
 *
 * Note that the logger is not statically initialised as customary, but
 * dynamically in the doGet method to avoid deploy difficulties.
 */
public class LegacyCommonsLoggingServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Log logger = LogFactory.getLog(LegacyCommonsLoggingServlet.class);
        String id = req.getParameter("id");
        logger.info("Entering commons logging servlet with id " + id);
        Writer out = resp.getWriter();
        out.write("Hello, commons logging stranger");
        logger.info("Leaving commons logging servlet with id " + id);
    }

}
