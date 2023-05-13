package DefaultNamespace;

public class DictionaryServiceProxy implements DefaultNamespace.DictionaryService {
  private String _endpoint = null;
  private DefaultNamespace.DictionaryService dictionaryService = null;
  
  public DictionaryServiceProxy() {
    _initDictionaryServiceProxy();
  }
  
  public DictionaryServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initDictionaryServiceProxy();
  }
  
  private void _initDictionaryServiceProxy() {
    try {
      dictionaryService = (new DefaultNamespace.DictionaryServiceServiceLocator()).getDictionaryService();
      if (dictionaryService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)dictionaryService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)dictionaryService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (dictionaryService != null)
      ((javax.xml.rpc.Stub)dictionaryService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public DefaultNamespace.DictionaryService getDictionaryService() {
    if (dictionaryService == null)
      _initDictionaryServiceProxy();
    return dictionaryService;
  }
  
  public java.lang.String add(java.lang.String english, java.lang.String vietnamese) throws java.rmi.RemoteException{
    if (dictionaryService == null)
      _initDictionaryServiceProxy();
    return dictionaryService.add(english, vietnamese);
  }
  
  public java.lang.String lookup(java.lang.String word) throws java.rmi.RemoteException{
    if (dictionaryService == null)
      _initDictionaryServiceProxy();
    return dictionaryService.lookup(word);
  }
  
  public java.lang.String delete(java.lang.String deleteWord) throws java.rmi.RemoteException{
    if (dictionaryService == null)
      _initDictionaryServiceProxy();
    return dictionaryService.delete(deleteWord);
  }
  
  public java.lang.String maxWord() throws java.rmi.RemoteException{
    if (dictionaryService == null)
      _initDictionaryServiceProxy();
    return dictionaryService.maxWord();
  }
  
  
}