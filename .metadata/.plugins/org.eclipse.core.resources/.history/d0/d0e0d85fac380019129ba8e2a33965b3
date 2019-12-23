<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<link rel="stylesheet" type="text/css" href="teste.css" media="all" />
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

	<script type="text/javascript" src="js/jquery-1.2.6.pack.js"></script>
	<script type="text/javascript" src="js/jquery.maskedinput-1.1.4.pack.js"/></script>
	
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
	<link href="http://fonts.googleapis.com/css?family=Cookie" rel="stylesheet" type="text/css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>FASTLAV - Cadastro Usuário</title>

<script type="text/javascript">
		function mascaratell(o,f){
			v_obj=o
			v_fun=f
			setTimeout("execmascara()",1)
		}
		function execmascara(){
			v_obj.value=v_fun(v_obj.value)
		}
		function mtel(v){
		    v=v.replace(/\D/g,"");             //Remove tudo o que não é dígito
		    v=v.replace(/^(\d{2})(\d)/g,"($1) $2"); //Coloca parênteses em volta dos dois primeiros dígitos
		    v=v.replace(/(\d)(\d{4})$/,"$1-$2");    //Coloca hífen entre o quarto e o quinto dígitos
		    return v;
		}
	
		function fMasc(objeto,mascara) {
			obj=objeto
			masc=mascara
			setTimeout("fMascEx()",1)
		}
		function fMascEx() {
			obj.value=masc(obj.value)
		}
	
		function mCPF(cpf){
			cpf=cpf.replace(/\D/g,"")
			cpf=cpf.replace(/(\d{3})(\d)/,"$1.$2")
			cpf=cpf.replace(/(\d{3})(\d)/,"$1.$2")
			cpf=cpf.replace(/(\d{3})(\d{1,2})$/,"$1-$2")
			return cpf
		}
		function mCNPJ(cnpj){
			cnpj=cnpj.replace(/\D/g,"")
			cnpj=cnpj.replace(/^(\d{2})(\d)/,"$1.$2")
			cnpj=cnpj.replace(/^(\d{2}).(\d{3})(\d)/,"$1.$2.$3")
			cnpj=cnpj.replace(/.(\d{3})(\d)/,".$1/$2")
			cnpj=cnpj.replace(/(\d{4})(\d)/,"$1-$2")
			return cnpj
		}
	
		function mCEP(cep){
			cep=cep.replace(/\D/g,"")
			cep=cep.replace(/^(\d{2})(\d)/,"$1.$2")
			cep=cep.replace(/.(\d{3})(\d)/,".$1-$2")
			return cep
		}
		
		function validar(){
			var nomeresponsavel = form.nomeresponsavel.value;
			var uf = form.uf.value;
			
			if (nomeresponsavel.length < 10) {
				alert('Digite seu nome completo');
				form.nomeresponsavel.focus();
				return false;
			}
			
			if (uf.length != 2) {
				alert('Digite apenas sigla do estado. Ex: RJ');
				form.uf.focus();
				return false;
			}
		}
		
	function myFunction() {
		    var x = document.getElementById("fname");
		    x.value = x.value.toUpperCase();
		}
		
		// Example starter JavaScript for disabling form submissions if there are invalid fields
		(function() {
		  'use strict';
		  window.addEventListener('load', function() {
		    // Fetch all the forms we want to apply custom Bootstrap validation styles to
		    var forms = document.getElementsByClassName('needs-validation');
		    // Loop over them and prevent submission
		    var validation = Array.prototype.filter.call(forms, function(form) {
		      form.addEventListener('submit', function(event) {
		        if (form.checkValidity() === false) {
		          event.preventDefault();
		          event.stopPropagation();
		        }
		        form.classList.add('was-validated');
		      }, false);
		    });
		  }, false);
		})();		
	</script>

</head>

