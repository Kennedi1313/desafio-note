/**
 * 
 */

jQuery(function($){
	$('.telefone').mask('(00) 0 0000-0000');
	$('.cnpj').mask('00.000.000/0000-00');
	$('.cep').mask('00000-000');
	$('.dinheiro').mask('#.##0,00', {reverse: true});
	$('.estado').mask('AA');
	$('.cpf').mask('000-000.000-00');
	$('.rg').mask('00.000.000-0');
	$('.data').mask('00/00/0000');
	$('.placaCarro').mask('AAA-0000');
	$('.horasMinutos').mask('00:00');
	$('.cartaoCredito').mask('0000 0000 0000 0000');
	$('.numero').mask('00000');
	
	
	
	$('.datepicker').datepicker({	
		format: "dd/mm/yyyy",	
		language: "pt-BR",
		startDate: '+0d',
	});
	
});

$(document).ready(function() {
	
	$('.big-icons').hover(function() {
		 $( this ).removeClass( 'hover-big-icons' );
	}, function() {
		 $( this ).addClass( 'hover-big-icons' );
	});
	
}); 
