/*
 * Copyright: 2016, Atos.
 */
package net.atos.spring.training.example13;

import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Simple controller for Spring MVC Hello World example.
 * 
 * The @Controller annotation indicates that a particular class serves the role
 * of a controller. Spring does not require you to extend any controller base
 * class or reference the Servlet API. However, you can still reference
 * Servlet-specific features if you need to.
 * 
 * @author Rupesh Deshmukh
 */
@Controller
public class HelloWorldController {

    /**
     * Request mapping method of /hello URI.
     * 
     * The @RequestMapping is a annotation for mapping web requests onto
     * specific handler classes and/or handler methods.
     * 
     * @param locale
     *            <code>java.util.Locale</code>.
     * @param model
     *            <code>org.springframework.ui.Model</code>.
     * @return String url to which control will be redirected.
     */
    @RequestMapping("/hello")
    public String printMessage(final Locale locale, final Model model) {

        final String message = "Welcome to Spring MVC World";
        model.addAttribute("message", message);

        final Date currentDate = new Date();
        final DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        final String formattedDate = dateFormat.format(currentDate);

        model.addAttribute("serverTime", formattedDate);

        return "helloWorld";
    }

    /**
     * Request mapping method of /color.
     * 
     * The @RequestParam annotated parameters for access to specific Servlet
     * request parameters. Parameter values are converted to the declared method
     * argument type.
     * 
     * @param model
     *            <code>org.springframework.ui.Model</code>.
     * @param userColorSelection
     *            String request parameter.
     * @return String url to which control will be redirected.
     */
    @RequestMapping("/color")
    public String displayColor(final Model model, @RequestParam(name = "userColorSelection", defaultValue = "blue") final String userColorSelection) {

        model.addAttribute("userColorSelection", userColorSelection);

        return "colorSelection";
    }

    /**
     * Request mapping method of /document/{id}.
     * 
     * The @PathVariable annotated parameters for access to URI template
     * variables.
     * 
     * The @MatrixVariable annotated parameters for access to name-value pairs
     * located in URI path segments.
     * 
     * @param response
     *            <code>javax.servlet.http.HttpServletResponse</code>.
     * @param documentId
     *            String path variable.
     * @param edition
     *            int.
     * @throws IOException
     */
    @RequestMapping("/document/{documentId}")
    public void displayDocument(final HttpServletResponse response, @PathVariable(value = "documentId") final String documentId,
                                @MatrixVariable final int edition) throws IOException {

        if (!StringUtils.isEmpty(documentId) && documentId.equals("100")) {
            Resource resource = null;

            if (edition == 2) {
                resource = new ClassPathResource("Spring in Action 2nd Edition.pdf");
            } else if (edition == 3) {
                resource = new ClassPathResource("Spring in Action 3rd Edition.pdf");
            }

            if (resource != null && resource.exists()) {
                final File pdfFile = resource.getFile();
                response.setContentType(URLConnection.guessContentTypeFromName(pdfFile.getName()));
                response.setContentLength((int) pdfFile.length());
                response.setHeader("Content-Disposition", String.format("inline; filename=\"" + pdfFile.getName() + "\""));

                FileCopyUtils.copy(resource.getInputStream(), response.getOutputStream());
            }
        }
    }

    /**
     * Request mapping method for /viewHttpHeaderDetails.
     * 
     * The @RequestHeader annotated parameters for access to specific Servlet
     * request HTTP headers. Parameter values are converted to the declared
     * method argument type.
     * 
     * @param model
     *            <code>org.springframework.ui.Model</code>.
     * @param httpHeaders
     *            <code>org.springframework.http.HttpHeaders</code>.
     */
    @RequestMapping("/viewHttpHeaderDetails")
    public String displayRequestHeaders(final Model model, @RequestHeader final HttpHeaders httpHeaders) {

        final StringBuilder sb = new StringBuilder();
        sb.append("Host: " + httpHeaders.get("host") + "<br />");
        sb.append("Accept: " + httpHeaders.get("Accept") + "<br />");
        sb.append("Accept Language: " + httpHeaders.get("Accept-Language") + "<br />");
        sb.append("Accept Encoding: " + httpHeaders.get("Accept-Encoding") + "<br />");
        sb.append("Cache Control: " + httpHeaders.get("Cache-Control") + "<br />");
        sb.append("Cookie: " + httpHeaders.get("Cookie") + "<br />");
        sb.append("User Agent: " + httpHeaders.get("User-Agent"));

        model.addAttribute("httpHeaderDetails", sb.toString());

        return "viewHeader";
    }

    /**
     * Request mapping method for /viewJsonFormat.
     * 
     * The @ResponseBody annotation is used to convert the given object in JSON
     * format.
     * 
     * @return employee <code>net.atos.spring.training.example13.Employee</code>
     *         in JSON format.
     */
    @RequestMapping(value = "/viewJsonFormat")
    public @ResponseBody Employee displayEmployeeDetails() {

        final Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("Rupesh");
        employee.setLastName("Deshmukh");
        employee.setSalaryCode(2530);

        return employee;
    }
}
