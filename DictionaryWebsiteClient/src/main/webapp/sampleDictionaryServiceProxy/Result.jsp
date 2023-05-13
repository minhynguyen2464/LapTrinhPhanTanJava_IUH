<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleDictionaryServiceProxyid" scope="session" class="DefaultNamespace.DictionaryServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleDictionaryServiceProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleDictionaryServiceProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleDictionaryServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        DefaultNamespace.DictionaryService getDictionaryService10mtemp = sampleDictionaryServiceProxyid.getDictionaryService();
if(getDictionaryService10mtemp == null){
%>
<%=getDictionaryService10mtemp %>
<%
}else{
        if(getDictionaryService10mtemp!= null){
        String tempreturnp11 = getDictionaryService10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String english_1id=  request.getParameter("english16");
            java.lang.String english_1idTemp = null;
        if(!english_1id.equals("")){
         english_1idTemp  = english_1id;
        }
        String vietnamese_2id=  request.getParameter("vietnamese18");
            java.lang.String vietnamese_2idTemp = null;
        if(!vietnamese_2id.equals("")){
         vietnamese_2idTemp  = vietnamese_2id;
        }
        java.lang.String add13mtemp = sampleDictionaryServiceProxyid.add(english_1idTemp,vietnamese_2idTemp);
if(add13mtemp == null){
%>
<%=add13mtemp %>
<%
}else{
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(add13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
}
break;
case 20:
        gotMethod = true;
        String word_3id=  request.getParameter("word23");
            java.lang.String word_3idTemp = null;
        if(!word_3id.equals("")){
         word_3idTemp  = word_3id;
        }
        java.lang.String lookup20mtemp = sampleDictionaryServiceProxyid.lookup(word_3idTemp);
if(lookup20mtemp == null){
%>
<%=lookup20mtemp %>
<%
}else{
        String tempResultreturnp21 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(lookup20mtemp));
        %>
        <%= tempResultreturnp21 %>
        <%
}
break;
case 25:
        gotMethod = true;
        String deleteWord_4id=  request.getParameter("deleteWord28");
            java.lang.String deleteWord_4idTemp = null;
        if(!deleteWord_4id.equals("")){
         deleteWord_4idTemp  = deleteWord_4id;
        }
        java.lang.String delete25mtemp = sampleDictionaryServiceProxyid.delete(deleteWord_4idTemp);
if(delete25mtemp == null){
%>
<%=delete25mtemp %>
<%
}else{
        String tempResultreturnp26 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(delete25mtemp));
        %>
        <%= tempResultreturnp26 %>
        <%
}
break;
case 30:
        gotMethod = true;
        java.lang.String maxWord30mtemp = sampleDictionaryServiceProxyid.maxWord();
if(maxWord30mtemp == null){
%>
<%=maxWord30mtemp %>
<%
}else{
        String tempResultreturnp31 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(maxWord30mtemp));
        %>
        <%= tempResultreturnp31 %>
        <%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>