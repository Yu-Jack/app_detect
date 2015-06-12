@extends('head')

@section('content')
<style>
	.black{
		height: 100%;
		padding:0px;
	}
	.background{
		height: 100%;
		background: url('background.jpg') center center;
		background-size:cover;
		opacity: 0.2;
	}
	.div-center{
		position: absolute;
		text-align: center;
		top: 50%;
		left: 50%;
		margin-left: -77px;
		margin-top: -48px;
	}
	.progress-position{
		position: absolute;
		top:50%;
		margin-top: 60px;
	}
	.spinner {
	  position: absolute;
	  top:50%;
	  left: 50%;
	  margin: 100px auto;
	  width: 70px;
	  height: 30px;
	  text-align: center;
	  font-size: 25px;
	  margin-left: -35px;
	}

	.spinner > div {
	  background-color: #333;
	  height: 100%;
	  width: 6px;
	  display: inline-block;
	  
	  -webkit-animation: stretchdelay 1.2s infinite ease-in-out;
	  animation: stretchdelay 1.2s infinite ease-in-out;
	}

	.spinner .rect2 {
	  -webkit-animation-delay: -1.1s;
	  animation-delay: -1.1s;
	}

	.spinner .rect3 {
	  -webkit-animation-delay: -1.0s;
	  animation-delay: -1.0s;
	}

	.spinner .rect4 {
	  -webkit-animation-delay: -0.9s;
	  animation-delay: -0.9s;
	}

	.spinner .rect5 {
	  -webkit-animation-delay: -0.8s;
	  animation-delay: -0.8s;
	}

	@-webkit-keyframes stretchdelay {
	  0%, 40%, 100% { -webkit-transform: scaleY(0.4) }  
	  20% { -webkit-transform: scaleY(1.0) }
	}

	@keyframes stretchdelay {
	  0%, 40%, 100% { 
	    transform: scaleY(0.4);
	    -webkit-transform: scaleY(0.4);
	  }  20% { 
	    transform: scaleY(1.0);
	    -webkit-transform: scaleY(1.0);
	  }
	}
</style>
	<div class="container-fluid black">
		<div class="background"></div>
		<div class="div-center">
			<h2>APP Detect</h2>
			<span class="btn btn-success fileinput-button">
		        <i class="glyphicon glyphicon-plus"></i>
		        <span>Select files...</span>
		        <!-- The file input field used as target for the file upload widget -->
		        <input id="fileupload" type="file" name="apk">
		    </span>
	    </div>
	    <div class="col-xs-10 col-xs-offset-1 col-md-8 col-md-offset-2 col-lg-6 col-lg-offset-3 progress-position" style="display:none;">
		    <div id="progress" class="progress">
			    <div class="progress-bar progress-bar-success bar"></div>
			</div>
		</div>
		<div class="spinner" style="display:none;">
		  <div class="rect1"></div>
		  <div class="rect2"></div>
		  <div class="rect3"></div>
		  <div class="rect4"></div>
		  <div class="rect5"></div>
		</div>
	</div>

	<script>
	$('#fileupload').fileupload({
		url: '/upload',
		done: function (e, data) {
			if(data.result == 'success'){
				window.location = '/result';
			}else{
				alert('please upload again');
			}
		},
		start: function (){
			$('.progress-position').css('display', '');
		},
		progressall: function  (e, data) {
			var progress = parseInt(data.loaded / data.total * 100, 10);
			$('#progress  .bar').css('width', progress + '%');
			if(progress == 100){
				$('.bar').html('Success to upload, wait for system');
				$('#fileupload').attr('disabled', 'disabled');
				$('.fileinput-button').addClass('btn-danger');
				$('.spinner').css('display','');
			}
		}
	});
	</script>
@stop