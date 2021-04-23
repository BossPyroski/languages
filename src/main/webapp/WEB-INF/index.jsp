<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello languages</h1>


<table class="table">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Creator</th>
      <th scope="col">version</th>
      <th scope="col">actions</th>
    </tr>
  </thead>
  <tbody>
  
  <c:forEach items='${allLang}' var="lang">
<tr> 

      <td><c:out value='${lang.name}'/> </td>
      <td><c:out value='${lang.creator}'/> </td>
      <td><c:out value='${lang.version}'/> </td>
      <td> <a href="/languages/edit/${lang.id}"> Edit</a>,<a href="/languages/${lang.id}/delete"> delete</a> <a href="/">update</a></td>
    
    </tr>
    </c:forEach>
  </tbody>
</table>

<h1>Add a New Language</h1>
<form:form action="/languages" method="post" modelAttribute="language">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>

    <p>
        <form:label path="creator">Creator</form:label>
        <form:errors path="creator"/>
        <form:input path="creator"/>
    </p>
    <p>
        <form:label path="version">Version</form:label>
        <form:errors path="version"/>     
        <form:input type="number" path="version"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>    

</body>
</html>