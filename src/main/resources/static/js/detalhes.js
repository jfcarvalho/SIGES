$('#detalhesSala').on('show.bs.modal', function(event)
		{
			var button = $(event.relatedTarget);
			var codigoSala = button.data('id_sala');
			var numero = button.data('numero');
			var departamento = button.data('departamento');
			var instituto = button.data('instituto');
			var tipo = button.data('tipo');
			var situacao = button.data('situacao');
			var capacidade = button.data('capacidade');
			
			
			var modal = $(this);
			var form = modal.find('form');
			var action = form.data('url-base');
			if(!action.endsWith('/'))
				{
					action += '/';
				}
			
				form.attr('action', action + codigoSala);
				
				modal.find('.modal-body span').html('<p><b>Número de sala:</b><i> '+ numero +'</p></i> <b><p>Departamento:</b><i> '+ departamento + '</i></p><p><b>Instituto:</b><i> '+ instituto + '</i></p><b><p>Tipo de sala:</b><i> '+ tipo +'</i></p><p><b>Situação: </b><i>'+ situacao + '</i></p><p><b>Capacidade: </b><i>'+ capacidade + '</i></p>');
			
});