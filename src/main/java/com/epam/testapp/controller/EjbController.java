package com.epam.testapp.controller;

import com.epam.ejb.model.News;
import com.epam.ejb.service.EjbServiceRemote;
import com.epam.ejb.service.EjbWebService;
import com.epam.testapp.exception.ControllerException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import static com.epam.testapp.constant.ConstantHolder.NEWS_ATTRIBUTE;

@Controller
public class EjbController {

    private static final String EJB_SERVICE_REMOTE = "EjbServer/EjbService!com.epam.ejb.service.EjbServiceRemote";
    private static final String EJB_VIEW_NAME = "ejb";
    private static final String NAMING_REMOTE_CLIENT_INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
    private static final String HTTP_REMOTING_HOST = "http-remoting://localhost:8082";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";
    private static final String NAMING_CLIENT_EJB_CONTEXT = "jboss.naming.client.ejb.context";
    private static final String HOST_EJB_SERVICE = "http://localhost:8082/EjbServer/EjbService";
    private static final String NAMESPACE_URI = "http://www.epam.com/";
    private static final String EJB_SERVICE = "EjbServiceService";
    private static final String WSDL_SUFFIX = "?wsdl";

    @RequestMapping(value = "/ejb", method = RequestMethod.GET)
    public ModelAndView ejbInvokeRemoteInterface() throws ControllerException {

        List<News> newsList;
        Context ctx = null;
        try {
            ctx = getContext();
            EjbServiceRemote<News> ejbServiceRemote = (EjbServiceRemote) ctx.lookup(EJB_SERVICE_REMOTE);
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

        return new ModelAndView(EJB_VIEW_NAME, NEWS_ATTRIBUTE, newsList);
    }

    private Context getContext() throws NamingException, ControllerException {

        Properties jndiProps = new Properties();
        try {
            jndiProps.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("jndi.properties"));
        } catch (IOException e) {
            throw new ControllerException(e);
        }

        return new InitialContext(jndiProps);
    }

    @RequestMapping(value = "/ejbWebService", method = RequestMethod.GET)
    public ModelAndView ejbInvokeRemoteWebService() throws ControllerException {

        QName serviceName = new QName(NAMESPACE_URI, EJB_SERVICE);
        URL wsdlURL;
        try {
            wsdlURL = new URL(HOST_EJB_SERVICE + WSDL_SUFFIX);
        } catch (MalformedURLException e) {
            throw new ControllerException(e);
        }
        Service service = Service.create(wsdlURL, serviceName);
        EjbWebService proxy = service.getPort(EjbWebService.class);
        List<News> newsList = proxy.getAll();

        return new ModelAndView(EJB_VIEW_NAME, NEWS_ATTRIBUTE, newsList);
    }
}
