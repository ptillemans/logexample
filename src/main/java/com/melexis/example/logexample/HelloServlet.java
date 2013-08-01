package com.melexis.example.logexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Created with IntelliJ IDEA.
 * User: pti
 * Date: 8/1/13
 * Time: 2:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class HelloServlet extends HttpServlet {

    Logger logger = LoggerFactory.getLogger(HelloServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Entering hello servlet");
        Writer out = resp.getWriter();
        out.write("Hello, stranger");
        logger.info("Leaving hello servlet");
    }
}
