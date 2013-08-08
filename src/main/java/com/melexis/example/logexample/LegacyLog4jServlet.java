package com.melexis.example.logexample;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Example to test support for log4j.
 *
 * Although slf4j is the recommended logging API for new developments, there
 * are still libraries written against legacy frameworks.
 *
 * This servlet tests log4j support.
 *
 * Note that the logger is not statically initialised as customary, but
 * dynamically in the doGet method to avoid deploy difficulties.
 */
public class LegacyLog4jServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger logger = Logger.getLogger(LegacyLog4jServlet.class);
        String id = req.getParameter("id");
        logger.info("Entering log4j servlet with id " + id);
        Writer out = resp.getWriter();
        out.write("Hello, log4j stranger");
        logger.info("Leaving log4j hello servlet with id " + id);
    }

}
