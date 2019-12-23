<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<title>Login</title>
</head>
<body>
	<form action = "LoginServlet" method = "POST">
  <div class="form-group" >
    <label for="exampleInputEmail1">USUÁRIO</label>
    <input type="text" class="form-control" name = "usuario" id="usuario">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">SENHA</label>
    <input type="password" name = "senha" class="form-control" id="senha" placeholder="Password">
  </div>

  </div>
  <button type="submit" class="btn btn-primary">ENTRAR</button>
</form>

</body>
</html>