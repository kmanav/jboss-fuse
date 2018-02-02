package org.box.fuse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.5.redhat-630254
 * 2018-02-01T15:24:28.003+07:00
 * Generated source version: 3.1.5.redhat-630254
 * 
 */
@WebService(targetNamespace = "http://fuse.box.org/", name = "RegistrationPortType")
@XmlSeeAlso({ObjectFactory.class})
public interface RegistrationPortType {

    @WebMethod
    @RequestWrapper(localName = "addbook", targetNamespace = "http://fuse.box.org/", className = "org.box.fuse.Addbook")
    @ResponseWrapper(localName = "addbookResponse", targetNamespace = "http://fuse.box.org/", className = "org.box.fuse.AddbookResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String addbook(
        @WebParam(name = "arg0", targetNamespace = "http://fuse.box.org/")
        org.box.fuse.Book arg0
    );

    @WebMethod
    @RequestWrapper(localName = "unregister", targetNamespace = "http://fuse.box.org/", className = "org.box.fuse.Unregister")
    @ResponseWrapper(localName = "unregisterResponse", targetNamespace = "http://fuse.box.org/", className = "org.box.fuse.UnregisterResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String unregister(
        @WebParam(name = "arg0", targetNamespace = "http://fuse.box.org/")
        java.lang.String arg0
    );

    @WebMethod
    @RequestWrapper(localName = "register", targetNamespace = "http://fuse.box.org/", className = "org.box.fuse.Register")
    @ResponseWrapper(localName = "registerResponse", targetNamespace = "http://fuse.box.org/", className = "org.box.fuse.RegisterResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String register(
        @WebParam(name = "arg0", targetNamespace = "http://fuse.box.org/")
        org.box.fuse.Member arg0
    );
}