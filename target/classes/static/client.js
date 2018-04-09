$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

$(document).ready(function(){
    
    
    $("#computeBtn").click(function (){
    	console.log("Pega informacoes do form");
    	
    })
    
    $(".panel-body").click(function(event){
    	if( event.target.id === "l1"){
    		$.get("/cardapio/XBACON", function (data){
    			preco = "R$" + data;
        		$("#result").text(preco);
    	    });
    	}
    	if( event.target.id === "l2"){
    		$.get("/cardapio/XBURGER", function (data){
    			preco = "R$" + data;
        		$("#result").text(preco);
    	    });
    	}
    	if( event.target.id === "l3"){
    		$.get("/cardapio/XEGG", function (data){
    			preco = "R$" + data;
        		$("#result").text(preco);
    	    });
    	}
    	if( event.target.id === "l4"){
    		$.get("/cardapio/XEBACON", function (data){
    			preco = "R$" + data;
        		$("#result").text(preco);
    	    });
    	}
    });
    
    $('form').submit(function() {
    	$.ajax({
            type: "POST",
            url: "/preco",
            data: JSON.stringify($('form').serializeObject()),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function(data){
            		preco = "R$" + data;
            		$("#result").text(preco);
            	},
            failure: function(errMsg) {
                alert(errMsg);
            }
        });
        return false;
    });
    
    
});