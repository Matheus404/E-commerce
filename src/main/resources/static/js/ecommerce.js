$('.cpf').mask('000.000.000-00', {reverse: true});
$(".numeric").numeric();
$('.datepicker').datepicker({
	language: 'pt-BR',
	format: "dd-mm-yyyy",
	todayHighlight: true,
	});

var deletarCliente = function(id){
	
	swal({
		  title: "Tem certeza?",
		  text: "Todas as informações do cliente e seu histórico serão deletados.",
		  type: "warning",
		  showCancelButton: true,
		  confirmButtonClass: "btn-danger",
		  confirmButtonText: "Sim, Deletar!",
		  cancelButtonText: "Não",
		  closeOnConfirm: false
		},
		function(){
			var response = $.ajax({
			    url: '/Admin/Cliente/Excluir/'+id,
			    type: 'GET'
			});
			
			response.done(function (deleted){
				if(deleted){
					swal("Sucesso", "Cliente excluido com sucesso", "success");
					location.reload();									
				}else{
					swal("Erro", "Um erro ocorreu, contacte o adminstrador", "error")
				}
				
			});
		});
	
}
