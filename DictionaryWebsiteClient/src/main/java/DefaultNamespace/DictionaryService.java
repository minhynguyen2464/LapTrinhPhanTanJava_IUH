/**
 * DictionaryService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

public interface DictionaryService extends java.rmi.Remote {
    public java.lang.String add(java.lang.String english, java.lang.String vietnamese) throws java.rmi.RemoteException;
    public java.lang.String lookup(java.lang.String word) throws java.rmi.RemoteException;
    public java.lang.String delete(java.lang.String deleteWord) throws java.rmi.RemoteException;
    public java.lang.String maxWord() throws java.rmi.RemoteException;
}