<body>

	<div class="jumbotron text-center"  style="padding: 60px; background-color: #ffffff; color: #008B8B;">
		<h1>CADASTRO DE EMPRESA</h1> 
	</div>

	<div class="container" id="inicio">
	
		<form id="myform" 	name="form" action = "CadastroServlet" method = "POST" class="needs-validation" novalidate>

			<div class="row">
				<div class="col-sm-6">
					<div class="card" style="border-color: #ffffff;">
						<div class="card-body">

							<div class="form-group col-md-10">
								<label for="inputNome">Nome Empresa</label>
								<input type="text" name="nome_empresa" class="form-control" id="nome_empresa" placeholder="Nome Empresa" required >
								<div class="invalid-tooltip">
									Campo obrigatorio.
								</div>
							</div>

							<div class="form-group col-md-10">
								<label for="inputNomeResponsavel">Nome do Responsável</label>
								<input type="text" name="nome_responsavel" class="form-control" id="nome_responsavel" placeholder="Nome do Responsável" required>
								<div class="invalid-tooltip">
									Campo obrigatorio.
								</div>
							</div>
	
							<div class="form-group col-md-10">
								<label for="inputTelefone">Telefone</label>
								<input type="tel" name="telefone" class="form-control" id="telefone	" placeholder="(00) 00000-0000" name="telefone" onkeyup="mascaratell( this, mtel );" maxlength="15" required>
								<div class="invalid-tooltip">
									Campo obrigatorio.
								</div>
							</div>

							<div class="form-group col-md-10" style="margin-top: 90px;">
								<label for="inputBairro">Bairro</label>
								<input type="text" name="bairro" class="form-control" id="bairro" placeholder="Bairro">
							</div>

							<div class="form-group col-md-10">
								<label for="inputCidade">Cidade</label>
								<input type="text" name="cidade" class="form-control" id="cidade" placeholder="Cidade">
							</div>
						</div>
					</div>
				</div>


				<div class="col-sm-6">
					<div class="card" style="border-color: #ffffff;">
						<div class="card-body">

							<div class="form-group col-md-8">
								<label for="inputRazaoSocial">Razão Social</label>
								<input type="text" name="razaosocial" class="form-control" id="razaosocial" placeholder="Razão Social" required>
								<div class="invalid-tooltip">
									Campo obrigatorio.
								</div>
							</div>

							<div class="form-group col-md-8">
								<label for="inputCpf">CPF do Responsável</label>
								<input type="text" name="cpf_responsavel" class="form-control" id="cpf_responsavel" placeholder="000.000.000-00" onkeyup="fMasc(this, mCPF);" maxlength="14" required>
								<div class="invalid-tooltip">
									Campo obrigatorio.
								</div>
							</div>

							<div class="form-group col-md-10">
								<label for="inputCnpj">CNPJ</label>
								<input type="text" name="cnpj" class="form-control" id="cnpj" placeholder="00.000.000/0000-00" name="cnpj" onkeyup="fMasc(this, mCNPJ);" maxlength="18" required>
								<div class="invalid-tooltip">
									Campo obrigatorio.
								</div>
							</div>


							<div class="form-group col-md-8" style="margin-top: 90px;">
								<label for="inputEmail4">Rua</label>
								<input type="text" name="rua" class="form-control" id="rua" placeholder="Rua">
							</div>

							<div class="form-group col-md-8">
								<label for="inputcep">CEP</label>
								<input type="text" name="cep" class="form-control" id="cep" placeholder="00.000-000" onkeyup="fMasc(this, mCEP);" maxlength="10" required>
								<div class="invalid-tooltip">
									Campo obrigatorio.
								</div>
							</div>
							
							<div class="form-group col-md-8">
								<label for="inputUf">UF</label>
								<input type="text" name="estado" class="form-control" id="fname" onchange="myFunction()" placeholder="PE">
							</div>

						</div>
					</div>
				</div>
			</div>

			<br><br><br><div class="container-fluid" style="text-align: center; height: 150px;">

				<button class="btn btn-primary" type="submit" style="background-color: #000000;">CANCELAR</button>
				<button class="btn btn-primary" onclick="return validar()" type="submit" href="#" style="background-color: #0000FF;">CADASTRAR</button>
			</div>
		</form>
	</div>

</body>
</html>