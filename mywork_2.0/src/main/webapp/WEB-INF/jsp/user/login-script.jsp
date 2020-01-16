<%@ page contentType="text/html;charset=UTF-8" import="java.util.*"%>
<%@ include file="/common/currency.jsp"%>

<script type="text/javascript">
var isValidation = false;

jQuery(document).ready(function() {
	
    $('#inputForm').submit(function(){
        var username = $(this).find('.username').val();
        var password = $(this).find('.password').val();
        if(isValidation==false){
        	$("#login-error").text("请进行验证!");
        	return false;
        }
        if(username == '') {
            $(this).find('.error').fadeOut('fast', function(){
                $(this).css('top', '27px');
            });
            $(this).find('.error').fadeIn('fast', function(){
                $(this).parent().find('.username').focus();
            });
            return false;
        }
        if(password == '') {
            $(this).find('.error').fadeOut('fast', function(){
                $(this).css('top', '96px');
            });
            $(this).find('.error').fadeIn('fast', function(){
                $(this).parent().find('.password').focus();
            });
            return false;
        }
    });

    $('.page-container form .username, .page-container form .password').keyup(function(){
        $(this).parent().find('.error').fadeOut('fast');
    });

});
</script>
