package com.epam.testapp.controller;

import com.epam.ejb.model.News;
import com.epam.ejb.service.EjbServiceRemote;
import com.epam.ejb.service.EjbWebService;
import com.epam.testapp.exception.ControllerException;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;

@Controller
public class EjbController {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger("EjbController");

    @RequestMapping(value = "/ejb", method = RequestMethod.GET)
    public ModelAndView ejbInvokeRemoteInterface() throws ControllerException {

        List<News> newsList;
        Context ctx = null;
        try {
            ctx = getContext();
            EjbServiceRemote<News> ejbServiceRemote = (EjbServiceRemote) ctx.lookup("EjbServer/EjbService!com.epam.ejb.service.EjbServiceRemote");
            newsList = ejbServiceRemote.getAll();
        } catch (NamingException e) {
            throw new ControllerException(e);
        } finally {
            try {
                if (ctx != null)
                    ctx.close();
            } catch (NamingException e) {
                throw new ControllerException(e);
            }
        }

        return new ModelAndView("ejb", "news", newsList);
    }

    private Context getContext() throws NamingException {

        Properties jndiProps = new Properties();
        jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        jndiProps.put(Context.PROVIDER_URL, "http-remoting://localhost:8082");
        jndiProps.put(Context.SECURITY_PRINCIPAL, "admin");
        jndiProps.put(Context.SECURITY_CREDENTIALS, "admin");
        jndiProps.put("jboss.naming.client.ejb.context", true);
        return new InitialContext(jndiProps);
    }

    @RequestMapping(value = "/ejbWebService", method = RequestMethod.GET)
    public ModelAndView ejbInvokeRemoteWebService() throws ControllerException {

        String endPointAddress = "http://localhost:8082/EjbServer/EjbService";
        QName serviceName = new QName("http://www.epam.com/", "EjbServiceService");
        URL wsdlURL;
        try {
            wsdlURL = new URL(endPointAddress + "?wsdl");
        } catch (MalformedURLException e) {
            throw new ControllerException(e);
        }
        Service service = Service.create(wsdlURL, serviceName);
        EjbWebService proxy = service.getPort(EjbWebService.class);
        List<News> newsList = proxy.getAll();
        log.debug("NEWS LIST = {}", newsList);

        return new ModelAndView("ejb", "news", newsList);
    }
}
