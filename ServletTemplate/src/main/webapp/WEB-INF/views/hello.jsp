<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <title>Hello from JSP</title>
  </head>
  <body>
    Hello from JSP! Привет, ${name}.
    <form action="/servlet-template/age" method="post">
      Enter your age :
      <input type="text" name="age"/>
      <input type="submit">
    </form>
  </body>
</html>