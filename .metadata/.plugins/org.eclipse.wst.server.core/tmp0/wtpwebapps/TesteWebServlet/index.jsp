<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action = "PessoaServlet" method = "POST">
	
	<fieldset>
	
	<legend>CADASTRO</legend>
	
			<label>Nome:</label><br>
			<input type = 'text' name="nome" id="nome"><br>
			
			<label>Idade:</label><br>
			<input type = 'text' name="idade" id="idade" ><br>
			
			<label>Salário:</label><br>
			<input  type='text' name="salario" id="salario" ><br><br>
			
			<input type='submit' value='Enviar dados'>
			
			<input type="reset" value='Limpar' style='margin-left: 15px;'><br><br>
		
	</fieldset>
	
	</form>

</body>
</html>